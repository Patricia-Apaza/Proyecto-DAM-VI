package pe.edu.upeu.sysgestionturismo.dtos;

import java.util.Date;

public class ReseñaDTO {

    private Long id;                          // Identificador único de la reseña
    private Long clienteId;                   // Identificador del cliente que realiza la reseña
    private Long destinoId;                   // Identificador del destino evaluado
    private Long hospedajeId;                 // Identificador del hospedaje evaluado
    private Long paqueteId;                   // Identificador del paquete turístico evaluado
    private int puntuacion;                   // Puntuación (por ejemplo, de 1 a 5)
    private String comentario;                // Comentarios del cliente sobre la experiencia
    private Date fechaReseña;                 // Fecha en que se hizo la reseña

    // Constructor vacío
    public ReseñaDTO() {
    }

    // Constructor con parámetros
    public ReseñaDTO(Long id, Long clienteId, Long destinoId, Long hospedajeId, Long paqueteId,
                     int puntuacion, String comentario, Date fechaReseña) {
        this.id = id;
        this.clienteId = clienteId;
        this.destinoId = destinoId;
        this.hospedajeId = hospedajeId;
        this.paqueteId = paqueteId;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fechaReseña = fechaReseña;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(Long destinoId) {
        this.destinoId = destinoId;
    }

    public Long getHospedajeId() {
        return hospedajeId;
    }

    public void setHospedajeId(Long hospedajeId) {
        this.hospedajeId = hospedajeId;
    }

    public Long getPaqueteId() {
        return paqueteId;
    }

    public void setPaqueteId(Long paqueteId) {
        this.paqueteId = paqueteId;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaReseña() {
        return fechaReseña;
    }

    public void setFechaReseña(Date fechaReseña) {
        this.fechaReseña = fechaReseña;
    }
}