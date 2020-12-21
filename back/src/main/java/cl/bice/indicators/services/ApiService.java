package cl.bice.indicators.services;


import cl.bice.indicators.domain.ApiRequest;

public interface ApiService {

    String execute(ApiRequest request);
}
