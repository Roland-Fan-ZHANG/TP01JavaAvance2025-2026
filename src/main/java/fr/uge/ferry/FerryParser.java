package fr.uge.ferry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public final class FerryParser {
    private static final ObjectReader reader = new ObjectMapper()
            .registerModule(new SimpleModule().addDeserializer(Vehicle.class, new CarOrTruckDeserializer()))
            .reader();
    private FerryParser(){
    }
    public static List<Vehicle> parse(String jsonText) throws IOException {
        Objects.requireNonNull(jsonText);
        return reader.forType(new TypeReference<List<Vehicle>>(){}).readValue(jsonText);
    }
}
