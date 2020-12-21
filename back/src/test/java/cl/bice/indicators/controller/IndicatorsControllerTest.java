package cl.bice.indicators.controller;

import cl.bice.indicators.fixture.LastFixture;
import static org.hamcrest.Matchers.hasSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IndicatorsControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private RestTemplate restTemplate;

    private final String INDICATORS_ENDPOINT = "/";
    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON_UTF8.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);


    @Test
    public void testGetDetailIndicatorOk() throws Exception {
        // mock llamadas en orden API
        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class)))
                .thenReturn(ResponseEntity.accepted().body(LastFixture.bodyRsForKey));

        mvc.perform(get(INDICATORS_ENDPOINT + "cobre/detail")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        ;
    }

    @Test
    public void testGetLastIndicatorsOk() throws Exception {
        // mock llamadas en orden API
        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class)))
                .thenReturn(ResponseEntity.accepted().body(LastFixture.bodyRsLast));

        mvc.perform(get(INDICATORS_ENDPOINT + "last")
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.*", hasSize(10)));
        ;
    }

    @Test
    public void testGetLastIndicatorsFailResourceException() throws Exception {
        // mock llamadas en orden API
        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class)))
                .thenThrow(ResourceAccessException.class);

        mvc.perform(get(INDICATORS_ENDPOINT + "last")
                .contentType(contentType))
                .andExpect(status().isInternalServerError())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetLastIndicatorsFailException() throws Exception {
        // mock llamadas en orden API
        HttpClientErrorException ex = new HttpClientErrorException(HttpStatus.UNAUTHORIZED);

        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class)))
                .thenThrow(ex);

        mvc.perform(get(INDICATORS_ENDPOINT + "last")
                .contentType(contentType))
                .andExpect(status().isInternalServerError())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

}