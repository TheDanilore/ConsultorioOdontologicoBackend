package com.mycompany.consultorio.dto;

import java.time.LocalDateTime;

import com.mycompany.consultorio.model.Paciente;

public class PacienteDTO {
    private Long id; 
    private PersonaDTO persona;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public PacienteDTO(Long id, PersonaDTO persona, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.persona = persona;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public PacienteDTO() {
    }

    public static PacienteDTO fromEntity(Paciente paciente) {
        PacienteDTO dto = new PacienteDTO();
        dto.setId(paciente.getId());
        if(paciente.getPersona() != null){
            dto.setPersona(PersonaDTO.fromEntity(paciente.getPersona()));
        }
        return dto;
    }

    public Paciente toEntity() {
        Paciente paciente = new Paciente();
        paciente.setId(this.id);
        if(this.persona != null){
            paciente.setPersona(this.persona.toEntity());
        }
        return paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
