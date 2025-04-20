package pe.edu.upeu.sysgestionturismo.excepciones;

public class PaymentException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PaymentException(String mensaje) {
        super(mensaje);
    }

    public PaymentException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
