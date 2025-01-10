package com.mycompany.consultorio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mycompany.consultorio.model.Departamento;
import com.mycompany.consultorio.repository.DepartamentoRepository;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Page<Departamento> listarTodos(Pageable pageable) {
        return departamentoRepository.findAll(pageable);
    }

    public Departamento guardar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public Departamento editar(Integer id, Departamento departamentoActualizado) {
        Departamento departamentoExistente = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado."));

        departamentoExistente.setDescripcion(departamentoActualizado.getDescripcion());
        return departamentoRepository.save(departamentoExistente);
    }

    public Departamento buscarPorId(Integer id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
    }

    public void eliminar(Integer id) {
        Departamento departamento = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado."));

        departamentoRepository.delete(departamento);
    }

    public Departamento buscarPorDescripcion(String descripcion) {
        return departamentoRepository.findByDescripcion(descripcion)
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado."));
    }
    
}
