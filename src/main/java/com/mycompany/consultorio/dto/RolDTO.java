package com.mycompany.consultorio.dto;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Rol;

public class RolDTO {
    private int id;
    private String descripcion;
    private EstadoEnum estado;
    private List<PermisoDTO> permisos; // Verifica que esta lista esté poblada


    public RolDTO(int id, String descripcion, EstadoEnum estado, List<PermisoDTO> permisos) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
        this.permisos = permisos;
    }

    public RolDTO(int id, String descripcion, EstadoEnum estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public RolDTO() {
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


    public static RolDTO fromEntity(Rol rol) {
        return new RolDTO(rol.getId(), rol.getDescripcion(), rol.getEstado());
    }


    

}
