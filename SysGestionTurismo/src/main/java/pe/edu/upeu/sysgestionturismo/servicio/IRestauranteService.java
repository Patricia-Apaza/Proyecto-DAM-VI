package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.RestauranteDTO;

import java.util.List;

public interface IRestauranteService {

    List<RestauranteDTO> listarRestaurantes();

    RestauranteDTO obtenerRestaurantePorId(Long id);

    RestauranteDTO registrarRestaurante(RestauranteDTO restauranteDTO);

    RestauranteDTO actualizarRestaurante(Long id, RestauranteDTO restauranteDTO);

    void eliminarRestaurante(Long id);

}