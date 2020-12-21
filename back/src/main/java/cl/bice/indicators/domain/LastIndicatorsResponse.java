package cl.bice.indicators.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LastIndicatorsResponse {
    Currency cobre;
    Currency dolar;
    Currency euro;
    Currency ipc;
    Currency ivp;
    Currency oro;
    Currency plata;
    Currency uf;
    Currency utm;
    Currency yen;



    public List<Currency> toList() {
        return List.of(cobre, dolar, euro, ipc, ivp, oro, plata, uf , utm, yen);
    }
}
