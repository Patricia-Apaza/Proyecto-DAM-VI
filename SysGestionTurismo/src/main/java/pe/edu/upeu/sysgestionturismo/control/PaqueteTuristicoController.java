package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.http.MediaTypeFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteTuristicoService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/paquete")
@CrossOrigin(origins = "*")
public class PaqueteTuristicoController {

    @Autowired
    private IPaqueteTuristicoService paqueteTuristicoService;

    @GetMapping("/listar")
    public List<PaqueteTuristico> listar() {
        return paqueteTuristicoService.findAll();
    }

    @PostMapping("/guardar")
    public PaqueteTuristico guardar(@RequestBody PaqueteTuristico paquete) {
        return paqueteTuristicoService.save(paquete);
    }

    @PutMapping("/editar")
    public PaqueteTuristico editar(@RequestBody PaqueteTuristico paquete) {
        return paqueteTuristicoService.update(paquete);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        paqueteTuristicoService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public PaqueteTuristico buscar(@PathVariable Long id) {
        return paqueteTuristicoService.findById(id);
    }

    // Servir imagen del paquete
    @GetMapping("/imagen/{nombre}")
    public ResponseEntity<Resource> verImagen(@PathVariable String nombre) {
        try {
            Path ruta = Paths.get("uploads/paquetes").resolve(nombre).toAbsolutePath();
            Resource recurso = new UrlResource(ruta.toUri());

            if (!recurso.exists() || !recurso.isReadable()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok()
                    .contentType(MediaTypeFactory.getMediaType(nombre).orElse(MediaType.APPLICATION_OCTET_STREAM))
                    .body(recurso);

        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Guardar paquete con imagen y destino
    @PostMapping(value = "/guardar-con-imagen", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> guardarConImagen(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("duracionDias") Integer duracionDias,
            @RequestParam("whatsappContacto") String whatsappContacto,
            @RequestParam("precio") Double precio,
            @RequestParam("idDestino") Long idDestino,
            @RequestPart("imagen") MultipartFile imagen) {

        try {
            if (imagen.isEmpty() || imagen.getOriginalFilename() == null) {
                return ResponseEntity.badRequest().body("La imagen está vacía o no tiene nombre.");
            }

            String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "paquetes";
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

            PaqueteTuristico paquete = new PaqueteTuristico();
            paquete.setNombre(nombre);
            paquete.setDescripcion(descripcion);
            paquete.setDuracionDias(duracionDias);
            paquete.setWhatsappContacto(whatsappContacto);
            paquete.setPrecioTotal(precio);

            // Setear destino si existe
            if (idDestino != null) {
                Destino destino = new Destino();
                destino.setIdDestino(idDestino);
                paquete.setDestino(destino);
            }

            // Guardar solo el nombre del archivo para la imagen
            paquete.setImagenPath(nombreArchivo);

            return ResponseEntity.ok(paqueteTuristicoService.save(paquete));

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la imagen: " + e.getMessage());
        }
    }
}