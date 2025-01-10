package com.mycompany.consultorio.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tipodocumentoidentidad")
public class TipoDocumentoIdentidad {
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String abreviatura;

    @Column(nullable = false, unique = true)
    private String descripcion;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public TipoDocumentoIdentidad(String id, String abreviatura, String descripcion, LocalDateTime created_at,
            LocalDateTime updated_at) {
        this.id = id;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public TipoDocumentoIdentidad() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
