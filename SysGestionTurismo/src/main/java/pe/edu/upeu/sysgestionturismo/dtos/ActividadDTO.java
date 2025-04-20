package pe.edu.upeu.sysgestionturismo.dtos;

public class ActividadDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double costo;
    private String tipo; // Ej: Kayak, Cabalgata, etc.
    private String duracion; // Ej: 2 horas, 1 día
    private String imagenUrl; // URL de una imagen representativa de la actividad
    private boolean disponible; // Estado de la actividad (disponible o no)

    // Constructores
    public ActividadDTO() {
    }

    public ActividadDTO(Long id, String nombre, String descripcion, Double costo, String tipo, String duracion, String imagenUrl, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.tipo = tipo;
        this.duracion = duracion;
        this.imagenUrl = imagenUrl;
        this.disponible = disponible;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}