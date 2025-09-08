package fr.uge.ferry;

import java.util.Objects;

public record Truck(String companyName, int weight) implements Vehicle {
    public Truck{
        Objects.requireNonNull(companyName);
        if(weight < 0){
            throw new IllegalArgumentException("weight is negative");
        }
    }
}
