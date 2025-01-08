package com.mycompany.consultorio.repository;

import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    // Buscar usuario por email y estado
    Optional<Usuario> findByEmailAndEstado(String email, EstadoEnum estado);

    // Recuperar usuario con roles por email
    @Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.email = :email")
    Optional<Usuario> findByEmailWithRoles(@Param("email") String email);

    // Recuperar usuario con roles por ID
    @Query("SELECT u FROM Usuario u JOIN FETCH u.roles WHERE u.id = :id")
    Optional<Usuario> findByIdWithRoles(@Param("id") Long id);

}
