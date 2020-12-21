package cl.bice.indicators.domain;

import cl.bice.indicators.enums.ErrorIndicators;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;

@Getter
@Setter
@Builder
public class ApiRequest {
    private String apiName;
    private String rut;
    private UriComponents uri;
    private HttpEntity entity;
    private HttpMethod method;
    private ErrorIndicators connectionError;
    private ErrorIndicators serverError;
    private RestTemplate restTemplate;
}
