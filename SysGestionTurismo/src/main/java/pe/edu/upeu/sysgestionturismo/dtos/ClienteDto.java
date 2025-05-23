package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ClienteDto {
    private Long id_cliente;
    private String nombres;
    private String apellidos;
    private String tipo_documento;
    private String num_documento;
    private String direccion;
    private String correo;
    private String whatsapp_contacto;
    private String imagen_perfil;
}