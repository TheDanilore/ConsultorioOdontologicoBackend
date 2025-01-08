package com.mycompany.consultorio.model.usuario;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "permiso")
public class Permiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
    private String accion;

    @ManyToMany(mappedBy = "permisos")
    private List<Rol> roles;

    public Permiso(int id, String descripcion, String accion, List<Rol> roles) {
        this.id = id;
        this.descripcion = descripcion;
        this.accion = accion;
        this.roles = roles;
    }

    public Permiso() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
}
