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
import pe.edu.upeu.sysgestionturismo.dtos.ClienteDto;
import pe.edu.upeu.sysgestionturismo.mappers.ClienteMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Cliente;
import pe.edu.upeu.sysgestionturismo.servicio.IClienteService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/listar")
    public List<ClienteDto> listar() {
        return clienteService.findAll().stream()
                .map(ClienteMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public ClienteDto guardar(@RequestBody ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteDto);
        return ClienteMapper.toDto(clienteService.save(cliente));
    }

    @PutMapping("/editar")
    public ClienteDto editar(@RequestBody ClienteDto clienteDto) {
        Cliente cliente = ClienteMapper.toEntity(clienteDto);
        return ClienteMapper.toDto(clienteService.update(cliente));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public ClienteDto buscar(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        return cliente != null ? ClienteMapper.toDto(cliente) : null;
    }

    @PostMapping(value = "/guardar-con-imagen", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> guardarConImagen(
            @RequestParam("nombres") String nombres,
            @RequestParam("apellidos") String apellidos,
            @RequestParam(value = "tipoDocumento", required = false) String tipoDocumento,
            @RequestParam(value = "numDocumento", required = false) String numDocumento,
            @RequestParam(value = "direccion", required = false) String direccion,
            @RequestParam(value = "correo", required = false) String correo,
            @RequestParam(value = "whatsappContacto", required = false) String whatsappContacto,
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
            cliente.setTipoDocumento(tipoDocumento);
            cliente.setNumDocumento(numDocumento);
            cliente.setDireccion(direccion);
            cliente.setCorreo(correo);
            cliente.setWhatsappContacto(whatsappContacto);
            cliente.setImagenPerfil("/imagenes/clientes/" + nombreArchivo);

            return ResponseEntity.ok(ClienteMapper.toDto(clienteService.save(cliente)));

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