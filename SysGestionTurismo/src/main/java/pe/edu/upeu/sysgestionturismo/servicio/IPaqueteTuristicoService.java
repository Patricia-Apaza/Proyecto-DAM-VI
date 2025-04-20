package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDTO;

import java.util.List;

public interface IPaqueteTuristicoService {

    List<PaqueteTuristicoDTO> listarPaquetes();

    PaqueteTuristicoDTO obtenerPaquetePorId(Long id);

    PaqueteTuristicoDTO registrarPaqueteTuristico(PaqueteTuristicoDTO paqueteTuristicoDTO);

    PaqueteTuristicoDTO actualizarPaqueteTuristico(Long id, PaqueteTuristicoDTO paqueteTuristicoDTO);


    void eliminarPaqueteTuristico(Long id);
}