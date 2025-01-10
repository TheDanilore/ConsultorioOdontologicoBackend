package com.mycompany.consultorio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departamento")
public class Departamento {
    @Id
    @Column(name = "id_departamento")
    private int idDepartamento;
    private String descripcion;

    public Departamento(int idDepartamento, String descripcion) {
        this.idDepartamento = idDepartamento;
        this.descripcion = descripcion;
    }

    public Departamento() {
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
