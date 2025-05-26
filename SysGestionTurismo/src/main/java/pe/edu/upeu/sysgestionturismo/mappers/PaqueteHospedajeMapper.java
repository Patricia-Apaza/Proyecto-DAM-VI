package pe.edu.upeu.sysgestionturismo.mappers;

import pe.edu.upeu.sysgestionturismo.dtos.PaqueteHospedajeDto;
import pe.edu.upeu.sysgestionturismo.modelo.Hospedaje;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteHospedaje;
import pe.edu.upeu.sysgestionturismo.modelo.PaqueteTuristico;

public class PaqueteHospedajeMapper {

    public static PaqueteHospedajeDto toDto(PaqueteHospedaje entity) {
        PaqueteHospedajeDto dto = new PaqueteHospedajeDto();
        dto.setIdPaqueteHospedaje(entity.getIdPaqueteHospedaje());
        dto.setIdPaqueteTuristico(entity.getPaqueteTuristico().getIdPaqueteTuristico());
        dto.setIdHospedaje(entity.getHospedaje().getIdHospedaje());
        return dto;
    }

    public static PaqueteHospedaje toEntity(PaqueteHospedajeDto dto) {
        PaqueteHospedaje entity = new PaqueteHospedaje();

        entity.setIdPaqueteHospedaje(dto.getIdPaqueteHospedaje());

        PaqueteTuristico paquete = new PaqueteTuristico();
        paquete.setIdPaqueteTuristico(dto.getIdPaqueteTuristico());
        entity.setPaqueteTuristico(paquete);

        Hospedaje hospedaje = new Hospedaje();
        hospedaje.setIdHospedaje(dto.getIdHospedaje());
        entity.setHospedaje(hospedaje);

        return entity;
    }
}
