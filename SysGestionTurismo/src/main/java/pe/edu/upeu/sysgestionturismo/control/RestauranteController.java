package pe.edu.upeu.sysgestionturismo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.sysgestionturismo.dtos.RestauranteDTO;
import pe.edu.upeu.sysgestionturismo.servicio.IRestauranteService;


import java.util.List;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private IRestauranteService restauranteService;

    // Obtener todos los restaurantes
    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> obtenerTodosLosRestaurantes() {
        return ResponseEntity.ok(restauranteService.listarRestaurantes());
    }

    // Obtener restaurante por ID
    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> obtenerRestaurantePorId(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteService.obtenerRestaurantePorId(id));
    }

    // Registrar un nuevo restaurante
    @PostMapping
    public ResponseEntity<RestauranteDTO> registrarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        return new ResponseEntity<>(restauranteService.registrarRestaurante(restauranteDTO), HttpStatus.CREATED);
    }

    // Actualizar un restaurante existente
    @PutMapping("/{id}")
    public ResponseEntity<RestauranteDTO> actualizarRestaurante(@PathVariable Long id, @RequestBody RestauranteDTO restauranteDTO) {
        return ResponseEntity.ok(restauranteService.actualizarRestaurante(id, restauranteDTO));
    }

    // Eliminar un restaurante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRestaurante(@PathVariable Long id) {
        restauranteService.eliminarRestaurante(id);
        return ResponseEntity.noContent().build();
    }
}