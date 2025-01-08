package com.mycompany.consultorio.model;

import jakarta.persistence.*;

@Entity // Indica que esta clase es una entidad
@Table(name = "paciente") // Indica el nombre de la tabla en la base de datos
public class Paciente { // Clase para la entidad Paciente

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de la clave primaria
    private Integer id; // Atributo para el ID del paciente

    @OneToOne(cascade = CascadeType.ALL) // Relación uno a uno con la entidad Persona
    @JoinColumn(name = "persona_id", referencedColumnName = "id") // Columna de unión con la tabla persona
    private Persona persona; // Atributo para la persona del paciente

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persona getPersona() { // Método para obtener la persona del paciente
        return persona;
    }

    public void setPersona(Persona persona) { // Método para establecer la persona del paciente
        this.persona = persona;
    }
}
