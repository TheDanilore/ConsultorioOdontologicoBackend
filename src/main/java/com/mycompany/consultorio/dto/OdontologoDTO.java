package com.mycompany.consultorio.dto;

import com.mycompany.consultorio.model.Odontologo;

public class OdontologoDTO {

    private Long id;
    private String especialidad;
    private String turno;
    private PersonaDTO persona;

    public OdontologoDTO(Long id, String especialidad, String turno, PersonaDTO persona) {
        this.id = id;
        this.especialidad = especialidad;
        this.turno = turno;
        this.persona = persona;
    }

    public OdontologoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public static OdontologoDTO fromEntity(Odontologo odontologo) {
        OdontologoDTO dto = new OdontologoDTO();
        dto.setId(odontologo.getId());
        dto.setEspecialidad(odontologo.getEspecialidad());
        dto.setTurno(odontologo.getTurno());
        dto.setPersona(PersonaDTO.fromEntity(odontologo.getPersona()));
        return dto;
    }

    public Odontologo toEntity() {
        Odontologo odontologo = new Odontologo();
        odontologo.setId(this.id);
        odontologo.setEspecialidad(this.especialidad);
        odontologo.setTurno(this.turno);
        odontologo.setPersona(this.persona.toEntity());
        return odontologo;
    }
}
