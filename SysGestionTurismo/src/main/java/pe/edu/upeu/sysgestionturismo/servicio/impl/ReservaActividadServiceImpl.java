package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaActividad;
import pe.edu.upeu.sysgestionturismo.repositorio.ReservaActividadRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaActividadService;

import java.util.List;

@Service
public class ReservaActividadServiceImpl implements IReservaActividadService {

    @Autowired
    private ReservaActividadRepository reservaActividadRepository;

    @Override
    public ReservaActividad save(ReservaActividad entidad) {
        return reservaActividadRepository.save(entidad);
    }

    @Override
    public ReservaActividad update(ReservaActividad entidad) {
        return reservaActividadRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        reservaActividadRepository.deleteById(id);
    }

    @Override
    public ReservaActividad findById(Long id) {
        return reservaActividadRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservaActividad> findAll() {
        return reservaActividadRepository.findAll();
    }
}
