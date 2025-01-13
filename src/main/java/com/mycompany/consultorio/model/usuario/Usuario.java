package com.mycompany.consultorio.model.usuario;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.consultorio.model.EstadoEnum;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado = EstadoEnum.Activo;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rolesusers", joinColumns = @JoinColumn(name = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "idRol"))
    @JsonIgnore
    private Set<Rol> roles = new HashSet<>();

    public Usuario(Long id, String nombre, String email, String password, EstadoEnum estado, LocalDateTime created_at,
            LocalDateTime updated_at, Set<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.roles = roles;
    }

    // Constructores
    public Usuario() {
        this.roles = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

}
