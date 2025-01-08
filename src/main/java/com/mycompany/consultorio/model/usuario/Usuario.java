package com.mycompany.consultorio.model.usuario;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycompany.consultorio.model.EstadoEnum;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "rolesusers",
        joinColumns = @JoinColumn(name = "idUsuario"), 
        inverseJoinColumns = @JoinColumn(name = "idRol") 
    )
    @JsonIgnore
    private Set<Rol> roles = new HashSet<>();


    // Constructores
    public Usuario() {
        this.roles = new HashSet<>();
    }

    public Usuario(Long id, String nombre, String email, String password, EstadoEnum estado, Set<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.estado = estado;
        this.roles = roles;
    }

    // Getters y Setters
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
