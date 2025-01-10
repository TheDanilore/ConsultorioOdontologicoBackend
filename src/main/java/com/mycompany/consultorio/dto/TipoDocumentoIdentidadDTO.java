package com.mycompany.consultorio.dto;

import java.time.LocalDateTime;
import com.mycompany.consultorio.model.TipoDocumentoIdentidad;

public class TipoDocumentoIdentidadDTO {
    private String id;
    private String abreviatura;
    private String descripcion;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    

    public TipoDocumentoIdentidadDTO(String id, String abreviatura, String descripcion, LocalDateTime created_at,
            LocalDateTime updated_at) {
        this.id = id;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public TipoDocumentoIdentidadDTO() {
    }

    public static TipoDocumentoIdentidadDTO fromEntity(TipoDocumentoIdentidad tipoDocumentoIdentidad) {
        TipoDocumentoIdentidadDTO dto = new TipoDocumentoIdentidadDTO();
        dto.setId(tipoDocumentoIdentidad.getId());
        dto.setAbreviatura(tipoDocumentoIdentidad.getAbreviatura());
        dto.setDescripcion(tipoDocumentoIdentidad.getDescripcion());
        dto.setCreated_at(tipoDocumentoIdentidad.getCreated_at());
        dto.setUpdated_at(tipoDocumentoIdentidad.getUpdated_at());
        return dto;
    }

    public TipoDocumentoIdentidad toEntity() {
        TipoDocumentoIdentidad tipoDocumentoIdentidad = new TipoDocumentoIdentidad();
        tipoDocumentoIdentidad.setId(this.id);
        tipoDocumentoIdentidad.setAbreviatura(this.abreviatura);
        tipoDocumentoIdentidad.setDescripcion(this.descripcion);
        tipoDocumentoIdentidad.setCreated_at(this.created_at);
        tipoDocumentoIdentidad.setUpdated_at(this.updated_at);
        return tipoDocumentoIdentidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
