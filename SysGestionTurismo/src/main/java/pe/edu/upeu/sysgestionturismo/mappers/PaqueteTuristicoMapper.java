package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.modelo.*;

import java.util.stream.Collectors;

public class PaqueteTuristicoMapper {

    public static PaqueteTuristicoDto toDto(PaqueteTuristico paquete) {
        PaqueteTuristicoDto dto = new PaqueteTuristicoDto();
        dto.setIdPaqueteTuristico(paquete.getIdPaqueteTuristico());
        dto.setIdDestino(paquete.getDestino() != null ? paquete.getDestino().getIdDestino() : null);
        dto.setIdNivelPaquete(paquete.getNivelPaquete() != null ? paquete.getNivelPaquete().getIdNivelPaquete() : null);
        dto.setNombre(paquete.getNombre());
        dto.setDescripcion(paquete.getDescripcion());
        dto.setDuracionDias(paquete.getDuracionDias());
        dto.setWhatsappContacto(paquete.getWhatsappContacto());
        dto.setPrecioTotal(paquete.getPrecioTotal());
        dto.setImagenPath(paquete.getImagenPath());

        // Información adicional para mostrar
        dto.setNombreNivelPaquete(paquete.getNivelPaquete() != null ? paquete.getNivelPaquete().getNombreNivel() : null);
        dto.setNombreDestino(paquete.getDestino() != null ? paquete.getDestino().getNombre() : null);

        // Mapear listas de IDs
        if (paquete.getPaqueteActividades() != null) {
            dto.setActividadesIds(paquete.getPaqueteActividades().stream()
                    .map(pa -> pa.getActividad().getIdActividad())
                    .collect(Collectors.toList()));
            dto.setNombresActividades(paquete.getPaqueteActividades().stream()
                    .map(pa -> pa.getActividad().getNombre())
                    .collect(Collectors.toList()));
        }

        if (paquete.getPaqueteDestinos() != null) {
            dto.setDestinosIds(paquete.getPaqueteDestinos().stream()
                    .map(pd -> pd.getDestino().getIdDestino())
                    .collect(Collectors.toList()));
            dto.setNombresDestinos(paquete.getPaqueteDestinos().stream()
                    .map(pd -> pd.getDestino().getNombre())
                    .collect(Collectors.toList()));
        }

        if (paquete.getPaqueteHospedajes() != null) {
            dto.setHospedajesIds(paquete.getPaqueteHospedajes().stream()
                    .map(ph -> ph.getHospedaje().getIdHospedaje())
                    .collect(Collectors.toList()));
            dto.setNombresHospedajes(paquete.getPaqueteHospedajes().stream()
                    .map(ph -> ph.getHospedaje().getNombre())
                    .collect(Collectors.toList()));
        }

        if (paquete.getPaqueteRestaurantes() != null) {
            dto.setRestaurantesIds(paquete.getPaqueteRestaurantes().stream()
                    .map(pr -> pr.getRestaurante().getIdRestaurante())
                    .collect(Collectors.toList()));
            dto.setNombresRestaurantes(paquete.getPaqueteRestaurantes().stream()
                    .map(pr -> pr.getRestaurante().getNombre())
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static PaqueteTuristico toEntity(PaqueteTuristicoDto dto) {
        PaqueteTuristico paquete = new PaqueteTuristico();
        paquete.setIdPaqueteTuristico(dto.getIdPaqueteTuristico());
        paquete.setNombre(dto.getNombre());
        paquete.setDescripcion(dto.getDescripcion());
        paquete.setDuracionDias(dto.getDuracionDias());
        paquete.setWhatsappContacto(dto.getWhatsappContacto());
        paquete.setPrecioTotal(dto.getPrecioTotal());
        paquete.setImagenPath(dto.getImagenPath());

        // Setear destino principal si existe
        if (dto.getIdDestino() != null) {
            Destino destino = new Destino();
            destino.setIdDestino(dto.getIdDestino());
            paquete.setDestino(destino);
        }

        // Setear nivel de paquete si existe
        if (dto.getIdNivelPaquete() != null) {
            NivelPaquete nivel = new NivelPaquete();
            nivel.setIdNivelPaquete(dto.getIdNivelPaquete());
            paquete.setNivelPaquete(nivel);
        }

        return paquete;
    }
}
