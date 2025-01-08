package com.mycompany.consultorio.service;

import com.mycompany.consultorio.model.Persona;
import com.mycompany.consultorio.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listarTodas() {
        return personaRepository.findAll();
    }

    public Persona guardar(Persona persona) {
        if (personaRepository.findByCorreo(persona.getCorreo()) != null) {
            throw new RuntimeException("El correo ya está registrado.");
        }
        return personaRepository.save(persona);
    }

    public Persona buscarPorId(int id) {
        return personaRepository.findById(id).orElse(null);
    }

    public void eliminarPorId(int id) {
        personaRepository.deleteById(id);
    }

    // Métodos personalizados
    public Persona buscarPorCorreo(String correo) {
        return personaRepository.findByCorreo(correo);
    }

    public List<Persona> buscarPorNombres(String nombres) {
        return personaRepository.findByNombres(nombres);
    }

    public List<Persona> buscarPorApellidos(String apellidos) {
        return personaRepository.findByApellidos(apellidos);
    }

    public List<Persona> buscarPorNombresYApellidos(String nombres, String apellidos) {
        return personaRepository.findByNombresAndApellidos(nombres, apellidos);
    }

    public List<Persona> buscarPorFragmentoDeNombres(String fragmento) {
        return personaRepository.findByNombresContaining(fragmento);
    }

    public List<Persona> buscarPorFragmentoDeApellidos(String fragmento) {
        return personaRepository.findByApellidosContaining(fragmento);
    }

    public List<Persona> listarOrdenadasPorNombres() {
        return personaRepository.findAll(Sort.by("nombres").ascending());
    }

    public List<Persona> listarOrdenadasPorApellidos() {
        return personaRepository.findAll(Sort.by(Sort.Direction.ASC, "apellidos"));
    }
}
