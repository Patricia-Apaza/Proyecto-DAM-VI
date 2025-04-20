package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.ReseñaDTO;

import java.util.List;

public interface IReseñaService {

    List<ReseñaDTO> listarReseñas();

    ReseñaDTO obtenerReseñaPorId(Long id);

    ReseñaDTO registrarReseña(ReseñaDTO reseñaDTO);

    ReseñaDTO actualizarReseña(Long id, ReseñaDTO reseñaDTO);

    void eliminarReseña(Long id);

    List<ReseñaDTO> obtenerTodasLasReseñas();

}