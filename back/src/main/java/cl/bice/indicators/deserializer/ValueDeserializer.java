package cl.bice.indicators.deserializer;

import cl.bice.indicators.domain.detail.Value;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ValueDeserializer extends StdDeserializer<List<Value>> {
    private static final long serialVersionUID = 1L;

    protected ValueDeserializer() {
        super(List.class);
    }

    @Override
    public List<Value> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        Map<String, Double> node = jp.readValueAs(Map.class);
        return mapToListClass.apply(node);
    }


    private Function<Map<String, Double>, List<Value>> mapToListClass = values -> {
        List<Value> historyValues = new ArrayList<>();
        values.forEach((k, v) -> {
            LocalDate date = Instant.ofEpochSecond(Long.parseLong(k)).atZone(ZoneId.systemDefault()).toLocalDate();
            historyValues.add(new Value(date, v));
        });
        return historyValues;
    };
}


