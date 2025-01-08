package com.mycompany.consultorio.controller.usuario;

import com.mycompany.consultorio.model.usuario.Permiso;
import com.mycompany.consultorio.service.PermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    public List<Permiso> listarTodos() {
        return permisoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Permiso buscarPorId(@PathVariable int id) {
        return permisoService.buscarPorId(id);
    }

    @PostMapping
    public Permiso guardar(@RequestBody Permiso permiso) {
        return permisoService.guardar(permiso);
    }

    @PutMapping("/editar/{id}")
    public Permiso editar(@PathVariable int id, @RequestBody Permiso permiso) {
        return permisoService.editar(id, permiso);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable int id) {
        permisoService.eliminarPorId(id);
    }

    @GetMapping("/buscar")
    public Permiso buscarPorDescripcion(@RequestParam String descripcion) {
        return permisoService.buscarPorDescripcion(descripcion);
    }
}
