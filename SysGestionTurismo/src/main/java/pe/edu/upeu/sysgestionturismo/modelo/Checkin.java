package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Checkin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCheckin;

    private String tipoReserva;
    private Timestamp fechaCheckin;
    private Boolean estadoCheckin = true;
    private String registradoPor;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;
}
