package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.CheckOutDTO;
import java.util.List;

public interface ICheckOutService {

    List<CheckOutDTO> obtenerTodosLosCheckOuts();

    CheckOutDTO obtenerCheckOutPorId(Long id);

    CheckOutDTO registrarCheckOut(CheckOutDTO checkOutDTO);

    CheckOutDTO actualizarCheckOut(Long id, CheckOutDTO checkOutDTO);

    void eliminarCheckOut(Long id);

    String realizarCheckOut(Long clienteId);


}