package com.mycompany.consultorio.dto;

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

    
}
