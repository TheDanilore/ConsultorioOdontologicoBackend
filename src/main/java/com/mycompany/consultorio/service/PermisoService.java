package com.mycompany.consultorio.service;

import com.mycompany.consultorio.exception.DAOException;
import com.mycompany.consultorio.model.usuario.Permiso;
import com.mycompany.consultorio.repository.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepository;

    public List<Permiso> listarTodos() {
        return permisoRepository.findAll();
    }

    public Permiso guardar(Permiso permiso) {
        return permisoRepository.save(permiso);
    }

    public Permiso editar(int id, Permiso permisoActualizado) {
        Permiso permisoExistente = permisoRepository.findById(id)
                .orElseThrow(() -> new DAOException("Rol no encontrado"));

        // Actualizar solo los campos permitidos
        permisoExistente.setDescripcion(permisoExistente.getDescripcion());
        permisoExistente.setAccion(permisoExistente.getAccion());
        return permisoRepository.save(permisoExistente);
    }

    public Permiso buscarPorId(int id) {
        return permisoRepository.findById(id).orElse(null);
    }

    public void eliminarPorId(int id) {
        permisoRepository.deleteById(id);
    }

    public Permiso buscarPorDescripcion(String descripcion) {
        return permisoRepository.findByDescripcion(descripcion);
    }
}
