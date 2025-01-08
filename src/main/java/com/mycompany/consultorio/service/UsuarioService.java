package com.mycompany.consultorio.service;

import com.mycompany.consultorio.exception.DAOException;
import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Usuario;
import com.mycompany.consultorio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Autenticación
    public Usuario autenticar(String email, String password) throws DAOException {
        // Cargar usuario por email y roles
        Usuario usuario = usuarioRepository.findByEmailWithRoles(email)
                .orElseThrow(() -> new DAOException("Usuario no encontrado o inactivo."));

        if (usuario.getEstado() != EstadoEnum.Activo) {
            throw new DAOException("Usuario no está activo.");
        }

        if (!BCrypt.checkpw(password, usuario.getPassword())) {
            throw new DAOException("Contraseña incorrecta.");
        }

        // Los roles ya deberían estar cargados aquí si la consulta funciona
        // correctamente.
        return usuario;
    }

    // Listar todos los usuarios
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // Guardar un nuevo usuario
    public Usuario guardar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new DAOException("El email ya está registrado.");
        }

        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            throw new DAOException("La contraseña es obligatoria.");
        }

        // Verifica si los roles son nulos o vacíos y los inicializa
        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            usuario.setRoles(new HashSet<>());
        }

        // Encriptar la contraseña
        usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));
        usuario.setEstado(EstadoEnum.Activo); // Estado por defecto
        return usuarioRepository.save(usuario);
    }

    // Editar un usuario existente
    public Usuario editar(Long id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new DAOException("Usuario no encontrado"));

        usuarioExistente.setNombre(usuarioActualizado.getNombre());
        usuarioExistente.setEmail(usuarioActualizado.getEmail());

        if (usuarioActualizado.getPassword() != null && !usuarioActualizado.getPassword().isEmpty()) {
            usuarioExistente.setPassword(BCrypt.hashpw(usuarioActualizado.getPassword(), BCrypt.gensalt()));
        }
        usuarioExistente.setRoles(usuarioActualizado.getRoles() != null ? usuarioActualizado.getRoles() : new HashSet<>());
    
        return usuarioRepository.save(usuarioExistente);
    }

    // Buscar usuario por ID
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new DAOException("Usuario no encontrado"));
    }

    // Cambiar el estado de un usuario
    public Usuario cambiarEstado(Long id, EstadoEnum nuevoEstado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new DAOException("Usuario no encontrado"));

        usuario.setEstado(nuevoEstado);
        return usuarioRepository.save(usuario);
    }

    // Eliminar usuario por ID
    public void eliminarPorId(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new DAOException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    // Buscar usuario por email
    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new DAOException("Usuario no encontrado"));
    }
}
