package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.ActividadDTO;

import java.util.List;
import java.util.Optional;

public interface IActividadService {


    List<ActividadDTO> obtenerTodasLasActividades();

    Optional<ActividadDTO> obtenerActividadPorId(Long id);

    ActividadDTO registrarActividad(ActividadDTO actividadDTO);

    ActividadDTO actualizarActividad(Long id, ActividadDTO actividadDTO);

    void eliminarActividad(Long id);


}