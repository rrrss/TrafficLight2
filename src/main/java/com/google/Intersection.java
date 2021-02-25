package com.google;

import java.util.*;

public class Intersection {

    int score;
    int duration;
    Intersection[] intersections;

    int id;
    List<Street> streets = new ArrayList<>();
    Queue<Car> cars = new PriorityQueue<>((a, b) -> a.nextArrive - b.nextArrive);

    public Intersection(Intersection[] intersections, int id, int duration, int score) {
        this.id = id;
        this.score = score;
        this.duration = duration;
        this.intersections = intersections;
    }

    int process(int time) {
        int turn = time % streets.size();
        Street next = streets.get(turn);
        if (!cars.isEmpty()) {
            Car car = cars.peek();
            if (car.getStreets().isEmpty()) {
                return score + duration - time;
            }
            if (car.nextArrive <= time && car.getStreets().get(0) == next) {
                car = cars.poll();
                car.getStreets().remove(0);
                car.nextArrive = time + next.time;
                intersections[next.end].cars.add(car);
            }
        }
        return 0;
    }
}
