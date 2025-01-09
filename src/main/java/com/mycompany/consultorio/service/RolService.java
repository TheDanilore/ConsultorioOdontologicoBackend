package com.mycompany.consultorio.service;

import com.mycompany.consultorio.exception.DAOException;
import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Rol;
import com.mycompany.consultorio.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarTodos() {
        return rolRepository.findAll();
    }

    public Rol guardar(Rol rol) {
        if (rolRepository.findByDescripcion(rol.getDescripcion()) != null) {
            throw new DAOException("El rol ya existe");
        }
        
        // Verifica si los roles son nulos o vacíos y los inicializa
        if (rol.getPermisos() == null || rol.getPermisos().isEmpty()) {
            rol.setPermisos(new HashSet<>());
        }

        rol.setEstado(EstadoEnum.Activo); // Estado por defecto
        return rolRepository.save(rol);
    }

    public Rol editar(int id, Rol rolActualizado) {
        Rol rolExistente = rolRepository.findById(id)
                .orElseThrow(() -> new DAOException("Rol no encontrado"));

        // Actualizar solo los campos permitidos
        rolExistente.setDescripcion(rolActualizado.getDescripcion());

        rolExistente.setPermisos(rolActualizado.getPermisos() != null ? rolActualizado.getPermisos() : new HashSet<>());

        return rolRepository.save(rolExistente);
    }

    public Rol buscarPorId(int id) {
        return rolRepository.findById(id).orElseThrow(() -> new DAOException("Rol no encontrado"));
    }

    public Rol cambiarEstado(int id, EstadoEnum nuevoEstado) {
        Rol rol = rolRepository.findById(id).orElseThrow(() -> new DAOException("Rol no encontrado"));
        rol.setEstado(nuevoEstado);
        return rolRepository.save(rol);
    }

    public void eliminarPorId(int id) {
        if (!rolRepository.existsById(id)) {
            throw new DAOException("Rol no encontrado");
        }
        rolRepository.deleteById(id);
    }

    public Rol buscarPorDescripcion(String descripcion) {
        return rolRepository.findByDescripcion(descripcion);
    }
}
