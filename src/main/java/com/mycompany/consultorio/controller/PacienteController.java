package com.mycompany.consultorio.controller;

import com.mycompany.consultorio.dto.PacienteDTO;
import com.mycompany.consultorio.model.Paciente;
import com.mycompany.consultorio.model.Persona;
import com.mycompany.consultorio.service.PacienteService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> listarTodos(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PacienteDTO> pacientes = pacienteService.listarTodos(pageable).map(PacienteDTO::fromEntity);
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id) { // Método para buscar un paciente por su ID
        Paciente paciente = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(PacienteDTO.fromEntity(paciente)); // Retorna el paciente encontrado
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> guardar(@RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteDTO.toEntity();
        Paciente pacienteGuardado = pacienteService.guardar(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(PacienteDTO.fromEntity(pacienteGuardado));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<PacienteDTO> editar(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteDTO.toEntity();
        Paciente pacienteEditado = pacienteService.editar(id, paciente);
        return ResponseEntity.ok(PacienteDTO.fromEntity(pacienteEditado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Long id) { // Método para eliminar un paciente por su ID
        pacienteService.eliminarPorId(id);
        return ResponseEntity.ok("Paciente eliminado correctamente");
    }

    @PostMapping("/persona-existe")
    public ResponseEntity<?> personaExiste(@RequestBody PacienteDTO pacienteDTO) {
        if (pacienteService.personaExiste(pacienteDTO.toEntity().getPersona())) {
            return ResponseEntity.ok("La persona ya está registrada como paciente.");
        }
        return ResponseEntity.ok("La persona no está registrada como paciente.");
    }

    @PostMapping("/validar-persona")
    public ResponseEntity<?> validarPersona(@RequestBody PacienteDTO pacienteDTO) {
        Persona persona = pacienteDTO.toEntity().getPersona();
        Optional<Persona> personaExistente = pacienteService.validarPersonaExistente(persona);

        if (personaExistente.isPresent()) {
            return ResponseEntity.ok(personaExistente.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No se encontró una persona con los datos proporcionados.");
    }

}
