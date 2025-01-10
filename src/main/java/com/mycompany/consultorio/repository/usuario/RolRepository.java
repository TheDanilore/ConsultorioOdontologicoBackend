package com.mycompany.consultorio.repository.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.consultorio.model.usuario.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByDescripcion(String descripcion);

    // Buscar roles asociados a un usuario específico
    @Query("SELECT r FROM Rol r JOIN r.usuarios u WHERE u.id = :usuarioId")
    List<Rol> findRolesByUsuarioId(Integer usuarioId);
}

