package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.Restaurante;
import pe.edu.upeu.sysgestionturismo.repositorio.RestauranteRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IRestauranteService;

import java.util.List;

@Service
public class RestauranteServiceImpl implements IRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public Restaurante save(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante update(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public void delete(Long id) {
        restauranteRepository.deleteById(id);
    }

    @Override
    public Restaurante findById(Long id) {
        return restauranteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }
}
