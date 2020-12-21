package cl.bice.indicators.services;

import cl.bice.indicators.domain.Constants;
import cl.bice.indicators.domain.ApiRequest;
import cl.bice.indicators.domain.chart.ChartDetail;
import cl.bice.indicators.domain.Currency;
import cl.bice.indicators.enums.CurrencyType;
import cl.bice.indicators.domain.detail.History;
import cl.bice.indicators.domain.LastIndicatorsResponse;
import cl.bice.indicators.domain.chart.MonthDetail;
import cl.bice.indicators.domain.detail.Value;
import cl.bice.indicators.enums.ErrorIndicators;
import cl.bice.indicators.util.HeadersUtils;
import cl.bice.indicators.util.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class IndicatorServiceImpl implements IndicatorService {

    @Autowired
    private Environment environment;

    @Autowired
    private ApiService apiService;

    @Autowired
    @Qualifier(Constants.REST_TEMPLATE_WITHOUT_CERT)
    RestTemplate restTemplate;

    private static final List<String> MESES = List.of("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");


    @Override
    public List<Currency> getLastCurrency() throws IOException {
        // headers
        HttpHeaders headers = HeadersUtils.getGenericHttpHeaders();
        // entity
        HttpEntity entity = new HttpEntity(headers);
        // uri
        String url = environment.getProperty("api.indicators.last-values");
        UriComponents uri = UriComponentsBuilder.fromUriString(url).build().encode();

        String responseString = apiService.execute(ApiRequest.builder()
                .apiName("getLastIndicators")
                .entity(entity)
                .uri(uri)
                .method(HttpMethod.GET)
                .restTemplate(restTemplate)
                .rut("-")
                .connectionError(ErrorIndicators.ERROR_CONNECTION_LAST_INDICATORS)
                .serverError(ErrorIndicators.ERROR_SERVER_LAST_INDICATORS)
                .build());

        // Casteo a clase
        LastIndicatorsResponse indicators = MapperUtils.castStringToClass(responseString, LastIndicatorsResponse.class);
        return indicators.toList();
    }

    @Override
    public History getDetailCurrency(CurrencyType currencyType) {
        // headers
        HttpHeaders headers = HeadersUtils.getGenericHttpHeaders();
        // entity
        HttpEntity entity = new HttpEntity(headers);
        // uri
        String url = environment.getProperty("api.indicators.currency.detail");
        UriComponents uri = UriComponentsBuilder.fromUriString(url).build()
                .expand(currencyType)
                .encode();

        String responseString = apiService.execute(ApiRequest.builder()
                .apiName("getDetailCurrency")
                .entity(entity)
                .uri(uri)
                .method(HttpMethod.GET)
                .restTemplate(restTemplate)
                .rut("-")
                .connectionError(ErrorIndicators.ERROR_CONNECTION_LAST_INDICATORS)
                .serverError(ErrorIndicators.ERROR_SERVER_LAST_INDICATORS)
                .build());
        History history = MapperUtils.castStringToClass(responseString, History.class);

        this.associateDetailChart(history);

        return history;

    }


    private  void associateDetailChart(History history) {
        List<ChartDetail> structure = new ArrayList<>();

        // get distinct years
        List<Integer> years = history.getValues()
                .stream()
                .map(item -> item.getFecha().getYear())
                .distinct()
                .collect(Collectors.toList());


        // for each year set stadistics
        years.forEach(item ->
            structure.add(ChartDetail.builder()
                    .anio(String.valueOf(item))
                    .months(MESES)
                    .stadistics(this.getAverageFromMonth(history.getValues(), item))
                    .build())
        );
        history.setDetail(structure);
    }


    private List<MonthDetail> getAverageFromMonth(List<Value> values, Integer year) {
        List<MonthDetail> stadistics = new ArrayList<>();
        AtomicInteger month = new AtomicInteger(1);
        MESES.forEach(item -> {
             stadistics.add(this.getStadisticsFromMonth(values, year, month.get()));
             month.getAndIncrement();
        });
        return stadistics;
    }

    private MonthDetail getStadisticsFromMonth(List<Value> values, Integer year, int month) {
        DoubleSummaryStatistics stadistics =  values
                .stream()
                .filter(item -> {
                    LocalDate comparatorDate = LocalDate.of(year, month, 1);
                    return comparatorDate.equals(item.getFecha().withDayOfMonth(1));
                })
                .mapToDouble(Value::getValue)
                .summaryStatistics();
        return MonthDetail.builder().month(month).stadistic(stadistics).build();
    }
}
