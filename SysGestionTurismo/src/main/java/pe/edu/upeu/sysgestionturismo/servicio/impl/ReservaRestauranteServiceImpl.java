package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaRestaurante;
import pe.edu.upeu.sysgestionturismo.repositorio.ReservaRestauranteRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaRestauranteService;

import java.util.List;

@Service
public class ReservaRestauranteServiceImpl implements IReservaRestauranteService {

    @Autowired
    private ReservaRestauranteRepository reservaRestauranteRepository;

    @Override
    public ReservaRestaurante save(ReservaRestaurante entidad) {
        return reservaRestauranteRepository.save(entidad);
    }

    @Override
    public ReservaRestaurante update(ReservaRestaurante entidad) {
        return reservaRestauranteRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        reservaRestauranteRepository.deleteById(id);
    }

    @Override
    public ReservaRestaurante findById(Long id) {
        return reservaRestauranteRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservaRestaurante> findAll() {
        return reservaRestauranteRepository.findAll();
    }
}
