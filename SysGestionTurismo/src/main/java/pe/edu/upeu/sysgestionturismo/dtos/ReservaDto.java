package pe.edu.upeu.sysgestionturismo.dtos;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservaDto {
    private Long id_reserva;
    private Long id_cliente;
    private String tipo_reserva;
    private Long id_paquete;
    private String estado_reserva;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Integer numero_personas;
    private Double total_pago;
    private String observaciones;
}