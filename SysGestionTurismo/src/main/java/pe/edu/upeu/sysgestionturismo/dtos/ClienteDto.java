package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ClienteDto {
    private Long idCliente;
    private String nombres;
    private String apellidos;
    private String numDocumento;
    private String imagenPerfil;
    private String whatsappContacto;
    private String correo;
    private String direccion;
    private String tipoDocumento;
}