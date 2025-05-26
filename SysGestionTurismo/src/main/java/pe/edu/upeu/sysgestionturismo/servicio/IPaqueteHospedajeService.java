package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.PaqueteHospedaje;

import java.util.List;

public interface IPaqueteHospedajeService {
    PaqueteHospedaje save(PaqueteHospedaje entity);
    PaqueteHospedaje update(PaqueteHospedaje entity);
    void delete(Long id);
    PaqueteHospedaje findById(Long id);
    List<PaqueteHospedaje> findAll();
}
