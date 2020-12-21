package cl.bice.indicators.domain.chart;

import cl.bice.indicators.domain.chart.MonthDetail;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
@JsonIgnoreProperties
public class ChartDetail {
    private String anio;
    private List<String> months;
    private List<MonthDetail> stadistics;
}
