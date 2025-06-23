package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String message;
    private String correo;
    private boolean status;
    private String token;
    private String rol;
}