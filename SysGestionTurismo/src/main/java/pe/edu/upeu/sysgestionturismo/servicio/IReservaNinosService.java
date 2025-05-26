package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.ReservaNinos;
import java.util.List;

public interface IReservaNinosService {
    ReservaNinos save(ReservaNinos entidad);
    ReservaNinos update(ReservaNinos entidad);
    void delete(Long id);
    ReservaNinos findById(Long id);
    List<ReservaNinos> findAll();
}
