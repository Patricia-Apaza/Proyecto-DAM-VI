package pe.edu.upeu.sysgestionturismo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import pe.edu.upeu.sysgestionturismo.dtos.CheckOutDTO;
import pe.edu.upeu.sysgestionturismo.dtos.ClienteDTO;
import pe.edu.upeu.sysgestionturismo.modelo.CheckOut;
import pe.edu.upeu.sysgestionturismo.modelo.Cliente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toClienteDTO(Cliente cliente);

    Cliente toCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> toClienteDTOs(List<Cliente> clientes);

    List<Cliente> toClientes(List<ClienteDTO> clienteDTOs);

    void updateEntityFromDto(ClienteDTO dto, @MappingTarget Cliente cliente);

}
