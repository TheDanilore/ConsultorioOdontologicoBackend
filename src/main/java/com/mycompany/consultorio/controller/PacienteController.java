package com.mycompany.consultorio.controller; // Paquete del controlador

import com.mycompany.consultorio.model.Paciente; // Importa la clase Paciente
import com.mycompany.consultorio.service.PacienteService; // Importa la clase PacienteService
import org.springframework.beans.factory.annotation.Autowired; // Importa la clase Autowired
import org.springframework.web.bind.annotation.*; // Importa las clases RestController, RequestMapping, GetMapping, PostMapping, DeleteMapping

import java.util.List; 

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/pacientes") // Indica la URL base para todos los métodos
public class PacienteController { // Clase controlador para la entidad Paciente

    @Autowired // Inyección de dependencias
    private PacienteService pacienteService; // Servicio para la entidad Paciente

    @GetMapping // Indica que este método responde a una petición GET
    public List<Paciente> listarTodos() { // Método para listar todos los pacientes
        return pacienteService.listarTodos(); // Retorna la lista de pacientes
    }

    @GetMapping("/{id}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public Paciente buscarPorId(@PathVariable int id) { // Método para buscar un paciente por su ID
        return pacienteService.buscarPorId(id); // Retorna el paciente encontrado
    }

    @PostMapping // Indica que este método responde a una petición POST
    public Paciente guardar(@RequestBody Paciente paciente) { // Método para guardar un paciente
        return pacienteService.guardar(paciente); // Retorna el paciente guardado
    }

    @DeleteMapping("/{id}") // Indica que este método responde a una petición DELETE con un parámetro en la URL
    public void eliminarPorId(@PathVariable int id) { // Método para eliminar un paciente por su ID
        pacienteService.eliminarPorId(id); // Elimina el paciente por su ID
    }
}
