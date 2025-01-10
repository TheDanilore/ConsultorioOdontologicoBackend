package com.mycompany.consultorio.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "tipodocumentoidentidad_id", referencedColumnName = "id")
    private TipoDocumentoIdentidad tipoDocumentoIdentidad;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "departamento_id")
    private int idDepartamento;

    @Column(name = "provincia_id")
    private int idProvincia;

    @Column(name = "distrito_id")
    private int idDistrito;

    private String correo;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    public Persona(Long id, String nombres, String apellidos, String direccion, String telefono,
            TipoDocumentoIdentidad tipoDocumentoIdentidad, String numeroDocumento, int idDepartamento, int idProvincia,
            int idDistrito, String correo, LocalDate fechaNacimiento, GeneroEnum genero, String lugarNacimiento,
            LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
        this.numeroDocumento = numeroDocumento;
        this.idDepartamento = idDepartamento;
        this.idProvincia = idProvincia;
        this.idDistrito = idDistrito;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.lugarNacimiento = lugarNacimiento;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Persona() {
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

    public TipoDocumentoIdentidad getTipoDocumentoIdentidad() {
        return tipoDocumentoIdentidad;
    }

    public void setTipoDocumentoIdentidad(TipoDocumentoIdentidad tipoDocumentoIdentidad) {
        this.tipoDocumentoIdentidad = tipoDocumentoIdentidad;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
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
