package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ClienteDto {
    private Long idCliente;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String direccion;
}

