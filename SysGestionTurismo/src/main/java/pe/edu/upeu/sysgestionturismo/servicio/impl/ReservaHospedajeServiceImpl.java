package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaHospedaje;
import pe.edu.upeu.sysgestionturismo.repositorio.ReservaHospedajeRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaHospedajeService;

import java.util.List;

@Service
public class ReservaHospedajeServiceImpl implements IReservaHospedajeService {

    @Autowired
    private ReservaHospedajeRepository reservaHospedajeRepository;

    @Override
    public ReservaHospedaje save(ReservaHospedaje entidad) {
        return reservaHospedajeRepository.save(entidad);
    }

    @Override
    public ReservaHospedaje update(ReservaHospedaje entidad) {
        return reservaHospedajeRepository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        reservaHospedajeRepository.deleteById(id);
    }

    @Override
    public ReservaHospedaje findById(Long id) {
        return reservaHospedajeRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservaHospedaje> findAll() {
        return reservaHospedajeRepository.findAll();
    }
}
