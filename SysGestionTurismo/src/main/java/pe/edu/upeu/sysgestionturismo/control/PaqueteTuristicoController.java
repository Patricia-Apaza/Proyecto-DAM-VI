package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.http.MediaTypeFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.sysgestionturismo.dtos.NivelPaqueteDto;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.mappers.NivelPaqueteMapper;
import pe.edu.upeu.sysgestionturismo.modelo.*;
import pe.edu.upeu.sysgestionturismo.servicio.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paquete")
@CrossOrigin(origins = "*")
public class PaqueteTuristicoController {

    @Autowired
    private IPaqueteTuristicoService paqueteTuristicoService;

    @Autowired
    private INivelPaqueteService nivelPaqueteService;

    // ===== ENDPOINTS BÁSICOS =====

    @GetMapping("/listar")
    public List<PaqueteTuristico> listar() {
        return paqueteTuristicoService.findAll();
    }

    @GetMapping("/listar-con-relaciones")
    public List<PaqueteTuristicoDto> listarConRelaciones() {
        return paqueteTuristicoService.findAllWithRelations();
    }

    @PostMapping("/guardar")
    public PaqueteTuristico guardar(@RequestBody PaqueteTuristico paquete) {
        return paqueteTuristicoService.save(paquete);
    }

    @PostMapping("/guardar-con-relaciones")
    public ResponseEntity<?> guardarConRelaciones(@RequestBody PaqueteTuristicoDto dto) {
        try {
            PaqueteTuristico paquete = paqueteTuristicoService.saveWithRelations(dto);
            return ResponseEntity.ok(paquete);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar paquete: " + e.getMessage());
        }
    }

    @PutMapping("/editar")
    public PaqueteTuristico editar(@RequestBody PaqueteTuristico paquete) {
        return paqueteTuristicoService.update(paquete);
    }

    @PutMapping("/editar-con-relaciones")
    public ResponseEntity<?> editarConRelaciones(@RequestBody PaqueteTuristicoDto dto) {
        try {
            PaqueteTuristico paquete = paqueteTuristicoService.updateWithRelations(dto);
            return ResponseEntity.ok(paquete);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar paquete: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            paqueteTuristicoService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar paquete: " + e.getMessage());
        }
    }

    @GetMapping("/buscar/{id}")
    public PaqueteTuristico buscar(@PathVariable Long id) {
        return paqueteTuristicoService.findById(id);
    }

    @GetMapping("/buscar-con-relaciones/{id}")
    public PaqueteTuristicoDto buscarConRelaciones(@PathVariable Long id) {
        return paqueteTuristicoService.findByIdWithRelations(id);
    }

    // ===== ENDPOINTS PARA NIVELES DE PAQUETE =====

    @GetMapping("/niveles")
    public List<NivelPaqueteDto> listarNiveles() {
        return nivelPaqueteService.findAll().stream()
                .map(NivelPaqueteMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/niveles")
    public NivelPaqueteDto crearNivel(@RequestBody NivelPaqueteDto dto) {
        NivelPaquete nivel = NivelPaqueteMapper.toEntity(dto);
        nivel = nivelPaqueteService.save(nivel);
        return NivelPaqueteMapper.toDto(nivel);
    }

    // ===== MANEJO DE IMÁGENES =====

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

    // ===== GUARDAR CON IMAGEN Y RELACIONES =====

    @PostMapping(value = "/guardar-completo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> guardarCompleto(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("duracionDias") Integer duracionDias,
            @RequestParam("whatsappContacto") String whatsappContacto,
            @RequestParam("precio") Double precio,
            @RequestParam("idDestino") Long idDestino,
            @RequestParam("idNivelPaquete") Long idNivelPaquete,
            @RequestParam(value = "actividadesIds", required = false) String actividadesIds,
            @RequestParam(value = "destinosIds", required = false) String destinosIds,
            @RequestParam(value = "hospedajesIds", required = false) String hospedajesIds,
            @RequestParam(value = "restaurantesIds", required = false) String restaurantesIds,
            @RequestPart("imagen") MultipartFile imagen) {

        try {
            if (imagen.isEmpty() || imagen.getOriginalFilename() == null) {
                return ResponseEntity.badRequest().body("La imagen está vacía o no tiene nombre.");
            }

            // Guardar imagen
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

            // Crear DTO
            PaqueteTuristicoDto dto = new PaqueteTuristicoDto();
            dto.setNombre(nombre);
            dto.setDescripcion(descripcion);
            dto.setDuracionDias(duracionDias);
            dto.setWhatsappContacto(whatsappContacto);
            dto.setPrecioTotal(precio);
            dto.setIdDestino(idDestino);
            dto.setIdNivelPaquete(idNivelPaquete);
            dto.setImagenPath(nombreArchivo);

            // Procesar IDs de relaciones
            if (actividadesIds != null && !actividadesIds.trim().isEmpty()) {
                dto.setActividadesIds(Arrays.stream(actividadesIds.split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()));
            }

            if (destinosIds != null && !destinosIds.trim().isEmpty()) {
                dto.setDestinosIds(Arrays.stream(destinosIds.split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()));
            }

            if (hospedajesIds != null && !hospedajesIds.trim().isEmpty()) {
                dto.setHospedajesIds(Arrays.stream(hospedajesIds.split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()));
            }

            if (restaurantesIds != null && !restaurantesIds.trim().isEmpty()) {
                dto.setRestaurantesIds(Arrays.stream(restaurantesIds.split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()));
            }

            PaqueteTuristico paquete = paqueteTuristicoService.saveWithRelations(dto);
            return ResponseEntity.ok(paquete);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar la imagen: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar el paquete: " + e.getMessage());
        }
    }

    @PostMapping(value = "/editar-completo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> editarCompleto(
            @RequestParam("idPaqueteTuristico") Long idPaqueteTuristico,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("duracionDias") Integer duracionDias,
            @RequestParam("whatsappContacto") String whatsappContacto,
            @RequestParam("precio") Double precio,
            @RequestParam("idDestino") Long idDestino,
            @RequestParam("idNivelPaquete") Long idNivelPaquete,
            @RequestParam(value = "actividadesIds", required = false) String actividadesIds,
            @RequestParam(value = "destinosIds", required = false) String destinosIds,
            @RequestParam(value = "hospedajesIds", required = false) String hospedajesIds,
            @RequestParam(value = "restaurantesIds", required = false) String restaurantesIds,
            @RequestPart(value = "imagen", required = false) MultipartFile imagen) {

        try {
            String nombreArchivo = null;

            // Si hay nueva imagen, guardar
            if (imagen != null && !imagen.isEmpty() && imagen.getOriginalFilename() != null) {
                String rutaBase = System.getProperty("user.dir") + File.separator + "uploads" + File.separator + "paquetes";
                nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();
                String rutaCompleta = rutaBase + File.separator + nombreArchivo;

                File carpetaDestino = new File(rutaBase);
                if (!carpetaDestino.exists()) {
                    carpetaDestino.mkdirs();
                }

                File archivoDestino = new File(rutaCompleta);
                imagen.transferTo(archivoDestino);
            } else {
                // Mantener imagen existente
                PaqueteTuristico paqueteExistente = paqueteTuristicoService.findById(idPaqueteTuristico);
                if (paqueteExistente != null) {
                    nombreArchivo = paqueteExistente.getImagenPath();
                }
            }

            // Crear DTO
            PaqueteTuristicoDto dto = new PaqueteTuristicoDto();
            dto.setIdPaqueteTuristico(idPaqueteTuristico);
            dto.setNombre(nombre);
            dto.setDescripcion(descripcion);
            dto.setDuracionDias(duracionDias);
            dto.setWhatsappContacto(whatsappContacto);
            dto.setPrecioTotal(precio);
            dto.setIdDestino(idDestino);
            dto.setIdNivelPaquete(idNivelPaquete);
            dto.setImagenPath(nombreArchivo);

            // Procesar IDs de relaciones (mismo código que en guardar)
            if (actividadesIds != null && !actividadesIds.trim().isEmpty()) {
                dto.setActividadesIds(Arrays.stream(actividadesIds.split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()));
            }

            if (destinosIds != null && !destinosIds.trim().isEmpty()) {
                dto.setDestinosIds(Arrays.stream(destinosIds.split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()));
            }

            if (hospedajesIds != null && !hospedajesIds.trim().isEmpty()) {
                dto.setHospedajesIds(Arrays.stream(hospedajesIds.split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()));
            }

            if (restaurantesIds != null && !restaurantesIds.trim().isEmpty()) {
                dto.setRestaurantesIds(Arrays.stream(restaurantesIds.split(","))
                        .map(String::trim)
                        .map(Long::parseLong)
                        .collect(Collectors.toList()));
            }

            PaqueteTuristico paquete = paqueteTuristicoService.updateWithRelations(dto);
            return ResponseEntity.ok(paquete);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el paquete: " + e.getMessage());
        }
    }
}