package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.InventarioDTO;

import java.util.List;

public interface IInventarioService {

    List<InventarioDTO> obtenerInventarioCompleto();

    InventarioDTO obtenerInventarioPorId(Long id);

    InventarioDTO registrarInventario(InventarioDTO inventarioDTO);

    InventarioDTO actualizarInventario(Long id, InventarioDTO inventarioDTO);

    void eliminarInventario(Long id);

    List<InventarioDTO> listarInventarios();
}