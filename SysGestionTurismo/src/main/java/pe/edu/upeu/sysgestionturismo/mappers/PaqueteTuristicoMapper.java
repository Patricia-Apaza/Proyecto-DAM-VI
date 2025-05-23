package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.PaqueteTuristicoDto;
import pe.edu.upeu.sysgestionturismo.modelo.Actividad;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;

import java.util.stream.Collectors;

public class PaqueteTuristicoMapper {

    public static PaqueteTuristicoDto toDto(PaqueteTuristico paquete) {
        PaqueteTuristicoDto dto = new PaqueteTuristicoDto();
        dto.setIdPaqueteTuristico(paquete.getIdPaqueteTuristico());
        dto.setIdDestino(paquete.getDestino() != null ? paquete.getDestino().getIdDestino() : null);
        dto.setNombre(paquete.getNombre());
        dto.setDescripcion(paquete.getDescripcion());
        dto.setDuracionDias(paquete.getDuracionDias());
        dto.setWhatsappContacto(paquete.getWhatsappContacto());
        dto.setPrecioTotal(paquete.getPrecioTotal());
        dto.setImagenPath(paquete.getImagenPath());
        return dto;
    }

    public static PaqueteTuristico toEntity(PaqueteTuristicoDto dto) {
        PaqueteTuristico paquete = new PaqueteTuristico();
        paquete.setIdPaqueteTuristico(dto.getIdPaqueteTuristico());

        if (dto.getIdDestino() != null) {
            Destino destino = new Destino();
            destino.setIdDestino(dto.getIdDestino());
            paquete.setDestino(destino);
        }

        paquete.setNombre(dto.getNombre());
        paquete.setDescripcion(dto.getDescripcion());
        paquete.setDuracionDias(dto.getDuracionDias());
        paquete.setWhatsappContacto(dto.getWhatsappContacto());
        paquete.setPrecioTotal(dto.getPrecioTotal());
        paquete.setImagenPath(dto.getImagenPath());

        return paquete;
    }
}
