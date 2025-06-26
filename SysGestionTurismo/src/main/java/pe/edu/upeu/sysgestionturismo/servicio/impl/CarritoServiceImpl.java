package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.AgregarCarritoDto;
import pe.edu.upeu.sysgestionturismo.dtos.CarritoDto;
import pe.edu.upeu.sysgestionturismo.mappers.CarritoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.*;
import pe.edu.upeu.sysgestionturismo.repositorio.*;
import pe.edu.upeu.sysgestionturismo.servicio.ICarritoService;

import java.util.Collections;
import java.util.ArrayList;

@Service
public class CarritoServiceImpl implements ICarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CarritoItemRepository carritoItemRepository;

    @Override
    public CarritoDto agregarAlCarrito(AgregarCarritoDto dto) {
        Cliente cliente = clienteRepository.findById(dto.getIdCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Carrito carrito = carritoRepository.findByClienteAndEstado(cliente, Carrito.EstadoCarrito.ACTIVO)
                .orElseGet(() -> {
                    Carrito nuevo = new Carrito();
                    nuevo.setCliente(cliente);
                    nuevo.setEstado(Carrito.EstadoCarrito.ACTIVO);

                    System.out.println("Estado antes de guardar: " + nuevo.getEstado());

                    nuevo.setItems(new ArrayList<>());
                    return carritoRepository.save(nuevo);
                });

        CarritoItem.TipoItem tipoItemEnum = CarritoItem.TipoItem.valueOf(dto.getTipoItem().toUpperCase());

        CarritoItem item = carritoItemRepository
                .findByCarritoAndTipoItemAndIdReferencia(carrito, tipoItemEnum, dto.getIdReferencia())
                .orElseGet(() -> {
                    CarritoItem nuevoItem = new CarritoItem();
                    nuevoItem.setCarrito(carrito);
                    nuevoItem.setTipoItem(tipoItemEnum);
                    nuevoItem.setIdReferencia(dto.getIdReferencia());
                    nuevoItem.setCantidad(0);
                    return nuevoItem;
                });

        item.setCantidad(item.getCantidad() + (dto.getCantidad() != null ? dto.getCantidad() : 1));
        item.setObservaciones(dto.getObservaciones());

        carritoItemRepository.save(item);
        carrito.getItems().add(item);

        // Refrescar el carrito con los ítems actualizados
        Carrito carritoActualizado = carritoRepository.findById(carrito.getIdCarrito())
                .orElseThrow(() -> new RuntimeException("Error al actualizar carrito"));

        Carrito carritoConItems = carritoRepository.findConItemsById(carrito.getIdCarrito())
                .orElseThrow(() -> new RuntimeException("Error al recuperar carrito con ítems"));

        return CarritoMapper.toDto(carritoConItems);

    }
}
