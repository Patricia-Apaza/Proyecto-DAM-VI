package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.CarritoItemDto;

import java.util.List;

public interface ICarritoItemService {
    List<CarritoItemDto> listarPorCarrito(Long idCarrito);
    void eliminarItem(Long idCarritoItem);
}
