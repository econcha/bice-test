package cl.bice.indicators.domain.detail;

import cl.bice.indicators.deserializer.ValueDeserializer;
import cl.bice.indicators.domain.chart.ChartDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class History {
    private String key;
    private String name;
    private String unit;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonDeserialize(using = ValueDeserializer.class)
    List<Value> values;
    List<ChartDetail> detail;
}
