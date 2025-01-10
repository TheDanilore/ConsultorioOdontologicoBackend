package com.mycompany.consultorio.controller.usuario;

import com.mycompany.consultorio.dto.usuario.UsuarioDTO;
import com.mycompany.consultorio.model.usuario.Usuario;
import com.mycompany.consultorio.service.UsuarioService;
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
        UsuarioDTO usuarioDTO = UsuarioDTO.fromEntity(usuarioAutenticado); // Convertir a DTO
        return ResponseEntity.ok(usuarioDTO);
    }

}
