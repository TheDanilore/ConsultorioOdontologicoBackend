package com.mycompany.consultorio.controller.usuario;

import com.mycompany.consultorio.dto.usuario.UsuarioDTO;
import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Usuario;
import com.mycompany.consultorio.service.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired; // Importa la clase Autowired
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Importa las clases para la anotación de los métodos
import java.util.HashSet;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired // Inyección de dependencias
    private UsuarioService usuarioService; // Servicio para la entidad Usuario

    // Listar todos los usuarios
    @GetMapping
    public Page<UsuarioDTO> listarTodos(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return usuarioService.listarTodos(pageable).map(UsuarioDTO::fromEntity);
    }

    // Buscar un usuario por ID
    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return UsuarioDTO.fromEntity(usuario); // Convertir Usuario a UsuarioDTO
    }

    // Guardar un nuevo usuario
    @PostMapping
    public UsuarioDTO guardar(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toEntity(); // Convertir UsuarioDTO a Usuario
        // Si no se envían roles, asignar una lista vacía
        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            usuario.setRoles(new HashSet<>());
        }

        Usuario usuarioGuardado = usuarioService.guardar(usuario);
        return UsuarioDTO.fromEntity(usuarioGuardado); // Convertir Usuario a UsuarioDTO
    }

    // Editar un usuario existente
    @PutMapping("/editar/{id}")
    public UsuarioDTO editar(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toEntity(); // Convertir UsuarioDTO a Usuario
        // Manejar el caso de roles nulos o vacíos
        if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
            usuario.setRoles(new HashSet<>());
        }

        Usuario usuarioEditado = usuarioService.editar(id, usuario);
        return UsuarioDTO.fromEntity(usuarioEditado); // Convertir Usuario a UsuarioDTO
    }

    // Cambiar el estado de un usuario
    @PatchMapping("/cambiar-estado/{id}")
    public UsuarioDTO cambiarEstado(@PathVariable Long id, @RequestParam EstadoEnum nuevoEstado) {
        Usuario usuario = usuarioService.cambiarEstado(id, nuevoEstado);
        return UsuarioDTO.fromEntity(usuario); // Convertir Usuario a UsuarioDTO
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public void eliminarPorId(@PathVariable Long id) {
        usuarioService.eliminarPorId(id);
    }

    // Buscar un usuario por email
    @GetMapping("/buscar-email")
    public UsuarioDTO buscarPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        return UsuarioDTO.fromEntity(usuario); // Convertir Usuario a UsuarioDTO
    }

    // Listar usarios por nombres o email o id
    @GetMapping("/buscar")
    public ResponseEntity<Page<Usuario>> buscarPorCriterio(
            @RequestParam String criterio,
            @RequestParam int page,
            @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("nombre").ascending());
        Page<Usuario> usuarios = usuarioService.buscarPorCriterio(criterio, pageable);
        return ResponseEntity.ok(usuarios);
    }
}
