package com.mycompany.consultorio.controller.usuario;

import com.mycompany.consultorio.dto.PermisoDTO;
import com.mycompany.consultorio.dto.RolDTO;
import com.mycompany.consultorio.dto.UsuarioDTO;
import com.mycompany.consultorio.model.usuario.Usuario;
import com.mycompany.consultorio.service.UsuarioService;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Usuario credenciales) {
        Usuario usuarioAutenticado = usuarioService.autenticar(credenciales.getEmail(), credenciales.getPassword());

        // Crear un DTO para incluir roles
        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuarioAutenticado.getId(),
                usuarioAutenticado.getNombre(),
                usuarioAutenticado.getEmail(),
                usuarioAutenticado.getEstado(),
                usuarioAutenticado.getRoles().stream()
                        .map(rol -> new RolDTO(
                                rol.getId(),
                                rol.getDescripcion(),
                                rol.getEstado(),
                                rol.getPermisos().stream()
                                        .map(permiso -> new PermisoDTO(permiso.getId(), permiso.getDescripcion()))
                                        .collect(Collectors.toList())))
                        .collect(Collectors.toList()));
        return ResponseEntity.ok(usuarioDTO);
    }

}
