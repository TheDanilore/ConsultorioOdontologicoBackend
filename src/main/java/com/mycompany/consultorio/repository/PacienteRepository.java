package com.mycompany.consultorio.repository;

import com.mycompany.consultorio.model.Paciente;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    // // Métodos personalizados
    // Paciente findByCorreo(String correo); // Busca una paciente por su correo
    // List<Paciente> findByNombres(String nombres); // Busca una paciente por su nombre
    // List<Paciente> findByApellidos(String apellidos); // Busca una paciente por su apellido
    // List<Paciente> findByNombresAndApellidos(String nombres, String apellidos); // Busca una paciente por su nombre y apellido
    // List<Paciente> findByNombresContaining(String fragmento); // Busca una paciente por un fragmento de su nombre
    // List<Paciente> findByApellidosContaining(String fragmento); // Busca una paciente por un fragmento de su apellido
}