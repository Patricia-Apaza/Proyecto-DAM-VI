package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysgestionturismo.dtos.InventarioDTO;
import pe.edu.upeu.sysgestionturismo.mappers.InventarioMapper;
import pe.edu.upeu.sysgestionturismo.modelo.Inventario;
import pe.edu.upeu.sysgestionturismo.repositorio.IInventarioRepository;
import pe.edu.upeu.sysgestionturismo.servicio.IInventarioService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventarioServiceImpl implements IInventarioService {

    @Autowired
    private IInventarioRepository inventarioRepository;

    @Autowired
    private InventarioMapper inventarioMapper;

    @Override
    public List<InventarioDTO> obtenerInventarioCompleto() {  // Cambiar el nombre del método
        List<Inventario> inventarios = inventarioRepository.findAll();
        return inventarios.stream()
                .map(inventarioMapper::toInventarioDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InventarioDTO obtenerInventarioPorId(Long id) {
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        return inventarioMapper.toInventarioDTO(inventario);
    }

    @Override
    public InventarioDTO registrarInventario(InventarioDTO inventarioDTO) {
        Inventario inventario = inventarioMapper.toInventario(inventarioDTO);
        Inventario inventarioGuardado = inventarioRepository.save(inventario);
        return inventarioMapper.toInventarioDTO(inventarioGuardado);
    }

    @Override
    public InventarioDTO actualizarInventario(Long id, InventarioDTO inventarioDTO) {
        Inventario inventarioExistente = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        inventarioMapper.updateEntityFromDto(inventarioDTO, inventarioExistente);
        Inventario inventarioActualizado = inventarioRepository.save(inventarioExistente);
        return inventarioMapper.toInventarioDTO(inventarioActualizado);
    }

    @Override
    public void eliminarInventario(Long id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    public List<InventarioDTO> listarInventarios() {
        List<Inventario> inventarios = inventarioRepository.findAll();
        return inventarios.stream()
                .map(inventarioMapper::toInventarioDTO)
                .collect(Collectors.toList());
    }
}