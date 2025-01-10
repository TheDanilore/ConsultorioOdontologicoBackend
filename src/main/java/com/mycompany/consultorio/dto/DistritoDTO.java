package com.mycompany.consultorio.dto;

import com.mycompany.consultorio.model.Distrito;

public class DistritoDTO {
    private int idDistrito;
    private String descripcion;
    private ProvinciaDTO provincia; // FK
    private String ubigeo;

    public DistritoDTO(int idDistrito, String descripcion, ProvinciaDTO provincia, String ubigeo) {
        this.idDistrito = idDistrito;
        this.descripcion = descripcion;
        this.provincia = provincia;
        this.ubigeo = ubigeo;
    }

    public DistritoDTO() {
    }

    public static DistritoDTO fromEntity(Distrito distrito) {
        DistritoDTO dto = new DistritoDTO();
        dto.setIdDistrito(distrito.getIdDistrito());
        dto.setDescripcion(distrito.getDescripcion());

        // Convertir TipoDocumentoIdentidad a DTO
        if (distrito.getProvincia() != null) {
            dto.setProvincia(ProvinciaDTO.fromEntity(distrito.getProvincia()));
        }

        dto.setUbigeo(distrito.getUbigeo());

        return dto;
    }

    public Distrito toEntity() {
        Distrito distrito = new Distrito();
        distrito.setIdDistrito(this.idDistrito);
        distrito.setDescripcion(this.descripcion);

        // Convertir DTO de TipoDocumentoIdentidad a entidad
        if (this.provincia != null) {
            distrito.setProvincia(this.provincia.toEntity());
        }

        distrito.setUbigeo(this.ubigeo);

        return distrito;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ProvinciaDTO getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaDTO provincia) {
        this.provincia = provincia;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }
}
