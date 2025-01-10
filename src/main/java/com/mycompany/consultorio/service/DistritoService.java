package com.mycompany.consultorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mycompany.consultorio.dto.DistritoDTO;
import com.mycompany.consultorio.model.Distrito;
import com.mycompany.consultorio.repository.DistritoRepository;

@Service
public class DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    public Page<Distrito> listarTodos(Pageable pageable) {
        return distritoRepository.findAll(pageable);
    }

    public Page<DistritoDTO> listarPorProvincia(Integer id, Pageable pageable) {
        return distritoRepository.findByProvinciaIdProvincia(id, pageable)
                .map(DistritoDTO::fromEntity);
    }

    public Distrito guardar(Distrito distrito) {
        return distritoRepository.save(distrito);
    }

    public Distrito editar(Integer id, Distrito distritoActualizado) {
        Distrito distritoExistente = distritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Distrito no encontrado."));

        distritoExistente.setDescripcion(distritoActualizado.getDescripcion());
        distritoExistente.setProvincia(distritoActualizado.getProvincia());
        return distritoRepository.save(distritoExistente);
    }

    public Distrito buscarPorId(Integer id) {
        return distritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Distrito no encontrado."));
    }

    public void eliminar(Integer id) {
        Distrito distrito = distritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Distrito no encontrado."));

        distritoRepository.delete(distrito);
    }

    public Distrito buscarPorDescripcion(String descripcion) {
        return distritoRepository.findByDescripcion(descripcion)
                .orElseThrow(() -> new RuntimeException("Distrito no encontrado."));
    }

}
