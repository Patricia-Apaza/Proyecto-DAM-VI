package pe.edu.upeu.sysgestionturismo.excepciones;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(String message) {
        super(message);
    }

    public ModelNotFoundException(Long id, String nombreEntidad) {
        super(nombreEntidad + " con ID " + id + " no fue encontrado.");
    }

    public ModelNotFoundException(String campo, String valor, String nombreEntidad) {
        super(nombreEntidad + " con " + campo + " = " + valor + " no fue encontrado.");
    }
}