package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.PaqueteActividad;

import java.util.List;

public interface IPaqueteActividadService {
    PaqueteActividad save(PaqueteActividad entity);
    PaqueteActividad update(PaqueteActividad entity);
    void delete(Long id);
    PaqueteActividad findById(Long id);
    List<PaqueteActividad> findAll();
}
