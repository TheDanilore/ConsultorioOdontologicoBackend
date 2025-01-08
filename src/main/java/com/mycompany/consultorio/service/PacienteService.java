package com.mycompany.consultorio.service; // Paquete del servicio

import com.mycompany.consultorio.model.Paciente; // Importa la clase Paciente
import com.mycompany.consultorio.repository.PacienteRepository; // Importa la clase PacienteRepository
import org.springframework.beans.factory.annotation.Autowired; // Importa la clase Autowired
// import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service; // Importa la clase Service

import java.util.List; // Importa la clase List

@Service // Indica que esta clase es un servicio
public class PacienteService { // Clase servicio para la entidad Paciente

    @Autowired // Inyección de dependencias
    private PacienteRepository pacienteRepository; // Repositorio para la entidad Paciente

    public List<Paciente> listarTodos() { // Método para listar todos los pacientes
        return pacienteRepository.findAll(); // Retorna la lista de pacientes
    }

    public Paciente guardar(Paciente paciente) { // Método para guardar un paciente
        return pacienteRepository.save(paciente); // Retorna el paciente guardado
    }

    public Paciente buscarPorId(int id) { // Método para buscar un paciente por su ID
        return pacienteRepository.findById(id).orElse(null); // Retorna el paciente encontrado
    }

    public void eliminarPorId(int id) { // Método para eliminar un paciente por su ID
        pacienteRepository.deleteById(id); // Elimina el paciente por su ID
    }

    // Métodos personalizados
    // public Paciente buscarPorCorreo(String correo) { // Método para buscar un paciente por el correo de la persona
    //     return pacienteRepository.findByCorreo(correo); // Retorna el paciente encontrado
    // }

    // public List<Paciente> buscarPorNombres(String nombres) { // Método para buscar pacientes por el nombre de la persona
    //     return pacienteRepository.findByNombres(nombres); // Retorna la lista de pacientes encontrados
    // }

    // public List<Paciente> buscarPorApellidos(String apellidos) { // Método para buscar pacientes por el apellido de la persona
    //     return pacienteRepository.findByApellidos(apellidos); // Retorna la lista de pacientes encontrados
    // }

    // public List<Paciente> buscarPorNombresYApellidos(String nombres, String apellidos) { // Método para buscar pacientes por el nombre y apellido de la persona
    //     return pacienteRepository.findByNombresAndApellidos(nombres, apellidos); // Retorna la lista de pacientes encontrados
    // }

    // public List<Paciente> buscarPorFragmentoDeNombres(String fragmento) { // Método para buscar pacientes por un fragmento del nombre de la persona
    //     return pacienteRepository.findByNombresContaining(fragmento); // Retorna la lista de pacientes encontrados
    // }

    // public List<Paciente> buscarPorFragmentoDeApellidos(String fragmento) { // Método para buscar pacientes por un fragmento del apellido de la persona
    //     return pacienteRepository.findByApellidosContaining(fragmento); // Retorna la lista de pacientes encontrados
    // }

    // public List<Paciente> listarOrdenadosPorNombres() {
    //     return pacienteRepository.findAll(Sort.by("nombres").ascending());
    // }

    // public List<Paciente> listarOrdenadosPorApellidos() {
    //     return pacienteRepository.findAll(Sort.by("apellidos").ascending());
    // }

}
