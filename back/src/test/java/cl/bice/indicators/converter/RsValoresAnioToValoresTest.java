package cl.bice.indicators.converter;


import cl.bice.indicators.fixture.LastFixture;
import cl.bice.indicators.domain.valoresAnio.ValoresAnio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RsValoresAnioToValoresTest {

    @InjectMocks
    RsValoresAnioToValores rsValoresAnioToValores;

    @Test
    public void name() {
        ValoresAnio convert = rsValoresAnioToValores.convert(LastFixture.getRsMetalesForKey());

        Assert.assertNotEquals("", convert.getKey());
        Assert.assertEquals("cobre", convert.getKey());
    }
}