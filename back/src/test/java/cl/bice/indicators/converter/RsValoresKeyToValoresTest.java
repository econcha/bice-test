package cl.bice.indicators.converter;

import cl.bice.indicators.fixture.LastFixture;
import cl.bice.indicators.domain.valoresKey.Valores;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RsValoresKeyToValoresTest {
    @InjectMocks
    RsValoresKeyToValores rs;

    @Test
    public void name() {
        Valores convert = rs.convert(LastFixture.getRsMetalesForKey());

        Assert.assertNotEquals("", convert.getKey());
        Assert.assertEquals("cobre", convert.getKey());
    }
}