package fr.uge.ferry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class FerryFare {
    private FerryFare(){
    }
    public static Map<String, Integer> computeFare(List<Car> cars){
        Objects.requireNonNull(cars);
        var map = new HashMap<String, Integer>();
        for(var car : cars){
            map.merge(car.ownerName(), car.passengers() * 100, Integer::sum);
        }
        return map;
    }
}
