package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.UsuarioDTO;
import pe.edu.upeu.sysgestionturismo.modelo.Usuario;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    // Instancia de Mapper
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    // Método para convertir de Usuario a UsuarioDTO
    UsuarioDTO toUsuarioDto(Usuario usuario);

    // Método para convertir de UsuarioDTO a Usuario
    Usuario toUsuario(UsuarioDTO usuarioDTO);

    // Método para convertir UsuarioCrearDto a Usuario
    Usuario toUsuario(UsuarioDTO.UsuarioCrearDto usuarioCrearDto);

    // Método para convertir una lista de Usuario a una lista de UsuarioDTO
    List<UsuarioDTO> toDtoList(List<Usuario> usuarios);

    // Método para convertir una lista de UsuarioDTO a una lista de Usuario
    List<Usuario> toEntityList(List<UsuarioDTO> usuarioDTOs);

    void updateEntityFromDto(UsuarioDTO dto, @MappingTarget Usuario entity);
}
