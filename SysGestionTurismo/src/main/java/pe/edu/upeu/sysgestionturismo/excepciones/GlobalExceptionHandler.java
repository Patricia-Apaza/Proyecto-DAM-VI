package pe.edu.upeu.sysgestionturismo.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<CustomResponse> handleAccessDeniedException(
            AccessDeniedException ex, WebRequest request) {

        CustomResponse errorResponse = new CustomResponse(
                HttpStatus.FORBIDDEN.value(),
                LocalDateTime.now(),
                "No tienes permisos para acceder a este recurso",
                request.getDescription(false).replace("uri=", "")
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomResponse> handleModelNotFoundException(
            ModelNotFoundException ex, WebRequest request) {

        CustomResponse errorResponse = new CustomResponse(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse> handleGenericException(
            Exception ex, WebRequest request) {

        CustomResponse errorResponse = new CustomResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                "Error interno del servidor: " + ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
