package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.modelo.MenuDiario;
import pe.edu.upeu.sysgestionturismo.servicio.IMenuDiarioService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/menu-diario")
@CrossOrigin(origins = "*")
public class MenuDiarioController {

    @Autowired
    private IMenuDiarioService menuService;

    @GetMapping("/listar")
    public List<MenuDiario> listar() {
        return menuService.findAll();
    }

    @PostMapping("/guardar")
    public MenuDiario guardar(@RequestBody MenuDiario menu) {
        return menuService.save(menu);
    }

    @PutMapping("/editar")
    public MenuDiario editar(@RequestBody MenuDiario menu) {
        return menuService.update(menu);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        menuService.delete(id);
    }

    @GetMapping("/buscar/{id}")
    public MenuDiario buscar(@PathVariable Long id) {
        return menuService.findById(id);
    }

    @GetMapping("/imagen/{nombre}")
    public ResponseEntity<Resource> verImagen(@PathVariable String nombre) {
        try {
            Path ruta = Paths.get("uploads/menus").resolve(nombre).toAbsolutePath();
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
            @RequestParam("idRestaurante") Long idRestaurante,
            @RequestParam("fecha") String fecha,
            @RequestParam("nombrePlato") String nombrePlato,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") String precio,
            @RequestParam("imagen") MultipartFile imagen) {

        try {
            if (imagen.isEmpty() || imagen.getOriginalFilename() == null) {
                return ResponseEntity.badRequest().body("Imagen vacía o sin nombre.");
            }

            String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "menus";
            String nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
            String rutaCompleta = rutaBase + File.separator + nombreArchivo;

            File carpeta = new File(rutaBase);
            if (!carpeta.exists()) carpeta.mkdirs();

            imagen.transferTo(new File(rutaCompleta));

            MenuDiario menu = new MenuDiario();
            menu.setNombrePlato(nombrePlato);
            menu.setDescripcion(descripcion);
            menu.setFecha(java.time.LocalDate.parse(fecha));
            menu.setPrecio(new java.math.BigDecimal(precio));
            menu.setImagenPath("/imagenes/menus/" + nombreArchivo);

            // Asociar restaurante
            if (idRestaurante != null) {
                pe.edu.upeu.sysgestionturismo.modelo.Restaurante restaurante = new pe.edu.upeu.sysgestionturismo.modelo.Restaurante();
                restaurante.setIdRestaurante(idRestaurante);
                menu.setRestaurante(restaurante);
            }

            return ResponseEntity.ok(menuService.save(menu));

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar imagen: " + e.getMessage());
        }
    }
}
