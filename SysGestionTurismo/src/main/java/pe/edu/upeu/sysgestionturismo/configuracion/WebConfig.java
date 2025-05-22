package pe.edu.upeu.sysgestionturismo.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Para destinos
        String uploadPathDestinos = System.getProperty("user.dir") + "/uploads/destinos/";
        registry.addResourceHandler("/imagenes/destinos/**")
                .addResourceLocations("file:" + uploadPathDestinos);

        // Para actividades
        String uploadPathActividades = System.getProperty("user.dir") + "/uploads/actividades/";
        registry.addResourceHandler("/imagenes/actividades/**")
                .addResourceLocations("file:" + uploadPathActividades);
    }
}