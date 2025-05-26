package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

@Data
public class ReservaMenuDto {
    private Long idReservaMenu;
    private Long idReservaRestaurante;
    private Long idMenu;
    private Boolean disponible = true;
    private Integer cantidad = 1;
    private String observaciones;
}
