package com.mycompany.consultorio.service.usuario;

import com.mycompany.consultorio.exception.DAOException;
import com.mycompany.consultorio.model.usuario.Permiso;
import com.mycompany.consultorio.repository.usuario.PermisoRepository;

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
        if (permisoRepository.findByDescripcion(permiso.getDescripcion()) != null) {
            throw new DAOException("El permiso ya existe");
        }
        
        return permisoRepository.save(permiso);
    }

    public Permiso editar(int id, Permiso permisoActualizado) {
        Permiso permisoExistente = permisoRepository.findById(id)
                .orElseThrow(() -> new DAOException("Rol no encontrado"));

        // Actualizar solo los campos permitidos
        permisoExistente.setDescripcion(permisoActualizado.getDescripcion());
        permisoExistente.setAccion(permisoActualizado.getAccion());
        return permisoRepository.save(permisoExistente);
    }

    public Permiso buscarPorId(int id) {
        return permisoRepository.findById(id).orElseThrow(() -> new DAOException("Rol no encontrado"));
    }

    public void eliminarPorId(int id) {
        if(!permisoRepository.existsById(id)) {
            throw new DAOException("Permiso no encontrado");
        }
        permisoRepository.deleteById(id);
    }

    public Permiso buscarPorDescripcion(String descripcion) {
        return permisoRepository.findByDescripcion(descripcion);
    }
}
