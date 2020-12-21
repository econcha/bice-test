package cl.bice.indicators.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerInterceptor {

    @ExceptionHandler(ErrorException.class)
    public final ResponseEntity handleAllExceptions(ErrorException ex) {
        ErrorException exceptionResponse =
        new ErrorException(ex.getCode(), ex.getMessage(), ex.getStatus(), ex.getPath(), ex.getTrace(), ex.getDate());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
