package cl.bice.indicators.util;

import org.slf4j.Logger;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

import java.util.Map;
import java.util.Objects;

public class LogUtils {

    public LogUtils() {
        throw new UnsupportedOperationException();
    }

    public static void logInitApiService(String metodo, String rut, String params, Logger LOGGER) {
        LOGGER.info("Inicio Api service : {} | rut-id: {} | params: {}", metodo, rut, params);
    }

    public static void logRequestExternalApi(String metodo, String rut, String request, Logger LOGGER) {
        LOGGER.info("Api {} request | rut-id: {} | request: {}", metodo, rut, request);
    }

    public static void logResponseExternalApi(String metodo, String rut, String response, Logger LOGGER) {
        LOGGER.info("Api {} response  | rut-id: {} | response: {}", metodo, rut, response);
    }


    public static void logErrorDashboard(String metodo, String rut, String url, String request,
                                         HttpStatusCodeException exception, Logger LOGGER) {
        Map<String, String> detail = Map.of(
                "url", url,
                "request", request,
                "error", exception.getResponseBodyAsString()
        );

        LOGGER.info("Api {} error | rut-id: {} | detail: {}", metodo, rut, detail);
    }

    public static void logErrorDashboard(String metodo, String rut, String url, String request,
                                         ResourceAccessException exception, Logger LOGGER) {
        Map<String, String> detail = Map.of(
                "url", url,
                "request", request,
                "error", Objects.isNull(exception.getMessage()) ? "" : exception.getMessage()
        );
        LOGGER.info("Api {} error | rut-id: {} | detail: {}", metodo, rut, detail);
    }
};

