package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.ReservaActividad;
import java.util.List;

public interface IReservaActividadService {
    ReservaActividad save(ReservaActividad entidad);
    ReservaActividad update(ReservaActividad entidad);
    void delete(Long id);
    ReservaActividad findById(Long id);
    List<ReservaActividad> findAll();
}
