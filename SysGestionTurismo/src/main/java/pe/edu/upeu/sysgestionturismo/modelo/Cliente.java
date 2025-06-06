package pe.edu.upeu.sysgestionturismo.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombres;
    private String apellidos;
    private String numDocumento;
    private String imagenPerfil;
    private String whatsappContacto;
    private String correo;
    private String direccion;
    private String tipoDocumento;
}
