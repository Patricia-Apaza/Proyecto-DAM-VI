package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.PagoDTO;

import java.util.List;

public interface IPagoService {

    List<PagoDTO> obtenerTodosLosPagos();

    PagoDTO obtenerPagoPorId(Long id);

    PagoDTO registrarPago(PagoDTO pagoDTO);

    PagoDTO actualizarPago(Long id, PagoDTO pagoDTO);

    void eliminarPago(Long id);

    String procesarPago(PagoDTO pagoDTO);
}