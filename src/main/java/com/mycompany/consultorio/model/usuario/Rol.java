package com.mycompany.consultorio.model.usuario;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.consultorio.model.EstadoEnum;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado = EstadoEnum.Activo;;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore // Ignora la serialización de esta relación
    private Set<Usuario> usuarios = new HashSet<>();

    
    @ManyToMany
    @JoinTable(
        name = "permisosroles",
        joinColumns = @JoinColumn(name = "idRol"),
        inverseJoinColumns = @JoinColumn(name = "idPermiso")
    )
    private List<Permiso> permisos;

    public Rol(int id, String descripcion, EstadoEnum estado, Set<Usuario> usuarios, List<Permiso> permisos) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuarios = usuarios;
        this.permisos = permisos;
    }

    public Rol() {
    }

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

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }    
    
}
