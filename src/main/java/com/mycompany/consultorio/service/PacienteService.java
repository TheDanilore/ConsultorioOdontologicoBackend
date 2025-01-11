package com.mycompany.consultorio.service;

import com.mycompany.consultorio.exception.DAOException;
import com.mycompany.consultorio.model.Paciente;
import com.mycompany.consultorio.model.Persona;
import com.mycompany.consultorio.repository.PacienteRepository;
import com.mycompany.consultorio.repository.PersonaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {

    @Autowired // Inyección de dependencias
    private PacienteRepository pacienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public Page<Paciente> listarTodos(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new DAOException("El Paciente con ID: " + id + " no existe"));
    }

    public Paciente guardar(Paciente paciente) {
        Persona persona = paciente.getPersona();
        if (persona == null) {
            throw new DAOException("La persona asociada no puede ser nula.");
        }

        // Verificar si la persona ya existe
        Optional<Persona> personaExistente = personaRepository.findByCorreoOrNumeroDocumentoOrTelefono(
                persona.getCorreo(), persona.getNumeroDocumento(), persona.getTelefono());

        if (personaExistente.isPresent()) {
            // Si la persona ya existe, verificar si ya está asociada a un paciente
            Optional<Paciente> pacienteExistente = pacienteRepository.findByPersona(personaExistente.get());
            if (pacienteExistente.isPresent()) {
                throw new DAOException("El paciente ya está registrado.");
            }

            // Asociar la persona existente al nuevo paciente
            paciente.setPersona(personaExistente.get());
        } else {
            // Si la persona no existe, guardarla antes de asociarla al paciente
            persona.setCreated_at(LocalDateTime.now());
            persona = personaRepository.save(persona);
            paciente.setPersona(persona);
        }

        paciente.setCreated_at(LocalDateTime.now());
        return pacienteRepository.save(paciente);
    }

    public Paciente editar(Long id, Paciente pacienteActualizado) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new DAOException("Paciente no encontrado"));

        Persona personaActualizada = pacienteActualizado.getPersona();
        Persona personaExistente = personaRepository.findByCorreoOrNumeroDocumentoOrTelefono(
                personaActualizada.getCorreo(),
                personaActualizada.getNumeroDocumento(),
                personaActualizada.getTelefono()).orElse(null);

        // Si la persona existe y es distinta de la actual
        if (personaExistente != null && !personaExistente.getId().equals(pacienteExistente.getPersona().getId())) {
            // Asociar con una persona existente (distinta de la actual)
            pacienteExistente.setPersona(personaExistente);
        } else {
            // Actualizar los datos de la persona asociada
            personaActualizada.setUpdated_at(LocalDateTime.now());
            personaRepository.save(personaActualizada);
        }

        pacienteExistente.setUpdated_at(LocalDateTime.now());
        return pacienteRepository.save(pacienteExistente);
    }

    public void eliminarPorId(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new DAOException("El Paciente con ID: " + id + " no existe");
        }
        pacienteRepository.deleteById(id);
    }

    public boolean personaExiste(Persona persona) {
        return pacienteRepository.existsByPersonaCorreoOrPersonaNumeroDocumentoOrPersonaTelefono(
                persona.getCorreo(),
                persona.getNumeroDocumento(),
                persona.getTelefono());
    }

    public Optional<Persona> validarPersonaExistente(Persona persona) {
        System.out.println("Buscando por: Correo=" + persona.getCorreo() + ", Documento=" + persona.getNumeroDocumento() + ", Teléfono=" + persona.getTelefono());
        Optional<Persona> resultado = personaRepository.findByCorreoOrNumeroDocumentoOrTelefono(
                persona.getCorreo(),
                persona.getNumeroDocumento(),
                persona.getTelefono());
    
        System.out.println("Resultado: " + resultado.orElse(null));
        return resultado;
    }
    
    

}
