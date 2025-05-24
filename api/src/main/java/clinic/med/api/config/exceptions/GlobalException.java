package clinic.med.api.config.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity ErrorNotFound(){

        return ResponseEntity.notFound().build();

    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity ErrorNotFound(NoSuchElementException exception){

        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity ErrorBadRequest(MethodArgumentNotValidException exception){
        var errors = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(errors.stream().map(DataError::new).toList());
    }
    private record DataError(String attribute, String message) {
        public DataError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

    }
}
