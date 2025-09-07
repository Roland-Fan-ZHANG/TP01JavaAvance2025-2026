package fr.uge.ferry;

import java.util.Objects;

public record Car(String ownerName, int passengers, int children) {
    public Car{
        Objects.requireNonNull(ownerName);
        if(children >= passengers){
            throw new IllegalArgumentException("children is greater than passengers");
        }
        if(children < 0){
            throw new IllegalArgumentException("children is negative");
        }
    }
}
