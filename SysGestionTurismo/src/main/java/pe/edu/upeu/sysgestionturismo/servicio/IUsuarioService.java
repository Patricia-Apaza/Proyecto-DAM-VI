package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {

    List<UsuarioDTO> listarUsuarios();

    UsuarioDTO obtenerUsuarioPorId(Long id);

    UsuarioDTO actualizarUsuario(Long id, UsuarioDTO usuarioDTO);

    void eliminarUsuario(Long id);

    UsuarioDTO cambiarEstadoUsuario(Long id, boolean estado);

    List<UsuarioDTO> obtenerTodosLosUsuarios();

    // Sólo este método debe quedar
    UsuarioDTO registrarUsuario(UsuarioDTO.UsuarioCrearDto user);

    UsuarioDTO login(UsuarioDTO.CredencialesDto credencialesDto);
}