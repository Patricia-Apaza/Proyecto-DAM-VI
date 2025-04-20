package pe.edu.upeu.sysgestionturismo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Configura la clase principal de la aplicación
        return application.sources(SysGestionTurismoApplication.class);
    }
}