package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.NivelPaquete;
import java.util.List;

public interface INivelPaqueteService {
    NivelPaquete save(NivelPaquete nivel);
    NivelPaquete update(NivelPaquete nivel);
    void delete(Long id);
    NivelPaquete findById(Long id);
    List<NivelPaquete> findAll();
}
