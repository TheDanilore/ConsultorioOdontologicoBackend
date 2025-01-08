package com.mycompany.consultorio.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Usuario;

public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private EstadoEnum estado;
    private List<RolDTO> roles; // Cambiar a Set<RolDTO> si prefieres conjuntos

    public UsuarioDTO(Long id, String nombre, String email, EstadoEnum estado, List<RolDTO> roles) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.estado = estado;
        this.roles = roles;
    }

    public UsuarioDTO() {
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

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    public List<RolDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolDTO> roles) {
        this.roles = roles;
    }

    // Convertir Usuario a UsuarioDTO
    public static UsuarioDTO fromEntity(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setEstado(usuario.getEstado());
        dto.setRoles(usuario.getRoles().stream()
                .map(RolDTO::fromEntity)
                .collect(Collectors.toList()));
        return dto;
    }

    // Convertir UsuarioDTO a Usuario
    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNombre(this.nombre);
        usuario.setEmail(this.email);
        usuario.setEstado(this.estado);
        return usuario;
    }

    public List<String> getPermisos() {
        return roles.stream()
                .filter(rol -> rol.getPermisos() != null) // Filtrar roles que no tengan permisos nulos
                .flatMap(rol -> rol.getPermisos().stream()) // Convertir cada lista de permisos en un stream
                .map(PermisoDTO::getDescripcion) // Obtener la descripción de cada permiso
                .distinct() // Eliminar duplicados
                .collect(Collectors.toList()); // Convertir a una lista
    }
    

}