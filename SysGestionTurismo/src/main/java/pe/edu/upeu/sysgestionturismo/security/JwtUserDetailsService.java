package pe.edu.upeu.sysgestionturismo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.Usuario;
import pe.edu.upeu.sysgestionturismo.repositorio.IUsuarioRepository;

@Service
public class JwtUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    // Cargar los detalles del usuario por nombre de usuario (correo)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario en la base de datos por correo
        Usuario usuario = usuarioRepository.findByCorreo(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + username));

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado con el correo: " + username);
        }

        // Crear un objeto UserDetails a partir de los detalles del usuario encontrado
        return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
    }
}