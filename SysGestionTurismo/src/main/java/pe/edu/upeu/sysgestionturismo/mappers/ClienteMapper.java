package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.ClienteDto;
import pe.edu.upeu.sysgestionturismo.modelo.Cliente;

public class ClienteMapper {

    public static ClienteDto toDto(Cliente cliente) {
        ClienteDto dto = new ClienteDto();
        dto.setId_cliente(cliente.getIdCliente());
        dto.setNombres(cliente.getNombres());
        dto.setApellidos(cliente.getApellidos());
        dto.setTipo_documento(cliente.getTipoDocumento());
        dto.setNum_documento(cliente.getNumDocumento());
        dto.setDireccion(cliente.getDireccion());
        dto.setCorreo(cliente.getCorreo());
        dto.setWhatsapp_contacto(cliente.getWhatsappContacto());
        dto.setImagen_perfil(cliente.getImagenPerfil());
        return dto;
    }

    public static Cliente toEntity(ClienteDto dto) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(dto.getId_cliente());
        cliente.setNombres(dto.getNombres());
        cliente.setApellidos(dto.getApellidos());
        cliente.setTipoDocumento(dto.getTipo_documento());
        cliente.setNumDocumento(dto.getNum_documento());
        cliente.setDireccion(dto.getDireccion());
        cliente.setCorreo(dto.getCorreo());
        cliente.setWhatsappContacto(dto.getWhatsapp_contacto());
        cliente.setImagenPerfil(dto.getImagen_perfil());
        return cliente;
    }
}
