package cl.bice.indicators.controller;

import cl.bice.indicators.domain.Currency;
import cl.bice.indicators.enums.CurrencyType;
import cl.bice.indicators.domain.detail.History;
import cl.bice.indicators.services.IndicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * Controller con servicios que consumen indices de indecon
 */
@RestController
public class IndicatorsController {

    @Autowired
    private IndicatorService indicatorService;

    /**
     * Disponibiliza indicadores actualizados a la fecha
     *
     * @return list
     */
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/last")
    public ResponseEntity<List<Currency>> getLastIndicators() throws IOException {
        List<Currency> ultimosValores = indicatorService.getLastCurrency();
        return ResponseEntity.ok(ultimosValores);
    }

    /**
     * Disponibiliza Detalle valores de un indicador en el tiempo
     *
     * @return list
     */
    @CrossOrigin(origins = "*", methods = {RequestMethod.GET})
    @GetMapping(value = "/{currency}/detail")
    public ResponseEntity<History> getCurrencyDetail(@PathVariable CurrencyType currency) throws IOException {
        History detail = indicatorService.getDetailCurrency(currency);
        return ResponseEntity.ok(detail);
    }

}
