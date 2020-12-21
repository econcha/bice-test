package cl.bice.indicators.domain.detail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties
public class Value {
    LocalDate fecha;
    Double value;
}
