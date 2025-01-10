package com.mycompany.consultorio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "odontologo")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String especialidad;
    private String turno;

    @OneToOne(cascade = CascadeType.ALL) // Relación uno a uno con la entidad Persona
    @JoinColumn(name = "persona_id", referencedColumnName = "id") // Columna de unión con la tabla persona
    private Persona persona; // Atributo para la persona del paciente
    
    public Odontologo(Long id, String especialidad, String turno, Persona persona) {
        this.id = id;
        this.especialidad = especialidad;
        this.turno = turno;
        this.persona = persona;
    }
    public Odontologo() {
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
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }



}
