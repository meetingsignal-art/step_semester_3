package problems.assignment_problems;

import java.util.*;

abstract class Vehicle {
    protected String type;
    protected int hours;

    public Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    public abstract double calculateCharge();

    public String getType() {
        return type;
    }
}

class Bike extends Vehicle {
    public Bike(int hours) {
        super("BIKE", hours);
    }

    @Override
    public double calculateCharge() {
        return 10 * hours; // ₹10 per hour
    }
}

class Car extends Vehicle {
    public Car(int hours) {
        super("CAR", hours);
    }

    @Override
    public double calculateCharge() {
        if (hours == 1) {
            return 30;
        } else {
            return 30 + (20 * (hours - 1)); // ₹30 first hour + ₹20 each additional
        }
    }
}

class Truck extends Vehicle {
    public Truck(int hours) {
        super("TRUCK", hours);
    }

    @Override
    public double calculateCharge() {
        double charge = 50 * hours;
        return Math.max(charge, 100); // Minimum charge ₹100
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Vehicle> vehicles = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;
            switch (type) {
                case "BIKE":
                    vehicle = new Bike(hours);
                    break;
                case "CAR":
                    vehicle = new Car(hours);
                    break;
                case "TRUCK":
                    vehicle = new Truck(hours);
                    break;
                default:
                    continue;
            }

            vehicles.add(vehicle);
        }

        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            total += charge;
            System.out.printf("%s: %.2f\n", v.getType(), charge);
        }

        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}