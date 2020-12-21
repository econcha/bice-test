package cl.bice.indicators.controller;

import cl.bice.indicators.services.IndicatorService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IndicatorsControllerTest {

    @InjectMocks
    IndicatorsController indicatorsController;

    @Mock
    IndicatorService indicatorService;

    @Before
    public void beforeClass() throws Exception {
        when(indicatorService.getLastCurrency())
                .thenReturn(new ArrayList<>());
    }

}