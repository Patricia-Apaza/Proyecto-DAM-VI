package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.HospedajeDTO;

import java.util.List;

public interface IHospedajeService {

    List<HospedajeDTO> listarHospedajes();

    HospedajeDTO obtenerHospedajePorId(Long id);

    HospedajeDTO registrarHospedaje(HospedajeDTO hospedajeDTO);

    HospedajeDTO actualizarHospedaje(Long id, HospedajeDTO hospedajeDTO);

    void eliminarHospedaje(Long id);
}