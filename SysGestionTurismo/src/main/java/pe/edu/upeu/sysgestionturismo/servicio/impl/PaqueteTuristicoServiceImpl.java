package pe.edu.upeu.sysgestionturismo.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.mappers.PaqueteTuristicoMapper;
import pe.edu.upeu.sysgestionturismo.modelo.*;
import pe.edu.upeu.sysgestionturismo.repositorio.*;
import pe.edu.upeu.sysgestionturismo.servicio.IPaqueteTuristicoService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaqueteTuristicoServiceImpl implements IPaqueteTuristicoService {

    @Autowired
    private PaqueteTuristicoRepository paqueteTuristicoRepository;

    @Autowired
    private PaqueteActividadRepository paqueteActividadRepository;

    @Autowired
    private PaqueteDestinoRepository paqueteDestinoRepository;

    @Autowired
    private PaqueteHospedajeRepository paqueteHospedajeRepository;

    @Autowired
    private PaqueteRestauranteRepository paqueteRestauranteRepository;

    @Override
    public PaqueteTuristico save(PaqueteTuristico paquete) {
        return paqueteTuristicoRepository.save(paquete);
    }

    @Override
    public PaqueteTuristico update(PaqueteTuristico paquete) {
        return paqueteTuristicoRepository.save(paquete);
    }

    @Override
    public void delete(Long id) {
        // Eliminar relaciones primero
        paqueteActividadRepository.deleteByPaqueteTuristicoIdPaqueteTuristico(id);
        paqueteDestinoRepository.deleteByPaqueteTuristicoIdPaqueteTuristico(id);
        paqueteHospedajeRepository.deleteByPaqueteTuristicoIdPaqueteTuristico(id);
        paqueteRestauranteRepository.deleteByPaqueteTuristicoIdPaqueteTuristico(id);

        // Eliminar el paquete
        paqueteTuristicoRepository.deleteById(id);
    }

    @Override
    public PaqueteTuristico findById(Long id) {
        return paqueteTuristicoRepository.findById(id).orElse(null);
    }

    @Override
    public List<PaqueteTuristico> findAll() {
        return paqueteTuristicoRepository.findAll();
    }

    @Override
    @Transactional
    public PaqueteTuristico saveWithRelations(PaqueteTuristicoDto dto) {
        // Guardar el paquete principal
        PaqueteTuristico paquete = PaqueteTuristicoMapper.toEntity(dto);
        paquete = paqueteTuristicoRepository.save(paquete);

        // Guardar relaciones
        saveRelations(paquete, dto);

        return paquete;
    }

    @Override
    @Transactional
    public PaqueteTuristico updateWithRelations(PaqueteTuristicoDto dto) {
        // Actualizar el paquete principal
        PaqueteTuristico paquete = PaqueteTuristicoMapper.toEntity(dto);
        paquete = paqueteTuristicoRepository.save(paquete);

        // Eliminar relaciones existentes
        Long idPaquete = paquete.getIdPaqueteTuristico();
        paqueteActividadRepository.deleteByPaqueteTuristicoIdPaqueteTuristico(idPaquete);
        paqueteDestinoRepository.deleteByPaqueteTuristicoIdPaqueteTuristico(idPaquete);
        paqueteHospedajeRepository.deleteByPaqueteTuristicoIdPaqueteTuristico(idPaquete);
        paqueteRestauranteRepository.deleteByPaqueteTuristicoIdPaqueteTuristico(idPaquete);

        // Guardar nuevas relaciones
        saveRelations(paquete, dto);

        return paquete;
    }

    private void saveRelations(PaqueteTuristico paquete, PaqueteTuristicoDto dto) {
        // Guardar actividades
        if (dto.getActividadesIds() != null) {
            for (Long actividadId : dto.getActividadesIds()) {
                PaqueteActividad pa = new PaqueteActividad();
                pa.setPaqueteTuristico(paquete);
                Actividad actividad = new Actividad();
                actividad.setIdActividad(actividadId);
                pa.setActividad(actividad);
                paqueteActividadRepository.save(pa);
            }
        }

        // Guardar destinos adicionales
        if (dto.getDestinosIds() != null) {
            for (Long destinoId : dto.getDestinosIds()) {
                PaqueteDestino pd = new PaqueteDestino();
                pd.setPaqueteTuristico(paquete);
                Destino destino = new Destino();
                destino.setIdDestino(destinoId);
                pd.setDestino(destino);
                paqueteDestinoRepository.save(pd);
            }
        }

        // Guardar hospedajes
        if (dto.getHospedajesIds() != null) {
            for (Long hospedajeId : dto.getHospedajesIds()) {
                PaqueteHospedaje ph = new PaqueteHospedaje();
                ph.setPaqueteTuristico(paquete);
                Hospedaje hospedaje = new Hospedaje();
                hospedaje.setIdHospedaje(hospedajeId);
                ph.setHospedaje(hospedaje);
                paqueteHospedajeRepository.save(ph);
            }
        }

        // Guardar restaurantes
        if (dto.getRestaurantesIds() != null) {
            for (Long restauranteId : dto.getRestaurantesIds()) {
                PaqueteRestaurante pr = new PaqueteRestaurante();
                pr.setPaqueteTuristico(paquete);
                Restaurante restaurante = new Restaurante();
                restaurante.setIdRestaurante(restauranteId);
                pr.setRestaurante(restaurante);
                paqueteRestauranteRepository.save(pr);
            }
        }
    }

    @Override
    public PaqueteTuristicoDto findByIdWithRelations(Long id) {
        PaqueteTuristico paquete = paqueteTuristicoRepository.findById(id).orElse(null);
        return paquete != null ? PaqueteTuristicoMapper.toDto(paquete) : null;
    }

    @Override
    public List<PaqueteTuristicoDto> findAllWithRelations() {
        return paqueteTuristicoRepository.findAll().stream()
                .map(PaqueteTuristicoMapper::toDto)
                .collect(Collectors.toList());
    }
}
