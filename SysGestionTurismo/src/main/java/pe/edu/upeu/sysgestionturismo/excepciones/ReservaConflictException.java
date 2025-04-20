package pe.edu.upeu.sysgestionturismo.excepciones;

public class ReservaConflictException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ReservaConflictException(String mensaje) {
        super(mensaje);
    }

    public ReservaConflictException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}