package fr.uge.ferry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class FerryFare {
    private FerryFare(){
    }
    public static Map<String, Integer> computeFare(List<? extends Vehicle> vehicles){
        Objects.requireNonNull(vehicles);
        var map = new HashMap<String, Integer>();
        for(var vehicle : vehicles){
            switch (vehicle){
                case Car car -> map.merge(car.ownerName(), car.passengers() * 100, Integer::sum);
                case Truck truck -> map.merge(truck.companyName(), truck.weight() * 2, Integer::sum);
            }
        }
        return map;
    }
}
