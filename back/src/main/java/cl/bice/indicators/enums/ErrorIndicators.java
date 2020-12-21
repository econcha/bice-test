package cl.bice.indicators.enums;

import lombok.Getter;

@Getter
public enum ErrorIndicators  {

    DEFAULT("01", "Error genérico"),
    ERROR_CONNECTION_LAST_INDICATORS("02", "Error de conexión api indicadores"),
    ERROR_SERVER_LAST_INDICATORS("03", "Error Interno api indicadores");

    private final String code;
    private final String message;

    ErrorIndicators(final String code, final String message) {
        this.code = code;
        this.message = message;
    }


}
