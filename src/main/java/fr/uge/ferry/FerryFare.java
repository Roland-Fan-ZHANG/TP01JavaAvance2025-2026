package fr.uge.ferry;

import java.util.*;

public final class FerryFare {
    private FerryFare(){
    }
    public static Map<String, Integer> computeFare(List<? extends Vehicle> vehicles){
        Objects.requireNonNull(vehicles);
        var map = new LinkedHashMap<String, Integer>();
        for(var vehicle : vehicles){
            switch (vehicle){
                case Car car -> map.merge(car.ownerName(), car.passengers() * 100, Integer::sum);
                case Truck truck -> map.merge(truck.companyName(), truck.weight() * 2, Integer::sum);
            }
        }
        return map;
    }

    public static Map<String, Integer> computeFareWithFleetDiscount(List<? extends Vehicle> vehicles, int fleetSize) {
        Objects.requireNonNull(vehicles);
        if(fleetSize < 0){
            throw new IllegalArgumentException("fleet size is negative");
        }
        var map = computeFare(vehicles);
        var carCounts = new HashMap<String, Integer>();
        var truckCounts = new HashMap<String, Integer>();
        for (var vehicle : vehicles) {
            switch (vehicle) {
                case Car c -> carCounts.merge(c.ownerName(), 1, Integer::sum);
                case Truck t -> truckCounts.merge(t.companyName(), 1, Integer::sum);
            }
        }
        for (var entry : map.entrySet()) {
            var key = entry.getKey();
            if (carCounts.containsKey(key) && carCounts.get(key) < fleetSize || truckCounts.containsKey(key) && truckCounts.get(key) < fleetSize) {
                entry.setValue(entry.getValue() * 90 / 100);
            }
        }
        return map;
    }
}