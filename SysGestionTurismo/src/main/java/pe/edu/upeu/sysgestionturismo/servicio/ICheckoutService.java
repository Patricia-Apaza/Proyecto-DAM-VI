package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.CheckoutDto;
import java.util.List;

public interface ICheckoutService {
    List<CheckoutDto> getAll();
    CheckoutDto getById(Long id);
    CheckoutDto create(CheckoutDto dto);
    CheckoutDto update(Long id, CheckoutDto dto);
    void delete(Long id);
}
