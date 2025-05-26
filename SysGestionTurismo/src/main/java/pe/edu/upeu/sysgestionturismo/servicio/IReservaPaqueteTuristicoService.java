package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.ReservaPaqueteTuristico;
import java.util.List;

public interface IReservaPaqueteTuristicoService {
    ReservaPaqueteTuristico save(ReservaPaqueteTuristico entidad);
    ReservaPaqueteTuristico update(ReservaPaqueteTuristico entidad);
    void delete(Long id);
    ReservaPaqueteTuristico findById(Long id);
    List<ReservaPaqueteTuristico> findAll();
}
