package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ReservaMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservaMenu;

    @ManyToOne
    @JoinColumn(name = "id_reserva_restaurante")
    private ReservaRestaurante reservaRestaurante;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private MenuDiario menuDiario;   // Cambiado aquí

    private Boolean disponible = true;
    private Integer cantidad = 1;
    private String observaciones;
}
