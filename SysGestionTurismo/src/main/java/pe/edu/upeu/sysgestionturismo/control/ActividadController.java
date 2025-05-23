package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.servicio.IActividadService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/actividad")
@CrossOrigin(origins = "*")
public class ActividadController {

    @Autowired
    private IActividadService actividadService;

    @GetMapping("/listar")
    public List<Actividad> listar() {
        return actividadService.findAll();
    }

    @PostMapping("/guardar")
    public Actividad guardar(@RequestBody Actividad actividad) {
        return actividadService.save(actividad);
    }

    @PutMapping("/editar")
    public Actividad editar(@RequestBody Actividad actividad) {
        return actividadService.update(actividad);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        actividadService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public Actividad buscar(@PathVariable Long id) {
        return actividadService.findById(id);
    }

    @GetMapping("/imagen/{nombre}")
    public ResponseEntity<Resource> verImagen(@PathVariable String nombre) {
        try {
            Path ruta = Paths.get("uploads/actividades").resolve(nombre).toAbsolutePath();
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
            @RequestParam("idDestino") Long idDestino,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("nivelRiesgo") String nivelRiesgo,
            @RequestParam("whatsappContacto") String whatsappContacto,
            @RequestParam("precio") Double precio,
            @RequestPart("imagen") MultipartFile imagen) {

        try {
            if (imagen.isEmpty() || imagen.getOriginalFilename() == null) {
                return ResponseEntity.badRequest().body("La imagen está vacía o no tiene nombre.");
            }

            String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "actividades";
            String nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
            String rutaCompleta = rutaBase + File.separator + nombreArchivo;

            File carpetaDestino = new File(rutaBase);
            if (!carpetaDestino.exists()) {
                boolean creada = carpetaDestino.mkdirs();
                if (!creada) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("No se pudo crear la carpeta para almacenar la imagen.");
                }
            }

            File archivoDestino = new File(rutaCompleta);
            imagen.transferTo(archivoDestino);

            Actividad actividad = new Actividad();
            pe.edu.upeu.sysgestionturismo.modelo.Destino destino = new pe.edu.upeu.sysgestionturismo.modelo.Destino();
            destino.setIdDestino(idDestino);
            actividad.setDestino(destino);

            actividad.setNombre(nombre);
            actividad.setDescripcion(descripcion);
            actividad.setNivelRiesgo(nivelRiesgo);
            actividad.setWhatsappContacto(whatsappContacto);
            actividad.setPrecio(precio);
            actividad.setImagenPath("/imagenes/actividades/" + nombreArchivo);

            return ResponseEntity.ok(actividadService.save(actividad));

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la imagen: " + e.getMessage());
        }
    }
}