package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;
import pe.edu.upeu.sysgestionturismo.servicio.IRestauranteService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
@CrossOrigin(origins = "*")
public class RestauranteController {

    @Autowired
    private IRestauranteService restauranteService;

    @GetMapping("/listar")
    public List<Restaurante> listar() {
        return restauranteService.findAll();
    }

    @PostMapping("/guardar")
    public Restaurante guardar(@RequestBody Restaurante restaurante) {
        return restauranteService.save(restaurante);
    }

    @PutMapping("/editar")
    public Restaurante editar(@RequestBody Restaurante restaurante) {
        return restauranteService.update(restaurante);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        restauranteService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public Restaurante buscar(@PathVariable Long id) {
        return restauranteService.findById(id);
    }

    @GetMapping("/imagen/{nombre}")
    public ResponseEntity<Resource> verImagen(@PathVariable String nombre) {
        try {
            Path ruta = Paths.get("uploads/restaurantes").resolve(nombre).toAbsolutePath();
            Resource recurso = new UrlResource(ruta.toUri());

            if (!recurso.exists() || !recurso.isReadable()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok()
                    .contentType(MediaTypeFactory.getMediaType(nombre).orElse(MediaType.APPLICATION_OCTET_STREAM))
                    .body(recurso);

        } catch (MalformedURLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/guardar-con-imagen", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> guardarConImagen(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("direccion") String direccion,
            @RequestParam("whatsapp_contacto") String whatsappContacto,
            @RequestParam("id_destino") Long idDestino,
            @RequestParam("imagen") MultipartFile imagen) {

        try {
            if (imagen.isEmpty() || imagen.getOriginalFilename() == null) {
                return ResponseEntity.badRequest().body("La imagen está vacía o no tiene nombre.");
            }

            String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "restaurantes";
            String nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
            String rutaCompleta = rutaBase + File.separator + nombreArchivo;

            File carpetaDestino = new File(rutaBase);
            if (!carpetaDestino.exists() && !carpetaDestino.mkdirs()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("No se pudo crear la carpeta para almacenar la imagen.");
            }

            File archivoDestino = new File(rutaCompleta);
            imagen.transferTo(archivoDestino);

            Restaurante restaurante = new Restaurante();
            restaurante.setNombre(nombre);
            restaurante.setDescripcion(descripcion);
            restaurante.setDireccion(direccion);
            restaurante.setWhatsappContacto(whatsappContacto);

            // Asignar destino a partir del id
            Destino destino = new Destino();
            destino.setIdDestino(idDestino);
            restaurante.setDestino(destino);

            restaurante.setImagenPath("/imagenes/restaurantes/" + nombreArchivo);

            return ResponseEntity.ok(restauranteService.save(restaurante));

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la imagen: " + e.getMessage());
        }
    }
}
