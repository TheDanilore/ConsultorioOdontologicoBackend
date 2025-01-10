package com.mycompany.consultorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mycompany.consultorio.dto.ProvinciaDTO;
import com.mycompany.consultorio.model.Provincia;
import com.mycompany.consultorio.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public Page<Provincia> listarTodos(Pageable pageable) {
        return provinciaRepository.findAll(pageable);
    }

    public Page<ProvinciaDTO> listarPorDepartamento(Integer id, Pageable pageable) {
        return provinciaRepository.findByDepartamentoIdDepartamento(id, pageable)
                .map(ProvinciaDTO::fromEntity);
    }

    public Provincia guardar(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    public Provincia editar(Integer id, Provincia provinciaActualizado) {
        Provincia provinciaExistente = provinciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provincia no encontrado."));

        provinciaExistente.setDescripcion(provinciaActualizado.getDescripcion());
        provinciaExistente.setDepartamento(provinciaActualizado.getDepartamento());
        return provinciaRepository.save(provinciaExistente);
    }

    public Provincia buscarPorId(Integer id) {
        return provinciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provincia no encontrado."));
    }

    public void eliminar(Integer id) {
        Provincia provincia = provinciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provincia no encontrado."));

        provinciaRepository.delete(provincia);
    }

    public Provincia buscarPorDescripcion(String descripcion) {
        return provinciaRepository.findByDescripcion(descripcion)
                .orElseThrow(() -> new RuntimeException("Provincia no encontrado."));
    }

    public Provincia buscarPorIdConDepartamento(Integer id) {
        return provinciaRepository.findByIdConDepartamento(id)
                .orElseThrow(() -> new RuntimeException("Provincia no encontrado."));
    }
}
