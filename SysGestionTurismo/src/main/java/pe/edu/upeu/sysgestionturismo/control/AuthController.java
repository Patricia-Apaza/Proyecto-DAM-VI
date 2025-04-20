package pe.edu.upeu.sysgestionturismo.control;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.sysgestionturismo.dtos.UsuarioDTO;
import pe.edu.upeu.sysgestionturismo.security.JwtTokenUtil;
import pe.edu.upeu.sysgestionturismo.security.JwtUserDetailsService;
import pe.edu.upeu.sysgestionturismo.servicio.IUsuarioService;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class AuthController {
    private final IUsuarioService usuarioService;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService jwtUserDetailsService;
    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody @Valid UsuarioDTO.CredencialesDto credencialesDto, HttpServletRequest request) {
        UsuarioDTO usuarioDTO = usuarioService.login(credencialesDto);
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(credencialesDto.user());
        usuarioDTO.setToken(jwtTokenUtil.generateToken(userDetails));
        request.getSession().setAttribute("USER-SESSION", usuarioDTO.getUser());
        return ResponseEntity.ok(usuarioDTO);
    }
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO>register(@RequestBody @Valid UsuarioDTO.UsuarioCrearDto user){
        System.out.println("Pas..."+user.rol());
        UsuarioDTO createUser=usuarioService.registrarUsuario(user);
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.user());
        createUser.setToken(jwtTokenUtil.generateToken(userDetails));
        return ResponseEntity.created(URI.create("/users/"+createUser.getUser())).body(createUser);

    }

}
