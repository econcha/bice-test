package cl.bice.indicators.services;

import cl.bice.indicators.domain.Currency;
import cl.bice.indicators.enums.CurrencyType;
import cl.bice.indicators.domain.detail.History;

import java.io.IOException;
import java.util.List;

public interface IndicatorService {

    List<Currency> getLastCurrency() throws IOException;

    History getDetailCurrency(CurrencyType currencyType);
    //Valores obtieneValores(Indicator indicator) ;

    //ValoresAnio obtieneValoresAnio(Indicator indicator) ;
}
