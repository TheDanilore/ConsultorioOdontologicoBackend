package com.mycompany.consultorio.dto.usuario;

import java.time.LocalDateTime;
import java.util.Objects;
import com.mycompany.consultorio.model.usuario.Permiso;

public class PermisoDTO {
    private int id;
    private String descripcion;
    private String accion;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public PermisoDTO(int id, String descripcion, String accion, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.descripcion = descripcion;
        this.accion = accion;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public PermisoDTO(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public PermisoDTO() {
    }

    public static PermisoDTO fromEntity(Permiso permiso) {
        PermisoDTO dto = new PermisoDTO();
        dto.setId(permiso.getId());
        dto.setDescripcion(permiso.getDescripcion());
        dto.setAccion(permiso.getAccion());
        dto.setCreated_at(permiso.getCreated_at());
        dto.setUpdated_at(permiso.getUpdated_at());
        return dto;
    }

    public Permiso toEntity() {
        Permiso permiso = new Permiso();
        permiso.setId(this.id);
        permiso.setDescripcion(this.descripcion);
        permiso.setAccion(this.accion);
        return permiso;
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PermisoDTO that = (PermisoDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
