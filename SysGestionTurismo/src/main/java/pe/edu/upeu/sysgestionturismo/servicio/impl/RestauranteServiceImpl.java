package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.RestauranteDTO;
import pe.edu.upeu.sysgestionturismo.mappers.RestauranteMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;
import pe.edu.upeu.sysgestionturismo.repositorio.IRestauranteRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IRestauranteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteServiceImpl implements IRestauranteService {

    @Autowired
    private IRestauranteRepository restauranteRepository;

    @Autowired
    private RestauranteMapper restauranteMapper;

    @Override
    public List<RestauranteDTO> listarRestaurantes() {
        // Obtiene todos los restaurantes desde el repositorio y los convierte a DTOs
        return restauranteRepository.findAll().stream()
                .map(restauranteMapper::toRestauranteDTO)  // Convierte los objetos Restaurante a RestauranteDTO
                .collect(Collectors.toList());
    }

    @Override
    public RestauranteDTO obtenerRestaurantePorId(Long id) {
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
        return restauranteMapper.toRestauranteDTO(restaurante);
    }

    @Override
    public RestauranteDTO registrarRestaurante(RestauranteDTO restauranteDTO) {
        Restaurante restaurante = restauranteMapper.toRestaurante(restauranteDTO);
        Restaurante restauranteGuardado = restauranteRepository.save(restaurante);
        return restauranteMapper.toRestauranteDTO(restauranteGuardado);
    }

    @Override
    public RestauranteDTO actualizarRestaurante(Long id, RestauranteDTO restauranteDTO) {
        Restaurante restauranteExistente = restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
        restauranteMapper.updateEntityFromDto(restauranteDTO, restauranteExistente);
        Restaurante restauranteActualizado = restauranteRepository.save(restauranteExistente);
        return restauranteMapper.toRestauranteDTO(restauranteActualizado);
    }

    @Override
    public void eliminarRestaurante(Long id) {
        restauranteRepository.deleteById(id);
    }
}