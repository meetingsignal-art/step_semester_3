package problems.assignment_problems;

import java.util.*;

interface NightService {
    boolean isAvailable();
}

abstract class Cab {
    protected double km;
    private static final double MIN_FARE = 100.0;

    public Cab(double km) { this.km = km; }

    public final double calculateFare(boolean isNight) {
        double base = getRate() * km;
        if (base < MIN_FARE) base = MIN_FARE;

        if (isNight) {
            if (this instanceof NightService && ((NightService)this).isAvailable()) {
                return base * 1.20;
            } else {
                return -1; // Signal for rejection
            }
        }
        return base;
    }

    protected abstract double getRate();
    public abstract String getType();
}

class MiniCab extends Cab {
    public MiniCab(double km) { super(km); }
    @Override
    protected double getRate() { return 10.0; }
    @Override
    public String getType() { return "MINI"; }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km) { super(km); }
    @Override
    protected double getRate() { return 14.0; }
    @Override
    public String getType() { return "SEDAN"; }
    @Override
    public boolean isAvailable() { return true; }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double km) { super(km); }
    @Override
    protected double getRate() { return 18.0; }
    @Override
    public String getType() { return "SUV"; }
    @Override
    public boolean isAvailable() { return true; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            boolean isNight = time.equals("NIGHT");

            Cab c = null;
            if (type.equals("MINI")) c = new MiniCab(km);
            else if (type.equals("SEDAN")) c = new SedanCab(km);
            else if (type.equals("SUV")) c = new SUVCab(km);

            if (c != null) {
                double fare = c.calculateFare(isNight);
                if (fare == -1) {
                    System.out.println(c.getType() + ": night service not available");
                } else {
                    total += fare;
                    System.out.printf("%s: %.2f\n", c.getType(), fare);
                }
            }
        }
        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}