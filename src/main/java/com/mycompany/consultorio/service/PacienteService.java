package com.mycompany.consultorio.service;

import com.mycompany.consultorio.exception.DAOException;
import com.mycompany.consultorio.model.Paciente;
import com.mycompany.consultorio.repository.PacienteRepository;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired // Inyección de dependencias
    private PacienteRepository pacienteRepository;

    public Page<Paciente> listarTodos(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }

    public Paciente guardar(Paciente paciente) {
        if (pacienteRepository.findByPersona(paciente.getPersona()).isPresent()) {
            throw new DAOException("El paciente ya está registrado.");
        }
        paciente.setCreated_at(LocalDateTime.now());
        return pacienteRepository.save(paciente);
    }

    public Paciente editar(Long id, Paciente pacienteActualizado) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new DAOException("Paciente no encontrado"));

        pacienteExistente.setPersona(pacienteActualizado.getPersona());
        pacienteExistente.setUpdated_at(LocalDateTime.now());
        return pacienteRepository.save(pacienteExistente);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new DAOException("El Paciente con ID: " + id + " no existe"));
    }

    public void eliminarPorId(Long id) {
        pacienteRepository.deleteById(id);
    }

}
