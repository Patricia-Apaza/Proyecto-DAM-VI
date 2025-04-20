package pe.edu.upeu.sysgestionturismo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import pe.edu.upeu.sysgestionturismo.servicio.CustomUserDetailsService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private pe.edu.upeu.sysgestionturismo.servicio.CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request,
                                    jakarta.servlet.http.HttpServletResponse response,
                                    jakarta.servlet.FilterChain chain)
    throws jakarta.servlet.ServletException, java.io.IOException {


        final String header = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        // Si el encabezado contiene "Bearer", se obtiene el token JWT
        if (header != null && header.startsWith("Bearer ")) {
            jwtToken = header.substring(7);
            username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        }

        // Si el nombre de usuario está en el contexto de seguridad y es válido, se configura la autenticación
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            // Si el token es válido, se establece la autenticación en el contexto de seguridad
            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                WebAuthenticationDetailsSource detailsSource = new WebAuthenticationDetailsSource();
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(detailsSource.buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);  // Continúa la cadena de filtros
    }
}