package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.AgregarCarritoDto;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoDto;

public interface ICarritoService {
    CarritoDto agregarAlCarrito(AgregarCarritoDto dto);
}
