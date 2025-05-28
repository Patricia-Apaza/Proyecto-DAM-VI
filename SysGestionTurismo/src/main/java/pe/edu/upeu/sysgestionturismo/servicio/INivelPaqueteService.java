package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.NivelPaquete;

import java.util.List;

public interface INivelPaqueteService {
    NivelPaquete save(NivelPaquete nivelPaquete);
    NivelPaquete update(NivelPaquete nivelPaquete);
    void delete(Long id);
    NivelPaquete findById(Long id);
    List<NivelPaquete> findAll();
}
