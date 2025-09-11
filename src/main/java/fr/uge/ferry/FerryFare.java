package fr.uge.ferry;

import java.util.*;
import java.util.function.BiFunction;

public final class FerryFare {
    private FerryFare() {
    }
    public static Map<String, Integer> computeFare(List<? extends Vehicle> vehicles) {
        Objects.requireNonNull(vehicles);
        var map = new LinkedHashMap<String, Integer>();
        for (var vehicle : vehicles) {
            map.merge(keyOf(vehicle), fareOf(vehicle), Integer::sum);
        }
        return map;
    }

    public static Map<String, Integer> computeFareWithFleetDiscount(List<? extends Vehicle> vehicles, int fleetSize) {
        Objects.requireNonNull(vehicles);
        if (fleetSize < 0) {
            throw new IllegalArgumentException("fleet size is negative");
        }
        var map = computeFare(vehicles);
        var groups = groupByKey(vehicles);
        for (var entry : map.entrySet()) {
            if (groups.get(entry.getKey()).size() < fleetSize) {
                entry.setValue(entry.getValue() * 90 / 100);
            }
        }
        return map;
    }

    public static Map<String, Integer> computeFareWithFleetDiscount(List<? extends Vehicle> vehicles, BiFunction<Integer, List<? extends Vehicle>, Integer> discount) {
        Objects.requireNonNull(vehicles);
        Objects.requireNonNull(discount);
        var map = computeFare(vehicles);
        var groups = groupByKey(vehicles);
        map.replaceAll((key, amount) -> discount.apply(amount, groups.get(key)));
        return map;
    }

    private static String keyOf(Vehicle vehicle) {
        return switch (vehicle) {
            case Car car -> car.ownerName();
            case Truck truck -> truck.companyName();
        };
    }

    private static int fareOf(Vehicle vehicle) {
        return switch (vehicle) {
            case Car car -> car.passengers() * 100;
            case Truck truck -> truck.weight() * 2;
        };
    }

    private static Map<String, List<Vehicle>> groupByKey(List<? extends Vehicle> vehicles) {
        var groups = new LinkedHashMap<String, List<Vehicle>>();
        for (var vehicle : vehicles) {
            var key = keyOf(vehicle);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(vehicle);
        }
        return groups;
    }
}