package com.mycompany.consultorio.controller.usuario;

import com.mycompany.consultorio.dto.usuario.RolDTO;
import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Rol;
import com.mycompany.consultorio.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<RolDTO> listarTodos() {
        return rolService.listarTodos().stream()
                .map(RolDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RolDTO buscarPorId(@PathVariable int id) {
        Rol rol = rolService.buscarPorId(id);
        return RolDTO.fromEntity(rol); // Convertir Usuario a UsuarioDTO
    }

    @PostMapping
    public RolDTO guardar(@RequestBody RolDTO rolDTO) {
        Rol rol = rolDTO.toEntity(); // Convertir RolDTO a Rol
        // Si no se envían permisos, asignar una lista vacía
        if (rol.getPermisos() == null || rol.getPermisos().isEmpty()) {
            rol.setPermisos(new HashSet<>());
        }

        Rol rolGuardado = rolService.guardar(rol);
        return RolDTO.fromEntity(rolGuardado); // Convertir Rol a RolDTO
    }

    // Editar un usuario existente
    @PutMapping("/editar/{id}")
    public RolDTO editar(@PathVariable int id, @RequestBody RolDTO rolDTO) {
        Rol rol = rolDTO.toEntity(); // Convertir RolDTO a Rol
        // Manejar el caso de permisos nulos o vacíos
        if (rol.getPermisos() == null || rol.getPermisos().isEmpty()) {
            rol.setPermisos(new HashSet<>());
        }

        Rol rolEditado = rolService.editar(id, rol);
        return RolDTO.fromEntity(rolEditado); // Convertir Rol a RolDTO
    }

    @PatchMapping("/cambiar-estado/{id}")
    public RolDTO cambiarEstado(@PathVariable int id, @RequestParam EstadoEnum nuevoEstado) {
        Rol rol = rolService.cambiarEstado(id, nuevoEstado);
        return RolDTO.fromEntity(rol); // Convertir Rol a RolDTO
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable int id) {
        rolService.eliminarPorId(id);
    }

    @GetMapping("/buscar-descripcion")
    public RolDTO buscarPorDescripcion(@RequestParam String descripcion) {
        Rol rol = rolService.buscarPorDescripcion(descripcion);
        return RolDTO.fromEntity(rol); // Convertir Usuario a UsuarioDTO
    }

}
