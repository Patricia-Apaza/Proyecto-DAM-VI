package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements org.springframework.security.core.userdetails.UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String telefono;

    private String contrasena;

    private boolean activo;  // Este es el campo que indica si el usuario está activo

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    // Métodos necesarios para UserDetails
    @Override
    public String getUsername() {
        return correo;  // Asumiendo que el correo es el nombre de usuario
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Si el sistema no maneja expiración de cuentas
    }

    @Override
    public boolean isAccountNonLocked() {
        return activo;  // Si el usuario está activo o no (activo indica si está bloqueado o no)
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Si el sistema no maneja expiración de credenciales
    }

    @Override
    public boolean isEnabled() {
        return activo;  // Si el usuario está habilitado
    }

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));  // Rol predeterminado
    }
}
