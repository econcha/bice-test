package cl.bice.indicators.services;

import cl.bice.indicators.domain.ApiRequest;
import cl.bice.indicators.exception.ErrorException;
import cl.bice.indicators.util.LogUtils;
import cl.bice.indicators.util.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;

@Service
public class ApiServiceImpl implements ApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiServiceImpl.class);


    @Override
    public String execute(ApiRequest request) {
        LogUtils.logInitApiService(request.getApiName(), request.getRut(), request.getUri().toUriString(), LOGGER);
        String entityString = MapperUtils.castClassToString(request.getEntity());
        try {
            LogUtils.logRequestExternalApi(request.getApiName(), request.getRut(), entityString, LOGGER);
            ResponseEntity<String> response = request.getRestTemplate().exchange(
                    request.getUri().toUri(),
                    request.getMethod(),
                    request.getEntity(),
                    String.class);
            LogUtils.logResponseExternalApi(request.getApiName(), request.getRut(), response.getBody(), LOGGER);
            return response.getBody();
        } catch (ResourceAccessException e) {
            LogUtils.logErrorDashboard(request.getApiName(), request.getRut(), request.getUri().toUriString(),
                    entityString, e, LOGGER);
            throw new ErrorException(request.getConnectionError(),
                                     HttpStatus.NOT_FOUND,
                                     request.getUri().toUriString(),
                                     e.getMessage());
        } catch (HttpStatusCodeException e) {
            LogUtils.logErrorDashboard(request.getApiName(), request.getRut(), request.getUri().toUriString(),
                    entityString, e, LOGGER);
            throw new ErrorException(request.getServerError(),
                                     HttpStatus.INTERNAL_SERVER_ERROR,
                                     request.getUri().toUriString(),
                                     e.getResponseBodyAsString());
        }
    }
}
