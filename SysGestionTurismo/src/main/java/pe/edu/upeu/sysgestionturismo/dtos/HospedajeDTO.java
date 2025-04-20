package pe.edu.upeu.sysgestionturismo.dtos;

public class HospedajeDTO {

    private Long id;                 // Identificador único del hospedaje
    private String nombre;           // Nombre del hospedaje (por ejemplo, "Casa Familiar Vista Lago")
    private String descripcion;      // Descripción del hospedaje
    private String direccion;        // Dirección del hospedaje
    private int capacidad;           // Capacidad máxima de personas en el hospedaje
    private String tipo;             // Tipo de hospedaje (Casa, Hospedaje Comunitario, etc.)
    private double precioNoche;      // Precio por noche del hospedaje
    private boolean disponible;      // Estado de disponibilidad del hospedaje
    private String imagenUrl;        // URL de la imagen representativa del hospedaje

    // Constructor vacío
    public HospedajeDTO() {
    }

    // Constructor con parámetros
    public HospedajeDTO(Long id, String nombre, String descripcion, String direccion, int capacidad, String tipo, double precioNoche, boolean disponible, String imagenUrl) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.disponible = disponible;
        this.imagenUrl = imagenUrl;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}