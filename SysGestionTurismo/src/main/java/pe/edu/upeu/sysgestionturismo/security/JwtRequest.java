package pe.edu.upeu.sysgestionturismo.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Clase S2
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    private String correo;
    private String contraseña;
}
