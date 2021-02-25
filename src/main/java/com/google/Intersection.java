package com.google;

import java.util.*;

public class Intersection {
    int duration;
    int score;
    
    List<Street> streets = new ArrayList<>();
    Queue<Car> cars = new PriorityQueue<>((a, b) -> a.nextArrive - b.nextArrive);

    public Intersection(int duration, int score) {
        this.duration = duration;
        this.score = score;
    }
    
    int process(int time) {
        int turn = time % streets.size();
        Street next = streets.get(turn);
        if (!cars.isEmpty()) {
            Car car = cars.peek();
            if (car.getStreets().isEmpty()) {
                return score + duration - time;
            }
            if (car.nextArrive >= time && car.getStreets().get(0) == next) {
                car = cars.poll();
                car.getStreets().remove(0);
                car.nextArrive = time + streets.get(turn).time;
            }
        }
        return 0;
    }
}
