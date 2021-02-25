package com.google;

import java.util.*;

public class Car {
    
    int id;
    int nextArrive = 0;
    List<Street> streets = new ArrayList<>();

    public Car(int id) {
        this.id = id;
    }
    
    public void addStreet(Street street) {
        streets.add(street);
    }
    
    public List<Street> getStreets() {
        return streets;
    }
    
}
