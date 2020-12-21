package cl.bice.indicators.services;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class IndicatorServiceImplTest {

    @InjectMocks
    IndicatorServiceImpl indeconService;
    @Mock
    RestTemplate restTemplate;
    @Mock
    Environment environment;
    @Mock
    private ConversionService conversionService;

    @Before
    public void setup() {
        when(environment.getProperty("api.indecon.link")).
                thenReturn(String.valueOf("http://localhost:8080"));
        when(environment.getProperty("api.indecon.url.ultimos.valores")).
                thenReturn(String.valueOf("/last"));
    }


}