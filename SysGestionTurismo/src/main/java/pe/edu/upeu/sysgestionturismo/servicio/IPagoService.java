package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.CrearPagoDto;
import pe.edu.upeu.sysgestionturismo.dtos.PagoDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPagoService {
    PagoDto crearPago(CrearPagoDto request);
    PagoDto subirComprobante(Long idPago, MultipartFile file) throws IOException;
    PagoDto confirmarPago(Long idPago);
}
