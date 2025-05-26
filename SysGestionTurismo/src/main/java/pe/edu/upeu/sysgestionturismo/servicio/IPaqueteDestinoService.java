package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.PaqueteDestino;

import java.util.List;

public interface IPaqueteDestinoService {
    PaqueteDestino save(PaqueteDestino entity);
    PaqueteDestino update(PaqueteDestino entity);
    void delete(Long id);
    PaqueteDestino findById(Long id);
    List<PaqueteDestino> findAll();
}
