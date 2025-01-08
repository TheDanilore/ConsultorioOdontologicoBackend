package com.mycompany.consultorio.controller.usuario;

import com.mycompany.consultorio.dto.UsuarioDTO;
import com.mycompany.consultorio.model.EstadoEnum;
import com.mycompany.consultorio.model.usuario.Usuario;
import com.mycompany.consultorio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired; // Importa la clase Autowired
import org.springframework.web.bind.annotation.*; // Importa las clases para la anotación de los métodos

import java.util.List;
import java.util.stream.Collectors;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired // Inyección de dependencias
    private UsuarioService usuarioService; // Servicio para la entidad Usuario

    // Listar todos los usuarios
    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return usuarioService.listarTodos()
                .stream()
                .map(UsuarioDTO::fromEntity) // Convertir cada Usuario a UsuarioDTO
                .collect(Collectors.toList());
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
        Usuario usuarioGuardado = usuarioService.guardar(usuario);
        return UsuarioDTO.fromEntity(usuarioGuardado); // Convertir Usuario a UsuarioDTO
    }

    // Editar un usuario existente
    @PutMapping("/editar/{id}")
    public UsuarioDTO editar(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioDTO.toEntity(); // Convertir UsuarioDTO a Usuario
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
}
