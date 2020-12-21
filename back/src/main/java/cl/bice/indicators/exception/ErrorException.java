package cl.bice.indicators.exception;

import cl.bice.indicators.enums.ErrorIndicators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorException  extends  RuntimeException {
    private String code;
    private String message;
    private HttpStatus status;
    private String path;
    private String trace;
    private LocalDateTime date;

    public ErrorException(String code, String message) {
        this.date     = LocalDateTime.now();
        this.code     = code;
        this.message  = message;
    }

    public ErrorException(ErrorIndicators error, HttpStatus status, String path, String trace) {
        this(error.getCode(), error.getMessage());
        this.path = path;
        this.status = status;
        this.trace  = trace;
    }
}
