package com.mycompany.consultorio.repository;

import com.mycompany.consultorio.model.Paciente;
import com.mycompany.consultorio.model.Persona;

import java.util.Optional;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByPersona(Persona persona);

}