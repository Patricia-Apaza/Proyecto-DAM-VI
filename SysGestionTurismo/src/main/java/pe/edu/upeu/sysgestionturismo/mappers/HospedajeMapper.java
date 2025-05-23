package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.HospedajeDto;
import pe.edu.upeu.sysgestionturismo.modelo.Destino;
import pe.edu.upeu.sysgestionturismo.modelo.Hospedaje;

public class HospedajeMapper {

    public static HospedajeDto toDto(Hospedaje hospedaje) {
        HospedajeDto dto = new HospedajeDto();
        dto.setIdHospedaje(hospedaje.getIdHospedaje());
        dto.setNombre(hospedaje.getNombre());
        dto.setDescripcion(hospedaje.getDescripcion());
        dto.setDireccion(hospedaje.getDireccion());
        dto.setWhatsappContacto(hospedaje.getWhatsappContacto());
        dto.setPrecioPorNoche(hospedaje.getPrecioPorNoche());
        dto.setImagenPath(hospedaje.getImagenPath());
        dto.setIdDestino(hospedaje.getDestino() != null ? hospedaje.getDestino().getIdDestino() : null);
        return dto;
    }

    public static Hospedaje toEntity(HospedajeDto dto) {
        Hospedaje hospedaje = new Hospedaje();
        hospedaje.setIdHospedaje(dto.getIdHospedaje());
        hospedaje.setNombre(dto.getNombre());
        hospedaje.setDescripcion(dto.getDescripcion());
        hospedaje.setDireccion(dto.getDireccion());
        hospedaje.setWhatsappContacto(dto.getWhatsappContacto());
        hospedaje.setPrecioPorNoche(dto.getPrecioPorNoche());
        hospedaje.setImagenPath(dto.getImagenPath());

        if (dto.getIdDestino() != null) {
            Destino destino = new Destino();
            destino.setIdDestino(dto.getIdDestino());
            hospedaje.setDestino(destino);
        }

        return hospedaje;
    }
}
