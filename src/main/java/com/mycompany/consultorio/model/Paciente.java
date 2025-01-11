package com.mycompany.consultorio.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity // Indica que esta clase es una entidad
@Table(name = "paciente") // Indica el nombre de la tabla en la base de datos
public class Paciente { // Clase para la entidad Paciente

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de la clave primaria
    private Long id; // Atributo para el ID del paciente

    @OneToOne(cascade = CascadeType.ALL) // Relación uno a uno con la entidad Persona
    @JoinColumn(name = "persona_id", referencedColumnName = "id") // Columna de unión con la tabla persona
    private Persona persona; // Atributo para la persona del paciente

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    public Paciente(Long id, Persona persona, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.persona = persona;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Paciente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
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
