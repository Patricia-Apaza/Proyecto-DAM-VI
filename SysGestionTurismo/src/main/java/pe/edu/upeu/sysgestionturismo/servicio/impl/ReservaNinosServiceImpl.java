package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaNinos;
import pe.edu.upeu.sysgestionturismo.repositorio.ReservaNinosRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaNinosService;

import java.util.List;

@Service
public class ReservaNinosServiceImpl implements IReservaNinosService {

    @Autowired
    private ReservaNinosRepository reservaNinosRepository;

    @Override
    public ReservaNinos save(ReservaNinos entidad) {
        return reservaNinosRepository.save(entidad);
    }

    @Override
    public ReservaNinos update(ReservaNinos entidad) {
        return reservaNinosRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        reservaNinosRepository.deleteById(id);
    }

    @Override
    public ReservaNinos findById(Long id) {
        return reservaNinosRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservaNinos> findAll() {
        return reservaNinosRepository.findAll();
    }
}
