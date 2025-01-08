package com.mycompany.consultorio.controller.usuario;

import com.mycompany.consultorio.dto.RolDTO;
import com.mycompany.consultorio.dto.UsuarioDTO;
import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Rol;
import com.mycompany.consultorio.model.usuario.Usuario;
import com.mycompany.consultorio.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Rol guardar(@RequestBody Rol rol) {
        return rolService.guardar(rol);
    }

    @PutMapping("/editar/{id}")
    public Rol editar(@PathVariable int id, @RequestBody Rol rol) {
        return rolService.editar(id, rol);
    }

    @PatchMapping("/cambiar-estado/{id}")
    public Rol cambiarEstado(@PathVariable int id, @RequestParam EstadoEnum nuevoEstado) {
        return rolService.cambiarEstado(id, nuevoEstado);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable int id) {
        rolService.eliminarPorId(id);
    }

    @GetMapping("/buscar")
    public Rol buscarPorDescripcion(@RequestParam String descripcion) {
        return rolService.buscarPorDescripcion(descripcion);
    }
}
