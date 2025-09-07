package fr.uge.ferry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public final class FerryParser {
    private static final ObjectReader reader = new ObjectMapper()
            .reader();
    private FerryParser(){
    }
    public static List<Car> parse(String jsonText) throws IOException {
        Objects.requireNonNull(jsonText);
        try(JsonParser parser = reader.createParser(jsonText)){
            return parser.readValueAs(new TypeReference<List<Car>>(){});
        }
    }
}
