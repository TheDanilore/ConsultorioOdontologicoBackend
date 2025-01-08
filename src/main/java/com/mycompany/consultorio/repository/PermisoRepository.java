package com.mycompany.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.consultorio.model.usuario.Permiso;

import java.util.List;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {
    Permiso findByDescripcion(String descripcion);

    List<Permiso> findByAccion(String accion);
}
