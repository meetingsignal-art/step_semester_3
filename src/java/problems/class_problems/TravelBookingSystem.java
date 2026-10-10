package problems.class_problems;

import java.util.*;

abstract class TravelBooking {
    private static final double BOOKING_FEE = 50.0; // Written in ONE place only
    protected double distanceKm;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    // Template method: combines fixed fee + specific fare
    public final double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    protected abstract double calculateBaseFare();
    public abstract String getMode();
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) { super(distanceKm); }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() { return "BUS"; }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) { super(distanceKm); }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() { return "TRAIN"; }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) { super(distanceKm); }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }

    @Override
    public String getMode() { return "FLIGHT"; }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<TravelBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double dist = sc.nextDouble();

            TravelBooking booking = null;
            switch (mode) {
                case "BUS": booking = new BusBooking(dist); break;
                case "TRAIN": booking = new TrainBooking(dist); break;
                case "FLIGHT": booking = new FlightBooking(dist); break;
            }

            if (booking != null) bookings.add(booking);
        }

        for (TravelBooking b : bookings) {
            System.out.printf("%s: %.2f\n", b.getMode(), b.calculateTotal());
        }

        sc.close();
    }
}