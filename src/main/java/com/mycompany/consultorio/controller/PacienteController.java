package com.mycompany.consultorio.controller;

import com.mycompany.consultorio.dto.PacienteDTO;
import com.mycompany.consultorio.model.Paciente;
import com.mycompany.consultorio.service.PacienteService;
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
    public Page<PacienteDTO> listarTodos(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return pacienteService.listarTodos(pageable).map(PacienteDTO::fromEntity);
    }

    @GetMapping("/{id}") // Indica que este método responde a una petición GET con un parámetro en la URL
    public ResponseEntity<PacienteDTO> buscarPorId(@PathVariable Long id) { // Método para buscar un paciente por su ID
        Paciente paciente = pacienteService.buscarPorId(id); 
        return ResponseEntity.ok(PacienteDTO.fromEntity(paciente)); // Retorna el paciente encontrado
    }

    @PostMapping 
    public ResponseEntity<PacienteDTO> guardar(@RequestBody PacienteDTO pacienteDTO) { // Método para guardar un paciente
        Paciente paciente = pacienteDTO.toEntity();
        Paciente pacienteGuardado = pacienteService.guardar(paciente); 
        return ResponseEntity.status(HttpStatus.CREATED).body(PacienteDTO.fromEntity(pacienteGuardado)); // Retorna el paciente guardado
    }

    @PutMapping("/editar/{id}")
    public PacienteDTO editar(@PathVariable Long id, @RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteDTO.toEntity(); 
        Paciente pacienteEditado = pacienteService.editar(id, paciente);
        return PacienteDTO.fromEntity(pacienteEditado); 
    }

    @DeleteMapping("/{id}") 
    public void eliminarPorId(@PathVariable Long id) { // Método para eliminar un paciente por su ID
        pacienteService.eliminarPorId(id); // Elimina el paciente por su ID
    }
}
