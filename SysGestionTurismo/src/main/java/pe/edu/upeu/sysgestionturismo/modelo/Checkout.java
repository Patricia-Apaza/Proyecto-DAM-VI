package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCheckout;

    private String tipoReserva;
    private Timestamp fechaCheckout;
    private Boolean estadoCheckout = true;
    private String registradoPor;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_checkin")
    private Checkin checkin;
}
