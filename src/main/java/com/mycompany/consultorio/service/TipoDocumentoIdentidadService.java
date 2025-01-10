package com.mycompany.consultorio.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.consultorio.exception.DAOException;
import com.mycompany.consultorio.model.TipoDocumentoIdentidad;
import com.mycompany.consultorio.repository.TipoDocumentoIdentidadRepository;

@Service
public class TipoDocumentoIdentidadService {

    @Autowired
    private TipoDocumentoIdentidadRepository tipoDocumentoIdentidadRepository;

    public Page<TipoDocumentoIdentidad> listarTodos(Pageable pageable) {
        return tipoDocumentoIdentidadRepository.findAll(pageable);
    }

    public TipoDocumentoIdentidad guardar(TipoDocumentoIdentidad tipoDocumentoIdentidad) {
        if (tipoDocumentoIdentidadRepository.findByAbreviatura(tipoDocumentoIdentidad.getAbreviatura()).isPresent()) {
            throw new DAOException("La abreviatura ya está registrado.");
        }

        if (tipoDocumentoIdentidadRepository.findByDescripcion(tipoDocumentoIdentidad.getDescripcion()).isPresent()) {
            throw new DAOException("La descripcion ya está registrado.");
        }

        tipoDocumentoIdentidad.setCreated_at(LocalDateTime.now());
        return tipoDocumentoIdentidadRepository.save(tipoDocumentoIdentidad);
    }

    public TipoDocumentoIdentidad editar(String id, TipoDocumentoIdentidad tipoDocumentoIdentidadActualizado) {
        TipoDocumentoIdentidad tipoDocumentoIdentidadExistente = tipoDocumentoIdentidadRepository.findById(id)
                .orElseThrow(() -> new DAOException("Tipo de documento de identidad no encontrado."));

        tipoDocumentoIdentidadExistente.setAbreviatura(tipoDocumentoIdentidadActualizado.getAbreviatura());
        tipoDocumentoIdentidadExistente.setDescripcion(tipoDocumentoIdentidadActualizado.getDescripcion());
        tipoDocumentoIdentidadExistente.setUpdated_at(LocalDateTime.now());

        return tipoDocumentoIdentidadRepository.save(tipoDocumentoIdentidadExistente);
    }

    public TipoDocumentoIdentidad buscarPorId(String id) {
        return tipoDocumentoIdentidadRepository.findById(id)
                .orElseThrow(() -> new DAOException("Tipo de documento de identidad no encontrado."));
    }

    public void eliminar(String id) {
        TipoDocumentoIdentidad tipoDocumentoIdentidad = tipoDocumentoIdentidadRepository.findById(id)
                .orElseThrow(() -> new DAOException("Tipo de documento de identidad no encontrado."));

        tipoDocumentoIdentidadRepository.delete(tipoDocumentoIdentidad);
    }

    public TipoDocumentoIdentidad buscarPorAbreviatura(String abreviatura) {
        return tipoDocumentoIdentidadRepository.findByAbreviatura(abreviatura)
                .orElseThrow(() -> new DAOException("Tipo de documento de identidad no encontrado."));
    }

    public TipoDocumentoIdentidad buscarPorDescripcion(String descripcion) {
        return tipoDocumentoIdentidadRepository.findByDescripcion(descripcion)
                .orElseThrow(() -> new DAOException("Tipo de documento de identidad no encontrado."));
    }

}
