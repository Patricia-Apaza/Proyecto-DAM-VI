package pe.edu.upeu.sysgestionturismo.control;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.UsuarioDto;
import pe.edu.upeu.sysgestionturismo.dtos.LoginResponse; // <- AGREGAR ESTA IMPORTACIÓN
import pe.edu.upeu.sysgestionturismo.security.JwtRequest;
import pe.edu.upeu.sysgestionturismo.security.JwtResponse;
import pe.edu.upeu.sysgestionturismo.security.JwtTokenUtil;
import pe.edu.upeu.sysgestionturismo.security.JwtUserDetailsService;
import pe.edu.upeu.sysgestionturismo.modelo.Usuario;
import pe.edu.upeu.sysgestionturismo.servicio.IUsuarioService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getCorreo(),
                            authenticationRequest.getContraseña()
                    )
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getCorreo());
            String token = jwtTokenUtil.generateToken(userDetails);

            // Obtener información del usuario para incluir el rol en la respuesta
            Usuario usuario = usuarioService.findByCorreo(authenticationRequest.getCorreo());

            // Crear respuesta consistente para el frontend
            LoginResponse response = new LoginResponse();
            response.setMessage("Login exitoso");
            response.setCorreo(usuario.getCorreo());
            response.setStatus(true);
            response.setToken(token);
            response.setRol(usuario.getRol());

            return ResponseEntity.ok(response);

        } catch (BadCredentialsException e) {
            // Devolver respuesta consistente para errores
            LoginResponse errorResponse = new LoginResponse();
            errorResponse.setMessage("Credenciales inválidas");
            errorResponse.setCorreo("");
            errorResponse.setStatus(false);
            errorResponse.setToken("");
            errorResponse.setRol("");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader("Authorization") String token) {
        try {
            if (token.startsWith("Bearer ")) {
                String jwtToken = token.substring(7);
                String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                    Usuario usuario = usuarioService.findByCorreo(username);
                    return ResponseEntity.ok(new UsuarioDto(
                            usuario.getIdUsuario(),
                            usuario.getCorreo(),
                            null, // No enviar contraseña
                            usuario.getRol(),
                            null
                    ));
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        }
    }

    @PostMapping("/registrar")
    public String registrar(@RequestBody Usuario usuario) {
        usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        usuarioService.save(usuario);
        return "Usuario registrado exitosamente!";
    }
}