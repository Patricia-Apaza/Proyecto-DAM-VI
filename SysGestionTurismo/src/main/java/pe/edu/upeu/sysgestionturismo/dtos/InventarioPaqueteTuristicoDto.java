package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class InventarioPaqueteTuristicoDto {
    private Long idInventarioPaqueteTuristico;
    private Long idPaqueteTuristico;
    private LocalDate fechaSalida;
    private LocalDate fechaRetorno;
    private LocalTime horaSalida;
    private Integer capacidadPersonas;
    private Integer personasRegistradas;
    private BigDecimal precioPorPersona;
    private String descripcion;
    private String imagenPath;
}
