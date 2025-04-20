package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.UsuarioDTO;
import pe.edu.upeu.sysgestionturismo.mappers.UsuarioMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Usuario;
import pe.edu.upeu.sysgestionturismo.repositorio.IUsuarioRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::toUsuarioDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return usuarioMapper.toUsuarioDto(usuario);
    }

    @Override
    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::toUsuarioDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO.UsuarioCrearDto usuarioCrearDto) {
        // Convertir el DTO UsuarioCrearDto a la entidad Usuario
        Usuario usuario = usuarioMapper.toUsuario(usuarioCrearDto);
        // Guardar el usuario en la base de datos
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        // Devolver el DTO correspondiente al usuario guardado
        return usuarioMapper.toUsuarioDto(usuarioGuardado);
    }

    @Override
    public UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioMapper.updateEntityFromDto(usuarioDTO, usuarioExistente);
        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);
        return usuarioMapper.toUsuarioDto(usuarioActualizado);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioDTO cambiarEstadoUsuario(Long id, boolean estado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setActivo(estado);
        Usuario usuarioActualizado = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioDto(usuarioActualizado);
    }

    @Override
    public UsuarioDTO login(UsuarioDTO.CredencialesDto credencialesDto) {
        Usuario usuario = usuarioRepository.findByCorreo(credencialesDto.user())
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));

        // Verificación de contraseña (aquí puede ir lógica de encriptación)
        if (!usuario.getContrasena().equals(new String(credencialesDto.clave()))) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        return usuarioMapper.toUsuarioDto(usuario);
    }

}