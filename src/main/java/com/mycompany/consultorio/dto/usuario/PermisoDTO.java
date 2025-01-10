package com.mycompany.consultorio.dto.usuario;

import java.util.Objects;
import com.mycompany.consultorio.model.usuario.Permiso;

public class PermisoDTO {
    private int id;
    private String descripcion;
    private String accion;

    public PermisoDTO(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public PermisoDTO(int id, String descripcion, String accion) {
        this.id = id;
        this.descripcion = descripcion;
        this.accion = accion;
    }

    public PermisoDTO() {
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

    public static PermisoDTO fromEntity(Permiso permiso) {
        PermisoDTO dto = new PermisoDTO();
        dto.setId(permiso.getId());
        dto.setDescripcion(permiso.getDescripcion());
        dto.setAccion(permiso.getAccion());
        return dto;
    }

    public Permiso toEntity() {
        Permiso permiso = new Permiso();
        permiso.setId(this.id);
        permiso.setDescripcion(this.descripcion);
        permiso.setAccion(this.accion);
        return permiso;
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
