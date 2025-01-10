package com.mycompany.consultorio.dto;

import com.mycompany.consultorio.model.Paciente;

public class PacienteDTO {
    private Long id; // Atributo para el ID del paciente

    private PersonaDTO persona; // Atributo para la persona del paciente

    public PacienteDTO(Long id, PersonaDTO persona) {
        this.id = id;
        this.persona = persona;
    }

    public PacienteDTO() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonaDTO getPersona() { // Método para obtener la persona del paciente
        return persona;
    }

    public void setPersona(PersonaDTO persona) { // Método para establecer la persona del paciente
        this.persona = persona;
    }

    public static PacienteDTO fromEntity(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId());
        dto.setPersona(PersonaDTO.fromEntity(paciente.getPersona()));
        return dto;
    }

    public Paciente toEntity() {
        Paciente paciente = new Paciente();
        paciente.setId(this.id);
        paciente.setPersona(this.persona.toEntity());
        return paciente;
    }
}
