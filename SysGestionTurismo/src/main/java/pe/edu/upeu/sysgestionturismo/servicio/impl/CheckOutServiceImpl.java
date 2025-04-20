package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.CheckOutDTO;
import pe.edu.upeu.sysgestionturismo.mappers.CheckOutMapper;
import pe.edu.upeu.sysgestionturismo.modelo.CheckOut;
import pe.edu.upeu.sysgestionturismo.repositorio.ICheckOutRepository;
import pe.edu.upeu.sysgestionturismo.servicio.ICheckOutService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckOutServiceImpl implements ICheckOutService {

    @Autowired
    private ICheckOutRepository checkOutRepository;

    @Autowired
    private CheckOutMapper checkOutMapper;

    @Override
    public List<CheckOutDTO> obtenerTodosLosCheckOuts() {
        List<CheckOut> checkOuts = checkOutRepository.findAll();
        return checkOuts.stream()
                .map(checkOutMapper::toCheckOutDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CheckOutDTO obtenerCheckOutPorId(Long id) {
        CheckOut checkOut = checkOutRepository.findById(id).orElseThrow(() -> new RuntimeException("CheckOut no encontrado"));
        return checkOutMapper.toCheckOutDTO(checkOut);
    }

    @Override
    public CheckOutDTO registrarCheckOut(CheckOutDTO checkOutDTO) {
        CheckOut checkOut = checkOutMapper.toCheckOut(checkOutDTO);
        CheckOut checkOutGuardado = checkOutRepository.save(checkOut);
        return checkOutMapper.toCheckOutDTO(checkOutGuardado);
    }

    @Override
    public CheckOutDTO actualizarCheckOut(Long id, CheckOutDTO checkOutDTO) {
        CheckOut checkOutExistente = checkOutRepository.findById(id).orElseThrow(() -> new RuntimeException("CheckOut no encontrado"));
        checkOutMapper.updateEntityFromDto(checkOutDTO, checkOutExistente);
        CheckOut checkOutActualizado = checkOutRepository.save(checkOutExistente);
        return checkOutMapper.toCheckOutDTO(checkOutActualizado);
    }

    @Override
    public void eliminarCheckOut(Long id) {
        checkOutRepository.deleteById(id);
    }

    @Override
    public String realizarCheckOut(Long clienteId) {
        return "Check-out realizado con éxito para el cliente con ID: " + clienteId;
    }
}