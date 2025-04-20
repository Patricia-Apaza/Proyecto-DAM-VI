package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.HospedajeDTO;
import pe.edu.upeu.sysgestionturismo.mappers.HospedajeMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Hospedaje;
import pe.edu.upeu.sysgestionturismo.repositorio.IHospedajeRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IHospedajeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HospedajeServiceImpl implements IHospedajeService {

    @Autowired
    private IHospedajeRepository hospedajeRepository;

    @Autowired
    private HospedajeMapper hospedajeMapper;

    @Override
    public List<HospedajeDTO> listarHospedajes() {  // Nombre corregido para coincidir con la interfaz
        List<Hospedaje> hospedajes = hospedajeRepository.findAll();
        return hospedajes.stream()
                .map(hospedajeMapper::toHospedajeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HospedajeDTO obtenerHospedajePorId(Long id) {
        Hospedaje hospedaje = hospedajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospedaje no encontrado"));
        return hospedajeMapper.toHospedajeDTO(hospedaje);
    }

    @Override
    public HospedajeDTO registrarHospedaje(HospedajeDTO hospedajeDTO) {
        Hospedaje hospedaje = hospedajeMapper.toHospedaje(hospedajeDTO);
        Hospedaje hospedajeGuardado = hospedajeRepository.save(hospedaje);
        return hospedajeMapper.toHospedajeDTO(hospedajeGuardado);
    }

    @Override
    public HospedajeDTO actualizarHospedaje(Long id, HospedajeDTO hospedajeDTO) {
        Hospedaje hospedajeExistente = hospedajeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospedaje no encontrado"));
        hospedajeMapper.updateEntityFromDto(hospedajeDTO, hospedajeExistente);
        Hospedaje hospedajeActualizado = hospedajeRepository.save(hospedajeExistente);
        return hospedajeMapper.toHospedajeDTO(hospedajeActualizado);
    }

    @Override
    public void eliminarHospedaje(Long id) {
        hospedajeRepository.deleteById(id);
    }
}