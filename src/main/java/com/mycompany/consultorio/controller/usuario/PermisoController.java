package com.mycompany.consultorio.controller.usuario;

import com.mycompany.consultorio.dto.usuario.PermisoDTO;
import com.mycompany.consultorio.model.usuario.Permiso;
import com.mycompany.consultorio.service.usuario.PermisoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public List<PermisoDTO> listarTodos() {
        return permisoService.listarTodos().stream()
                .map(PermisoDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PermisoDTO buscarPorId(@PathVariable int id) {
        Permiso permiso = permisoService.buscarPorId(id);
        return PermisoDTO.fromEntity(permiso);
    }

    @PostMapping
    public PermisoDTO guardar(@RequestBody PermisoDTO permisoDTO) {
        Permiso permiso = permisoDTO.toEntity();
        Permiso permisoGuardado = permisoService.guardar(permiso);
        return PermisoDTO.fromEntity(permisoGuardado);
    }

    @PutMapping("/editar/{id}")
    public PermisoDTO editar(@PathVariable int id, @RequestBody PermisoDTO permisoDTO) {
        Permiso permiso = permisoDTO.toEntity();
        
        Permiso permisoEditado = permisoService.editar(id, permiso);
        return PermisoDTO.fromEntity(permisoEditado);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable int id) {
        permisoService.eliminarPorId(id);
    }

    @GetMapping("/buscar-descripcion")
    public PermisoDTO buscarPorDescripcion(@RequestParam String descripcion) {
        Permiso permiso = permisoService.buscarPorDescripcion(descripcion);
        return PermisoDTO.fromEntity(permiso);
    }
}
