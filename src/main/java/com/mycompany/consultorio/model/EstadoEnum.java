package com.mycompany.consultorio.model;

public enum EstadoEnum {
    Activo,
    Inactivo;
    
    public static EstadoEnum fromString(String estado) {
        for (EstadoEnum e : values()) {
            if (e.name().equalsIgnoreCase(estado)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Estado no válido: " + estado);
    }
}
