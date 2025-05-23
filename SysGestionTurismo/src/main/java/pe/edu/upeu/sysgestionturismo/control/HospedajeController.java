package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.modelo.Hospedaje;
import pe.edu.upeu.sysgestionturismo.servicio.IHospedajeService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/hospedaje")
@CrossOrigin(origins = "*")
public class HospedajeController {

    @Autowired
    private IHospedajeService hospedajeService;

    @GetMapping("/listar")
    public List<Hospedaje> listar() {
        return hospedajeService.findAll();
    }

    @PostMapping("/guardar")
    public Hospedaje guardar(@RequestBody Hospedaje hospedaje) {
        return hospedajeService.save(hospedaje);
    }

    @PutMapping("/editar")
    public Hospedaje editar(@RequestBody Hospedaje hospedaje) {
        return hospedajeService.update(hospedaje);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        hospedajeService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public Hospedaje buscar(@PathVariable Long id) {
        return hospedajeService.findById(id);
    }

    @GetMapping("/imagen/{nombre}")
    public ResponseEntity<Resource> verImagen(@PathVariable String nombre) {
        try {
            Path ruta = Paths.get("uploads/hospedajes").resolve(nombre).toAbsolutePath();
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
            @RequestParam("direccion") String direccion,
            @RequestParam("whatsappContacto") String whatsappContacto,
            @RequestParam("precioPorNoche") Double precioPorNoche,
            @RequestPart("imagen") MultipartFile imagen) {

        try {
            if (imagen.isEmpty() || imagen.getOriginalFilename() == null) {
                return ResponseEntity.badRequest().body("La imagen está vacía o no tiene nombre.");
            }

            String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "hospedajes";
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

            Hospedaje hospedaje = new Hospedaje();
            Destino destino = new Destino();
            destino.setIdDestino(idDestino);
            hospedaje.setDestino(destino);

            hospedaje.setNombre(nombre);
            hospedaje.setDescripcion(descripcion);
            hospedaje.setDireccion(direccion);
            hospedaje.setWhatsappContacto(whatsappContacto);
            hospedaje.setPrecioPorNoche(precioPorNoche);
            hospedaje.setImagenPath("/imagenes/hospedajes/" + nombreArchivo);

            return ResponseEntity.ok(hospedajeService.save(hospedaje));

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la imagen: " + e.getMessage());
        }
    }
}