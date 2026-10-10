package problems.class_problems;

import java.util.*;

abstract class Transport {
    protected String type;
    protected double distance;

    public Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public abstract double calculateFare();

    public String getType() {
        return type;
    }
}

class Bus extends Transport {
    public Bus(double distance) {
        super("BUS", distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2 + (0.10 * distance);
        return Math.min(fare, 10); // Max fare $10
    }
}

class Train extends Transport {
    public Train(double distance) {
        super("TRAIN", distance);
    }

    @Override
    public double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super("METRO", distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Transport> transports = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;
            if (type.equals("METRO")) {
                double peakFactor = sc.nextDouble();
                transport = new Metro(distance, peakFactor);
            } else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            } else {
                transport = new Bus(distance);
            }

            transports.add(transport);
        }

        for (Transport t : transports) {
            double fare = t.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f\n", t.getType(), fare);
        }

        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}