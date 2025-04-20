package pe.edu.upeu.sysgestionturismo.dtos;

public class UsuarioDTO {

    private Long id;                          // Identificador único del usuario
    private String nombre;                    // Nombre completo del usuario
    private String correo;                    // Correo electrónico del usuario
    private String contrasena;                // Contraseña del usuario (debe ser encriptada)
    private String rol;                       // Rol del usuario (ejemplo: ADMIN, CLIENTE, etc.)
    private boolean estado;                   // Estado del usuario (activo o inactivo)
    private String token;

    // Constructor vacío
    public UsuarioDTO() {
    }

    // Constructor con parámetros
    public UsuarioDTO(Long id, String nombre, String correo, String contrasena, String rol, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public record CredencialesDto(String user, char[] clave) { }

    public record UsuarioCrearDto(String user, char[] clave, String rol, String estado) { }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser() {
        return this.correo; // o el campo que usas como username
    }

}