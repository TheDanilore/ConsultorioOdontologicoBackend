package com.mycompany.consultorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.mycompany.consultorio.dto.DepartamentoDTO;
import com.mycompany.consultorio.model.Departamento;
import com.mycompany.consultorio.service.DepartamentoService;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public Page<DepartamentoDTO> listarTodos(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "30") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return departamentoService.listarTodos(pageable).map(DepartamentoDTO::fromEntity);
    }

    @GetMapping("/{id}")
    public DepartamentoDTO buscarPorId(@PathVariable Integer id) {
        Departamento departamento = departamentoService.buscarPorId(id);
        return DepartamentoDTO.fromEntity(departamento);
    }

    @PostMapping
    public DepartamentoDTO guardar(@RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = departamentoDTO.toEntity();
        Departamento departamentoGuardado = departamentoService.guardar(departamento);
        return DepartamentoDTO.fromEntity(departamentoGuardado);
    }

    @PutMapping("/editar/{id}")
    public DepartamentoDTO editar(@PathVariable Integer id, @RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = departamentoDTO.toEntity();
        Departamento departamentoEditado = departamentoService.editar(id, departamento);
        return DepartamentoDTO.fromEntity(departamentoEditado);
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Integer id) {
        departamentoService.eliminar(id);
    }

    @GetMapping("/descripcion/{descripcion}")
    public DepartamentoDTO buscarPorDescripcion(@PathVariable String descripcion) {
        Departamento departamento = departamentoService.buscarPorDescripcion(descripcion);
        return DepartamentoDTO.fromEntity(departamento);
    }

}
