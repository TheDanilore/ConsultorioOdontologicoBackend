package com.mycompany.consultorio.dto;

import com.mycompany.consultorio.model.Provincia;

public class ProvinciaDTO {
    private int idProvincia;
    private String descripcion;
    private DepartamentoDTO departamento; // FK

    public ProvinciaDTO(int idProvincia, String descripcion, DepartamentoDTO departamento) {
        this.idProvincia = idProvincia;
        this.descripcion = descripcion;
        this.departamento = departamento;
    }

    public ProvinciaDTO() {
    }

    public static ProvinciaDTO fromEntity(Provincia provincia) {
        ProvinciaDTO dto = new ProvinciaDTO();
        dto.setIdProvincia(provincia.getIdProvincia());
        dto.setDescripcion(provincia.getDescripcion());

        // Convertir TipoDocumentoIdentidad a DTO
        if (provincia.getDepartamento() != null) {
            dto.setDepartamento(DepartamentoDTO.fromEntity(provincia.getDepartamento()));
        }

        return dto;
    }

    public Provincia toEntity() {
        Provincia provincia = new Provincia();
        provincia.setIdProvincia(this.idProvincia);
        provincia.setDescripcion(this.descripcion);

        // Convertir DTO de TipoDocumentoIdentidad a entidad
        if (this.departamento != null) {
            provincia.setDepartamento(this.departamento.toEntity());
        }

        return provincia;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }
}
