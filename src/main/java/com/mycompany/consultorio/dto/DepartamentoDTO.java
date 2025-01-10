package com.mycompany.consultorio.dto;

import com.mycompany.consultorio.model.Departamento;

public class DepartamentoDTO {
    private int idDepartamento;
    private String descripcion;

    public DepartamentoDTO(int idDepartamento, String descripcion) {
        this.idDepartamento = idDepartamento;
        this.descripcion = descripcion;
    }

    public DepartamentoDTO() {
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static DepartamentoDTO fromEntity(Departamento departamento) {
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setIdDepartamento(departamento.getIdDepartamento());
        dto.setDescripcion(departamento.getDescripcion());
        return dto;
    }

    public Departamento toEntity() {
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(this.idDepartamento);
        departamento.setDescripcion(this.descripcion);
        return departamento;
    }
}
