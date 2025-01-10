package com.mycompany.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.mycompany.consultorio.dto.ProvinciaDTO;
import com.mycompany.consultorio.model.Provincia;
import com.mycompany.consultorio.service.ProvinciaService;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping
    public Page<ProvinciaDTO> listarTodos(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return provinciaService.listarTodos(pageable).map(ProvinciaDTO::fromEntity);
    }

    @GetMapping("/departamento/{id}")
    public Page<ProvinciaDTO> listarProvinciasPorDepartamento(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {
        return provinciaService.listarPorDepartamento(id, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public ProvinciaDTO buscarPorId(@PathVariable Integer id) {
        Provincia provincia = provinciaService.buscarPorId(id);
        return ProvinciaDTO.fromEntity(provincia);
    }

    @PostMapping
    public ProvinciaDTO guardar(@RequestBody ProvinciaDTO provinciaDTO) {
        Provincia provincia = provinciaDTO.toEntity();
        Provincia provinciaGuardada = provinciaService.guardar(provincia);
        return ProvinciaDTO.fromEntity(provinciaGuardada);
    }

    @PutMapping("/editar/{id}")
    public ProvinciaDTO editar(@PathVariable Integer id, @RequestBody ProvinciaDTO provinciaDTO) {
        Provincia provincia = provinciaDTO.toEntity();
        Provincia provinciaEditada = provinciaService.editar(id, provincia);
        return ProvinciaDTO.fromEntity(provinciaEditada);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Integer id) {
        provinciaService.eliminar(id);
    }

    @GetMapping("/descripcion/{descripcion}")
    public ProvinciaDTO buscarPorDescripcion(@PathVariable String descripcion) {
        Provincia provincia = provinciaService.buscarPorDescripcion(descripcion);
        return ProvinciaDTO.fromEntity(provincia);
    }

}
