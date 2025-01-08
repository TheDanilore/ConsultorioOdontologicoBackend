package com.mycompany.consultorio.service;

import com.mycompany.consultorio.exception.DAOException;
import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Rol;
import com.mycompany.consultorio.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarTodos() {
        return rolRepository.findAll();
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol editar(int id, Rol rolActualizado) {
        Rol rolExistente = rolRepository.findById(id)
                .orElseThrow(() -> new DAOException("Rol no encontrado"));

        // Actualizar solo los campos permitidos
        rolExistente.setDescripcion(rolExistente.getDescripcion());
        return rolRepository.save(rolExistente);
    }

    public Rol buscarPorId(int id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol cambiarEstado(int id, EstadoEnum nuevoEstado) {
        Rol rol = rolRepository.findById(id).orElseThrow(() -> new DAOException("Rol no encontrado"));
        rol.setEstado(nuevoEstado);
        return rolRepository.save(rol);
    }

    

    public void eliminarPorId(int id) {
        rolRepository.deleteById(id);
    }

    public Rol buscarPorDescripcion(String descripcion) {
        return rolRepository.findByDescripcion(descripcion);
    }
}
