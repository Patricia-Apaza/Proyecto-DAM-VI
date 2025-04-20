package pe.edu.upeu.sysgestionturismo.dtos;

public class InventarioDTO {

    private Long id;                     // Identificador único del inventario
    private String nombre;               // Nombre del producto o servicio en el inventario
    private String descripcion;          // Descripción detallada del producto o servicio
    private int cantidadDisponible;      // Cantidad disponible del producto o servicio
    private double precioUnitario;       // Precio unitario del producto o servicio
    private String tipo;                 // Tipo de inventario (por ejemplo: Hospedaje, Actividad, etc.)
    private String unidadMedida;         // Unidad de medida (por ejemplo: noches, entradas, etc.)

    // Constructor vacío
    public InventarioDTO() {
    }

    // Constructor con parámetros
    public InventarioDTO(Long id, String nombre, String descripcion, int cantidadDisponible, double precioUnitario, String tipo, String unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadDisponible = cantidadDisponible;
        this.precioUnitario = precioUnitario;
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
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

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
}