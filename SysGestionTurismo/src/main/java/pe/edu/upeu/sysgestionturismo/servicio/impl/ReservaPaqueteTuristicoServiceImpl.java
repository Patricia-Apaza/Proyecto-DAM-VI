package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.modelo.ReservaPaqueteTuristico;
import pe.edu.upeu.sysgestionturismo.repositorio.ReservaPaqueteTuristicoRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IReservaPaqueteTuristicoService;

import java.util.List;

@Service
public class ReservaPaqueteTuristicoServiceImpl implements IReservaPaqueteTuristicoService {

    @Autowired
    private ReservaPaqueteTuristicoRepository repository;

    @Override
    public ReservaPaqueteTuristico save(ReservaPaqueteTuristico entidad) {
        return repository.save(entidad);
    }

    @Override
    public ReservaPaqueteTuristico update(ReservaPaqueteTuristico entidad) {
        return repository.save(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ReservaPaqueteTuristico findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<ReservaPaqueteTuristico> findAll() {
        return repository.findAll();
    }
}
