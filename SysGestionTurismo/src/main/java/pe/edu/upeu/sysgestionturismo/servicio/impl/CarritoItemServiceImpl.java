package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoItemDto;
import pe.edu.upeu.sysgestionturismo.mappers.CarritoItemMapper;
import pe.edu.upeu.sysgestionturismo.modelo.CarritoItem;
import pe.edu.upeu.sysgestionturismo.repositorio.CarritoItemRepository;
import pe.edu.upeu.sysgestionturismo.servicio.ICarritoItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarritoItemServiceImpl implements ICarritoItemService {

    @Autowired
    private CarritoItemRepository carritoItemRepository;

    @Override
    public List<CarritoItemDto> listarPorCarrito(Long idCarrito) {
        List<CarritoItem> items = carritoItemRepository.findAll().stream()
                .filter(item -> item.getCarrito().getIdCarrito().equals(idCarrito))
                .collect(Collectors.toList());
        return items.stream().map(CarritoItemMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void eliminarItem(Long idCarritoItem) {
        carritoItemRepository.deleteById(idCarritoItem);
    }
}
