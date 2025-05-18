package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.servicio.IDestinoService;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/destino")
@CrossOrigin(origins = "*")
public class DestinoController {

    @Autowired
    private IDestinoService destinoService;

    @GetMapping("/listar")
    public List<Destino> listar() {
        return destinoService.findAll();
    }

    @PostMapping("/guardar")
    public Destino guardar(@RequestBody Destino destino) {
        return destinoService.save(destino);
    }

    @PutMapping("/editar")
    public Destino editar(@RequestBody Destino destino) {
        return destinoService.update(destino);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        destinoService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public Destino buscar(@PathVariable Long id) {
        return destinoService.findById(id);
    }

    @GetMapping("/imagen/{nombre}")
    public ResponseEntity<Resource> verImagen(@PathVariable String nombre) {
        try {
            Path ruta = Paths.get("uploads/destinos").resolve(nombre).toAbsolutePath();
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
            @RequestPart("nombre") String nombre,
            @RequestPart("descripcion") String descripcion,
            @RequestPart("ubicacion") String ubicacion,
            @RequestPart("imagen") MultipartFile imagen) {

        try {
            if (imagen.isEmpty() || imagen.getOriginalFilename() == null) {
                return ResponseEntity.badRequest().body("La imagen está vacía o no tiene nombre.");
            }

            // Ruta absoluta donde quieres guardar las imágenes (ajusta si usas otra)
            String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "destinos";
            String nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
            String rutaCompleta = rutaBase + File.separator + nombreArchivo;

            // Crear carpeta si no existe
            File carpetaDestino = new File(rutaBase);
            if (!carpetaDestino.exists()) {
                boolean creada = carpetaDestino.mkdirs();
                if (!creada) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("No se pudo crear la carpeta para almacenar la imagen.");
                }
            }

            // Guardar archivo
            File archivoDestino = new File(rutaCompleta);
            imagen.transferTo(archivoDestino);

            // Guardar en base de datos la ruta relativa (útil para exponer después)
            Destino destino = new Destino();
            destino.setNombre(nombre);
            destino.setDescripcion(descripcion);
            destino.setUbicacion(ubicacion);
            destino.setImagenPath("/imagenes/destinos/" + nombreArchivo);

            return ResponseEntity.ok(destinoService.save(destino));

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la imagen: " + e.getMessage());
        }
    }
}