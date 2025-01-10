package com.mycompany.consultorio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @Column(name = "id_provincia")
    private int idProvincia;
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    private Departamento departamento; // FK

    public Provincia(int idProvincia, String descripcion, Departamento departamento) {
        this.idProvincia = idProvincia;
        this.descripcion = descripcion;
        this.departamento = departamento;
    }

    public Provincia() {
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    

}
