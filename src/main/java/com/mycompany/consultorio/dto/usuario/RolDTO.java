package com.mycompany.consultorio.dto.usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Rol;

public class RolDTO {
    private int id;
    private String descripcion;
    private EstadoEnum estado;
    private List<PermisoDTO> permisos; // Verifica que esta lista esté poblada

    public RolDTO() {}

    public RolDTO(int id, String descripcion, EstadoEnum estado, List<PermisoDTO> permisos) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.permisos = permisos;
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

    public List<PermisoDTO> getPermisos() {
        return permisos != null ? permisos : new ArrayList<>();
    }

    public void setPermisos(List<PermisoDTO> permisos) {
        this.permisos = permisos;
    }

    // Convertir Rol a RolDTO
    public static RolDTO fromEntity(Rol rol) {
        RolDTO dto = new RolDTO();
        dto.setId(rol.getId());
        dto.setDescripcion(rol.getDescripcion());
        dto.setEstado(rol.getEstado());
        dto.setPermisos(rol.getPermisos().stream()
                .map(PermisoDTO::fromEntity)
                .collect(Collectors.toList()));
        return dto;
    }

    public Rol toEntity() {
        Rol rol = new Rol();
        rol.setId(this.id);
        rol.setDescripcion(this.descripcion);
        rol.setEstado(this.estado);
        rol.setPermisos(this.permisos != null
                ? this.permisos.stream()
                        .map(PermisoDTO::toEntity) 
                        .collect(Collectors.toSet())
                : new HashSet<>());
        return rol;
    }
    

}
