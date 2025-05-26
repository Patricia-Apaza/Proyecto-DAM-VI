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

        // Para clientes
        String uploadPathClientes = System.getProperty("user.dir") + "/uploads/clientes/";
        registry.addResourceHandler("/imagenes/clientes/**")
                .addResourceLocations("file:" + uploadPathClientes);

        // Para hospedajes
        String uploadPathHospedajes = System.getProperty("user.dir") + "/uploads/hospedajes/";
        registry.addResourceHandler("/imagenes/hospedajes/**")
                .addResourceLocations("file:" + uploadPathHospedajes);

        // Para paquetes turísticos
        String uploadPathPaquetes = System.getProperty("user.dir") + "/uploads/paquetes/";
        registry.addResourceHandler("/imagenes/paquetes/**")
                .addResourceLocations("file:" + uploadPathPaquetes);

        // Para restaurantes
        String uploadPathRestaurantes = System.getProperty("user.dir") + "/uploads/restaurantes/";
        registry.addResourceHandler("/imagenes/restaurantes/**")
                .addResourceLocations("file:" + uploadPathRestaurantes);

        // Para menús diarios
        String uploadPathMenus = System.getProperty("user.dir") + "/uploads/menus/";
        registry.addResourceHandler("/imagenes/menus/**")
                .addResourceLocations("file:" + uploadPathMenus);
    }
}