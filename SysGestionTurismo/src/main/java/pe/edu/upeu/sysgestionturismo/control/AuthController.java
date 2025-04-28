package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.modelo.Usuario;
import pe.edu.upeu.sysgestionturismo.security.JwtRequest;
import pe.edu.upeu.sysgestionturismo.servicio.IUsuarioService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody JwtRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getContraseña())
            );
            response.put("message", "Login exitoso");
            response.put("correo", request.getCorreo());
            response.put("status", true);
        } catch (Exception e) {
            response.put("message", "Credenciales incorrectas");
            response.put("status", false);
        }
        return response;
    }


    @PostMapping("/registrar")
    public String registrar(@RequestBody Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        usuarioService.save(usuario);
        return "Usuario registrado exitosamente!";
    }
}
