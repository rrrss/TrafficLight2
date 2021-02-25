package com.google;

import java.util.*;

public class Solution {

    void solve() {
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        int nIntersections = scan.nextInt();
        int nStreets = scan.nextInt();
        int nCars = scan.nextInt();
        int score = scan.nextInt();
        
        Intersection[] intersections = new Intersection[nIntersections];
        for (int i = 0; i < nIntersections; i ++) {
            intersections[i] = new Intersection(intersections, i, duration, score);
        }
        
        // List<Street> streets = new ArrayList<>();
        Map<String, Street> streets = new HashMap<>();
        for (int i = 0; i < nStreets; i ++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            String name = scan.next();
            int time = scan.nextInt();
            Street street = new Street(i, name, start, end, time);
            streets.put(name, street);
            intersections[end].streets.add(street);
        }
        
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < nCars; i ++) {
            Car car = new Car(i);
            int n = scan.nextInt();
            String streetName = scan.next();
            intersections[streets.get(streetName).end].cars.add(car);
            for (int j = 1; j < n; j ++) {
                streetName = scan.next();
                car.addStreet(streets.get(streetName));
            }
            cars.add(car);
        }
        
        System.out.println(nIntersections);
        for (int i = 0; i < nIntersections; i ++) {
            System.out.println(i);
            List<Street> strs = intersections[i].streets;
            System.out.println(strs.size());
            for (int j = 0; j < strs.size(); j ++) {
                System.out.println(strs.get(j).name + " 1");
            }
        }
        
//        int total = 0;
//        for (int i = 0; i < duration; i ++) {
//            for (Intersection it : intersections) {
//                total += it.process(i);
//            }
//            for (Car car : cars) {
//                System.out.printf("time=%d, car=%d, streets=%s\n", i, car.id, car.getStreets());
//            }
//        }
//        System.out.println(total);
    }
    

    
    public static void main(String[] args) {
        new Solution().solve();
    }
    
}


/*
        for (int i = 0; i < nCars; i ++) {
            int time = 0;
            Car car = cars.get(i);
            List<Street> strs = car.getStreets();
            for (int j = 1; j < strs.size(); j ++) {
                time += strs.get(j).time;
            }
            System.out.println(i + " " + time);
        }
        
        // solveImpl(duration, nIntersections, streets, cars, scores);

    void solveImpl(int duration, int nIntersections, Map<String, Street> streets, List<Car> cars, int scores) {
        
    }
    
    void helper() {
        
    }
*/