package com.mycompany.consultorio.repository;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mycompany.consultorio.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
    Page<Provincia> findByDepartamentoIdDepartamento(Integer id, Pageable pageable);

    Optional<Provincia> findByDescripcion(String descripcion);

    @Query("SELECT p FROM Provincia p JOIN FETCH p.departamento WHERE p.id = :id")
    Optional<Provincia> findByIdConDepartamento(@Param("id") Integer id);
}
