package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long idUsuario;
    private String correo;
    private String contraseña;
    private String rol;
}
