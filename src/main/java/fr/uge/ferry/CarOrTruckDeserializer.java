package fr.uge.ferry;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

final class CarOrTruckDeserializer extends StdDeserializer<Vehicle> {
  CarOrTruckDeserializer() {
    super(Vehicle.class);
  }

  @Override
  public Vehicle deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    var codec = parser.getCodec();
    var node = codec.readTree(parser);
    if (node.get("ownerName") != null) {
      return codec.treeToValue(node, Car.class);
    }
    return codec.treeToValue(node, Truck.class);
  }
}
