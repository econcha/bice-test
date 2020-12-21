package cl.bice.indicators.domain;

import cl.bice.indicators.deserializer.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties
public class Currency {
    private String key;
    private String name;
    private String unit;
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime date;
    private Double value;
}
