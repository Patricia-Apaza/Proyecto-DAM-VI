package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.ReservaHospedaje;

import java.util.List;

public interface IReservaHospedajeService {
    ReservaHospedaje save(ReservaHospedaje entidad);
    ReservaHospedaje update(ReservaHospedaje entidad);
    void delete(Long id);
    ReservaHospedaje findById(Long id);
    List<ReservaHospedaje> findAll();
}
