package com.mycompany.consultorio.repository;

import com.mycompany.consultorio.model.Persona;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    // Métodos personalizados
    Persona findByCorreo(String correo); // Busca una persona por su correo
    List<Persona> findByNombres(String nombres); // Busca una persona por su nombre
    List<Persona> findByApellidos(String apellidos); // Busca una persona por su apellido
    List<Persona> findByNombresAndApellidos(String nombres, String apellidos); // Busca una persona por su nombre y apellido
    List<Persona> findByNombresContaining(String fragmento); // Busca una persona por un fragmento de su nombre
    List<Persona> findByApellidosContaining(String fragmento); // Busca una persona por un fragmento de su apellido
}
