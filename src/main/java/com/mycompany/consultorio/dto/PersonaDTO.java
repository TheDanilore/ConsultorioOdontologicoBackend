package com.mycompany.consultorio.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mycompany.consultorio.model.GeneroEnum;
import com.mycompany.consultorio.model.Persona;

public class PersonaDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private TipoDocumentoIdentidadDTO tipoDocumentoIdentidad;
    private String numeroDocumento;
    private DepartamentoDTO departamento;
    private ProvinciaDTO provincia;
    private DistritoDTO distrito;
    private String correo;
    private LocalDate fechaNacimiento;
    private GeneroEnum genero;
    private String lugarNacimiento;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    

    public PersonaDTO(Long id, String nombres, String apellidos, String direccion, String telefono,
            TipoDocumentoIdentidadDTO tipoDocumentoIdentidad, String numeroDocumento, DepartamentoDTO departamento,
            ProvinciaDTO provincia, DistritoDTO distrito, String correo, LocalDate fechaNacimiento, GeneroEnum genero,
            String lugarNacimiento, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.lugarNacimiento = lugarNacimiento;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public PersonaDTO() {
    }

    public static PersonaDTO fromEntity(Persona persona) {
        PersonaDTO dto = new PersonaDTO();
        dto.setId(persona.getId());
        dto.setNombres(persona.getNombres());
        dto.setApellidos(persona.getApellidos());
        dto.setDireccion(persona.getDireccion());
        dto.setTelefono(persona.getTelefono());
    
        // Convertir TipoDocumentoIdentidad a DTO
        if (persona.getTipoDocumentoIdentidad() != null) {
            dto.setTipoDocumentoIdentidad(TipoDocumentoIdentidadDTO.fromEntity(persona.getTipoDocumentoIdentidad()));
        }
    
        dto.setNumeroDocumento(persona.getNumeroDocumento());

        if(persona.getDepartamento() != null){
            dto.setDepartamento(DepartamentoDTO.fromEntity(persona.getDepartamento()));
        }

        if(persona.getProvincia() != null){
            dto.setProvincia(ProvinciaDTO.fromEntity(persona.getProvincia()));
        }

        if(persona.getDistrito() != null){
            dto.setDistrito(DistritoDTO.fromEntity(persona.getDistrito()));
        }
        dto.setCorreo(persona.getCorreo());
        dto.setFechaNacimiento(persona.getFechaNacimiento());
        dto.setGenero(persona.getGenero());
        dto.setLugarNacimiento(persona.getLugarNacimiento());
        dto.setCreated_at(persona.getCreated_at());
        dto.setUpdated_at(persona.getUpdated_at());
        return dto;
    }
    
    public Persona toEntity() {
        Persona persona = new Persona();
        persona.setId(this.id);
        persona.setNombres(this.nombres);
        persona.setApellidos(this.apellidos);
        persona.setDireccion(this.direccion);
        persona.setTelefono(this.telefono);
    
        // Convertir DTO de TipoDocumentoIdentidad a entidad
        if (this.tipoDocumentoIdentidad != null) {
            persona.setTipoDocumentoIdentidad(this.tipoDocumentoIdentidad.toEntity());
        }
    
        persona.setNumeroDocumento(this.numeroDocumento);

        if(this.departamento != null){
            persona.setDepartamento(this.departamento.toEntity());
        }

        if(this.provincia != null){
            persona.setProvincia(this.provincia.toEntity());
        }

        if(this.distrito != null){
            persona.setDistrito(this.distrito.toEntity());
        }
        persona.setCorreo(this.correo);
        persona.setFechaNacimiento(this.fechaNacimiento);
        persona.setGenero(this.genero);
        persona.setLugarNacimiento(this.lugarNacimiento);
        persona.setCreated_at(this.created_at);
        persona.setUpdated_at(this.updated_at);
        return persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoDocumentoIdentidadDTO getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(TipoDocumentoIdentidadDTO tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDTO departamento) {
        this.departamento = departamento;
    }

    public ProvinciaDTO getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaDTO provincia) {
        this.provincia = provincia;
    }

    public DistritoDTO getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoDTO distrito) {
        this.distrito = distrito;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
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
