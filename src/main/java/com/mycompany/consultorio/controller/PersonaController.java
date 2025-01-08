package com.mycompany.consultorio.controller;

import com.mycompany.consultorio.model.Persona;
import com.mycompany.consultorio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/personas") // Indica la URL base para todos los métodos
public class PersonaController { // Clase controlador para la entidad Persona

    @Autowired // Inyección de dependencias
    private PersonaService personaService; // Servicio para la entidad Persona

    @GetMapping // Indica que este método responde a una petición GET
    public List<Persona> listarTodas() { // Método para listar todas las personas
        return personaService.listarTodas(); // Retorna la lista de personas
    }

    @GetMapping("/{id}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public Persona buscarPorId(@PathVariable int id) { // Método para buscar una persona por su ID
        return personaService.buscarPorId(id); // Retorna la persona encontrada
    }

    @PostMapping // Indica que este método responde a una petición POST
    public Persona guardar(@RequestBody Persona persona) {  // Método para guardar una persona
        return personaService.guardar(persona); // Retorna la persona guardada
    }

    @DeleteMapping("/{id}") // Indica que este método responde a una petición DELETE con un parámetro en la URL
    public void eliminarPorId(@PathVariable int id) {  // Método para eliminar una persona por su ID
        personaService.eliminarPorId(id); // Elimina la persona por su ID
    }

    // Métodos personalizados
    @GetMapping("/correo/{correo}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public Persona buscarPorCorreo(@PathVariable String correo) { // Método para buscar una persona por su correo
        return personaService.buscarPorCorreo(correo); // Retorna la persona encontrada
    }

    @GetMapping("/nombres/{nombres}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public List<Persona> buscarPorNombres(@PathVariable String nombres) { // Método para buscar personas por su nombre
        return personaService.buscarPorNombres(nombres); // Retorna la lista de personas encontradas
    }
    
    @GetMapping("/apellidos/{apellidos}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public List<Persona> buscarPorApellidos(@PathVariable String apellidos) { // Método para buscar personas por su apellido
        return personaService.buscarPorApellidos(apellidos); // Retorna la lista de personas encontradas
    }

    @GetMapping("/nombres/{nombres}/apellidos/{apellidos}") // Indica que este método responde a una petición GET con dos parámetros en la URL
    public List<Persona> buscarPorNombresYApellidos(@PathVariable String nombres, @PathVariable String apellidos) { // Método para buscar personas por su nombre y apellido
        return personaService.buscarPorNombresYApellidos(nombres, apellidos); // Retorna la lista de personas encontradas
    }

    @GetMapping("/nombres/fragmento/{fragmento}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public List<Persona> buscarPorFragmentoDeNombres(@PathVariable String fragmento) { // Método para buscar personas por un fragmento de su nombre
        return personaService.buscarPorFragmentoDeNombres(fragmento); // Retorna la lista de personas encontradas
    }

    @GetMapping("/apellidos/fragmento/{fragmento}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public List<Persona> buscarPorFragmentoDeApellidos(@PathVariable String fragmento) { // Método para buscar personas por un fragmento de su apellido
        return personaService.buscarPorFragmentoDeApellidos(fragmento); // Retorna la lista de personas encontradas
    }

    @GetMapping("/ordenadas/nombres") // Indica que este método responde a una petición GET
    public List<Persona> listarOrdenadasPorNombres() { // Método para listar todas las personas ordenadas por nombre
        return personaService.listarOrdenadasPorNombres(); // Retorna la lista de personas ordenadas por nombre
    }

    @GetMapping("/ordenadas/apellidos") // Indica que este método responde a una petición GET
    public List<Persona> listarOrdenadasPorApellidos() { // Método para listar todas las personas ordenadas por apellido
        return personaService.listarOrdenadasPorApellidos(); // Retorna la lista de personas ordenadas por apellido
    }
}
