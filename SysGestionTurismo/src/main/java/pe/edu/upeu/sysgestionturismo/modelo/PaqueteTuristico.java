package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "paquete_turistico")
@Data
public class PaqueteTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaqueteTuristico;

    private String nombre;
    private String descripcion;
    private int duracionDias;
    private String whatsappContacto;
    private Double precioTotal;
    private String imagenPath;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    private Destino destino;

    @ManyToOne
    @JoinColumn(name = "id_nivel_paquete")
    private NivelPaquete nivelPaquete;

    @OneToMany(mappedBy = "paqueteTuristico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaqueteActividad> paqueteActividades;

    @OneToMany(mappedBy = "paqueteTuristico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaqueteDestino> paqueteDestinos;

    @OneToMany(mappedBy = "paqueteTuristico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaqueteHospedaje> paqueteHospedajes;

    @OneToMany(mappedBy = "paqueteTuristico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaqueteRestaurante> paqueteRestaurantes;
}