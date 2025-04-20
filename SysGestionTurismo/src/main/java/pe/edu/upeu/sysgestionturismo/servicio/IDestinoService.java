package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.DestinoDTO;
import java.util.List;

public interface IDestinoService {

    DestinoDTO obtenerDestinoPorId(Long id);

    DestinoDTO registrarDestino(DestinoDTO destinoDTO);

    DestinoDTO actualizarDestino(Long id, DestinoDTO destinoDTO);

    void eliminarDestino(Long id);

    List<DestinoDTO> listarDestinos();
}