package com.mycompany.consultorio.controller;

import com.mycompany.consultorio.dto.PersonaDTO;
import com.mycompany.consultorio.exception.ResourceNotFoundException;
import com.mycompany.consultorio.model.Persona;
import com.mycompany.consultorio.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/personas") // Indica la URL base para todos los métodos
public class PersonaController { // Clase controlador para la entidad Persona

    @Autowired // Inyección de dependencias
    private PersonaService personaService; // Servicio para la entidad Persona

    @GetMapping
    public List<PersonaDTO> listarTodas() { // Método para listar todas las personas
        return personaService.listarTodas().stream()
                .map(PersonaDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList()); // Retorna la lista de personas
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> buscarPorId(@PathVariable Long id) { // Método para buscar una persona por su ID
        Persona persona = personaService.buscarPorId(id);
        if (persona == null) {
            throw new ResourceNotFoundException("La persona con ID " + id + " no existe.");
        }
        return ResponseEntity.ok(PersonaDTO.fromEntity(persona)); // Retorna la persona encontrada
    }

    @PostMapping
    public ResponseEntity<PersonaDTO> guardar(@RequestBody PersonaDTO personaDTO) { // Método para guardar una persona
        Persona persona = personaDTO.toEntity();
        Persona personaGuardada = personaService.guardar(persona); // Guarda la persona
        return ResponseEntity.status(HttpStatus.CREATED).body(PersonaDTO.fromEntity(personaGuardada));
    }

    @PutMapping("/editar/{id}")
    public PersonaDTO editar(@PathVariable Long id, @RequestBody PersonaDTO personaDTO) {
        Persona persona = personaDTO.toEntity(); // Convertir UsuarioDTO a Usuario
        Persona personaEditada = personaService.editar(id, persona);
        return PersonaDTO.fromEntity(personaEditada); // Convertir Usuario a UsuarioDTO
    }

    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id) { // Método para eliminar una persona por su ID
        personaService.eliminarPorId(id); // Elimina la persona por su ID
    }

    @GetMapping("/idtipodocumento/{idTipoDocumento}")
    public PersonaDTO BuscarPorIdConTipoDocumento(@PathVariable Long idTipoDocumento) { // Método para buscar personas
                                                                                        // por su ID de tipo de
                                                                                        // documento
        Persona persona = personaService.BuscarPorIdConTipoDocumento(idTipoDocumento);
        return PersonaDTO.fromEntity(persona); // Retorna la persona encontrada
    }

    // Métodos personalizados
    @GetMapping("/correo/{correo}")
    public PersonaDTO buscarPorCorreo(@PathVariable String correo) { // Método para buscar una persona por su correo
        Persona persona = personaService.buscarPorCorreo(correo); // Busca la persona por su correo
        return PersonaDTO.fromEntity(persona); // Retorna la persona encontrada
    }

    @GetMapping("/nombres/{nombres}")
    public List<PersonaDTO> buscarPorNombres(@PathVariable String nombres) { // Método para buscar personas por su
                                                                             // nombre
        return personaService.buscarPorNombres(nombres).stream()
                .map(PersonaDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList()); // Retorna la lista de personas encontradas
    }

    @GetMapping("/apellidos/{apellidos}")
    public List<PersonaDTO> buscarPorApellidos(@PathVariable String apellidos) { // Método para buscar personas por su
        return personaService.buscarPorApellidos(apellidos).stream()
                .map(PersonaDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList()); // Retorna la lista de personas encontradas
    }

    @GetMapping("/nombres/{nombres}/apellidos/{apellidos}")
    public List<PersonaDTO> buscarPorNombresYApellidos(@PathVariable String nombres, @PathVariable String apellidos) { // Método
                                                                                                                       // para
                                                                                                                       // buscar
                                                                                                                       // personas
                                                                                                                       // por
                                                                                                                       // su
                                                                                                                       // nombre
                                                                                                                       // y
                                                                                                                       // apellido
        return personaService.buscarPorNombresYApellidos(nombres, apellidos).stream()
                .map(PersonaDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList()); // Retorna la lista de personas encontradas
    }

    @GetMapping("/nombres/fragmento/{fragmento}")
    public List<PersonaDTO> buscarPorFragmentoDeNombres(@PathVariable String fragmento) { // Método para buscar personas
        return personaService.buscarPorFragmentoDeNombres(fragmento).stream()
                .map(PersonaDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList()); // Retorna la lista de personas encontradas
    }

    @GetMapping("/apellidos/fragmento/{fragmento}")
    public List<PersonaDTO> buscarPorFragmentoDeApellidos(@PathVariable String fragmento) { // Método para buscar
                                                                                            // personas
        return personaService.buscarPorFragmentoDeApellidos(fragmento).stream()
                .map(PersonaDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList()); // Retorna la lista de personas encontradas
    }

    @GetMapping("/ordenadas/nombres")
    public List<PersonaDTO> listarOrdenadasPorNombres() { // Método para listar todas las personas ordenadas por nombre
        return personaService.listarOrdenadasPorNombres().stream()
                .map(PersonaDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList()); // Retorna la lista de personas ordenadas por nombre
    }

    @GetMapping("/ordenadas/apellidos")
    public List<PersonaDTO> listarOrdenadasPorApellidos() { // Método para listar todas las personas ordenadas por
                                                            // apellido
        return personaService.listarOrdenadasPorApellidos().stream()
                .map(PersonaDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList()); // Retorna la lista de personas ordenadas por apellido
    }
}
