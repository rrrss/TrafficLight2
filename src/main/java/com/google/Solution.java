package com.google;

import java.util.*;

public class Solution {

    void solve() {
        Scanner scan = new Scanner(System.in);
        int duration = scan.nextInt();
        int nIntersections = scan.nextInt();
        int nStreets = scan.nextInt();
        int nCars = scan.nextInt();
        int scores = scan.nextInt();
        
        // List<Street> streets = new ArrayList<>();
        Map<String, Street> streets = new HashMap<>();
        for (int i = 0; i < nStreets; i ++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            String name = scan.next();
            int time = scan.nextInt();
            streets.put(name, new Street(i, name, start, end, time));
        }
        
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < nCars; i ++) {
            Car car = new Car(i);
            int n = scan.nextInt();
            for (int j = 0; j < n; j ++) {
                String streetName = scan.next();
                car.addStreet(streets.get(streetName));
            }
            cars.add(car);
        }
        
        solveImpl(duration, nIntersections, streets, cars, scores);
        
    }
    
    void solveImpl(int duration, int nIntersections, Map<String, Street> streets, List<Car> cars, int scores) {
        
    }
    
    public static void main(String[] args) {
        new Solution().solve();
    }
    
}
