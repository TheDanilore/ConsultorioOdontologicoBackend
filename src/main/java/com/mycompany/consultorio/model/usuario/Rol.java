package com.mycompany.consultorio.model.usuario;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
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
    
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore // Ignora la serialización de esta relación
    private Set<Usuario> usuarios = new HashSet<>();

    
    @ManyToMany
    @JoinTable(
        name = "permisosroles",
        joinColumns = @JoinColumn(name = "idRol"),
        inverseJoinColumns = @JoinColumn(name = "idPermiso")
    )
    private Set<Permiso> permisos  = new HashSet<>();



    public Rol(int id, String descripcion, EstadoEnum estado, LocalDateTime created_at, LocalDateTime updated_at,
            Set<Usuario> usuarios, Set<Permiso> permisos) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
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
