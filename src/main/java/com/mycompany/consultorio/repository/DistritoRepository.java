package com.mycompany.consultorio.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mycompany.consultorio.model.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {
    Page<Distrito> findByProvinciaIdProvincia(Integer id, Pageable pageable);
    
    Optional<Distrito> findByDescripcion(String descripcion);


}
