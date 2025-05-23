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
import pe.edu.upeu.sysgestionturismo.modelo.Cliente;
import pe.edu.upeu.sysgestionturismo.servicio.IClienteService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/listar")
    public List<Cliente> listar() {
        return clienteService.findAll();
    }

    @PostMapping("/guardar")
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/editar")
    public Cliente editar(@RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping(value = "/guardar-con-imagen", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> guardarConImagen(
            @RequestParam("nombres") String nombres,
            @RequestParam("apellidos") String apellidos,
            @RequestParam(value = "numDocumento", required = false) String numDocumento,
            @RequestParam(value = "whatsappContacto", required = false) String whatsappContacto,
            @RequestParam(value = "correo", required = false) String correo,
            @RequestParam(value = "direccion", required = false) String direccion,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestPart("imagenPerfil") MultipartFile imagen) {

        try {
            if (imagen.isEmpty() || imagen.getOriginalFilename() == null) {
                return ResponseEntity.badRequest().body("La imagen está vacía o no tiene nombre.");
            }

            String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "clientes";
            String nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
            String rutaCompleta = rutaBase + File.separator + nombreArchivo;

            File carpetaDestino = new File(rutaBase);
            if (!carpetaDestino.exists() && !carpetaDestino.mkdirs()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("No se pudo crear la carpeta para almacenar la imagen.");
            }

            File archivoDestino = new File(rutaCompleta);
            imagen.transferTo(archivoDestino);

            Cliente cliente = new Cliente();
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setNumDocumento(numDocumento);
            cliente.setWhatsappContacto(whatsappContacto);
            cliente.setCorreo(correo);
            cliente.setDireccion(direccion);
            cliente.setTipoDocumento(tipoDocumento);
            cliente.setImagenPerfil("/imagenes/clientes/" + nombreArchivo);

            return ResponseEntity.ok(clienteService.save(cliente));

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la imagen: " + e.getMessage());
        }
    }

    @GetMapping("/imagen/{nombre}")
    public ResponseEntity<Resource> verImagen(@PathVariable String nombre) {
        try {
            Path ruta = Paths.get("uploads/clientes").resolve(nombre).toAbsolutePath();
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
}