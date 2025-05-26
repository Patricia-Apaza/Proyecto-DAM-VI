package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.modelo.ReservaRestaurante;

import java.util.List;

public interface IReservaRestauranteService {

    ReservaRestaurante save(ReservaRestaurante entidad);
    ReservaRestaurante update(ReservaRestaurante entidad);
    void delete(Long id);
    ReservaRestaurante findById(Long id);
    List<ReservaRestaurante> findAll();

}
