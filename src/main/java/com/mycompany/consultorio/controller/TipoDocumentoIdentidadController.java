package com.mycompany.consultorio.controller;

import com.mycompany.consultorio.dto.TipoDocumentoIdentidadDTO;
import com.mycompany.consultorio.model.TipoDocumentoIdentidad;
import com.mycompany.consultorio.service.TipoDocumentoIdentidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/tipodocumentoidentidad")
public class TipoDocumentoIdentidadController {

    @Autowired // Inyección de dependencias
    private TipoDocumentoIdentidadService tipoDocumentoIdentidadService;

    @GetMapping
    public Page<TipoDocumentoIdentidadDTO> listarTodos(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tipoDocumentoIdentidadService.listarTodos(pageable).map(TipoDocumentoIdentidadDTO::fromEntity);
    }

    // Buscar un tipo de documento de identidad por ID
    @GetMapping("/{id}")
    public TipoDocumentoIdentidadDTO buscarPorId(@PathVariable String id) {
        TipoDocumentoIdentidad tipoDocumentoIdentidad = tipoDocumentoIdentidadService.buscarPorId(id);
        return TipoDocumentoIdentidadDTO.fromEntity(tipoDocumentoIdentidad); // Convierte a DTO antes de devolverlo
    }

    // Guardar un nuevo tipo de documento de identidad
    @PostMapping
    public TipoDocumentoIdentidadDTO guardar(@RequestBody TipoDocumentoIdentidadDTO tipoDocumentoIdentidadDTO) {
        TipoDocumentoIdentidad tipoDocumentoIdentidad = tipoDocumentoIdentidadDTO.toEntity(); // Convierte DTO a entidad
        TipoDocumentoIdentidad tipoDocumentoIdentidadGuardado = tipoDocumentoIdentidadService
                .guardar(tipoDocumentoIdentidad); // Guarda la entidad
        return TipoDocumentoIdentidadDTO.fromEntity(tipoDocumentoIdentidadGuardado);
    }

    // Editar un tipo de documento de identidad existente
    @PutMapping("/editar/{id}")
    public TipoDocumentoIdentidadDTO editar(@PathVariable String id,
            @RequestBody TipoDocumentoIdentidadDTO tipoDocumentoIdentidadDTO) {
        TipoDocumentoIdentidad tipoDocumentoIdentidad = tipoDocumentoIdentidadDTO.toEntity(); // Convierte DTO a entidad
        TipoDocumentoIdentidad tipoDocumentoIdentidadEditado = tipoDocumentoIdentidadService.editar(id,
                tipoDocumentoIdentidad); // Edita la entidad
        return TipoDocumentoIdentidadDTO.fromEntity(tipoDocumentoIdentidadEditado);
    }

    // Eliminar un tipo de documento de identidad
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        tipoDocumentoIdentidadService.eliminar(id);
    }

    @GetMapping("/buscar-abreviatura")
    public TipoDocumentoIdentidadDTO buscarPorAbreviatura(@RequestParam String abreviatura) {
        TipoDocumentoIdentidad tipoDocumentoIdentidad = tipoDocumentoIdentidadService.buscarPorAbreviatura(abreviatura);
        return TipoDocumentoIdentidadDTO.fromEntity(tipoDocumentoIdentidad);
    }

    @GetMapping("/buscar-descripcion")
    public TipoDocumentoIdentidadDTO buscarPorDescripcion(@RequestParam String descripcion) {
        TipoDocumentoIdentidad tipoDocumentoIdentidad = tipoDocumentoIdentidadService.buscarPorDescripcion(descripcion);
        return TipoDocumentoIdentidadDTO.fromEntity(tipoDocumentoIdentidad);
    }
}
