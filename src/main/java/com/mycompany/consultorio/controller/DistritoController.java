package com.mycompany.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import com.mycompany.consultorio.dto.DistritoDTO;
import com.mycompany.consultorio.model.Distrito;
import com.mycompany.consultorio.service.DistritoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/distritos")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping
    public Page<DistritoDTO> listarTodos(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return distritoService.listarTodos(pageable).map(DistritoDTO::fromEntity);
    }

    @GetMapping("/provincia/{id}")
    public Page<DistritoDTO> listarDistritosPorProvincia(
            @PathVariable Integer id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {
        return distritoService.listarPorProvincia(id, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public DistritoDTO buscarPorId(@PathVariable Integer id) {
        return DistritoDTO.fromEntity(distritoService.buscarPorId(id));
    }

    @PostMapping
    public DistritoDTO guardar(@RequestBody DistritoDTO distritoDTO) {
        Distrito distrito = distritoDTO.toEntity();
        Distrito distritoGuardado = distritoService.guardar(distrito);
        return DistritoDTO.fromEntity(distritoGuardado);
    }

    @PutMapping("/editar/{id}")
    public DistritoDTO editar(@PathVariable Integer id, @RequestBody DistritoDTO distritoDTO) {
        Distrito distrito = distritoDTO.toEntity();
        Distrito distritoEditado = distritoService.editar(id, distrito);
        return DistritoDTO.fromEntity(distritoEditado);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Integer id) {
        distritoService.eliminar(id);
    }

    @GetMapping("/descripcion/{descripcion}")
    public DistritoDTO buscarPorDescripcion(@PathVariable String descripcion) {
        return DistritoDTO.fromEntity(distritoService.buscarPorDescripcion(descripcion));
    }

}
