package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class MenuDiarioDto {
    private Long idMenu;
    private Long idRestaurante;
    private LocalDate fecha;
    private String nombrePlato;
    private String descripcion;
    private BigDecimal precio;
    private String imagenPath;
}
