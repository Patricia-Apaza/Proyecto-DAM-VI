package pe.edu.upeu.sysgestionturismo.servicio;

import pe.edu.upeu.sysgestionturismo.dtos.CheckinDto;

import java.util.List;

public interface ICheckinService {
    List<CheckinDto> getAll();
    CheckinDto getById(Long id);
    CheckinDto create(CheckinDto dto);
    CheckinDto update(Long id, CheckinDto dto);
    void delete(Long id);
}
