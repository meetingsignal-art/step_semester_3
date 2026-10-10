package problems.assignment_problems;

import java.util.*;

interface SaverMode {
    boolean supportsSaver();
}

abstract class Appliance {
    protected double hours;
    protected double powerRating; // in Watts

    public Appliance(double hours, double powerRating) {
        this.hours = hours;
        this.powerRating = powerRating;
    }

    public final void report(boolean useSaver) {
        if (useSaver) {
            if (this instanceof SaverMode && ((SaverMode)this).supportsSaver()) {
                double units = (powerRating * hours * 0.75) / 1000.0;
                double cost = units * 8.0;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", getType(), units, cost);
            } else {
                System.out.println(getType() + ": saver mode not supported");
                return;
            }
        } else {
            double units = (powerRating * hours) / 1000.0;
            double cost = units * 8.0;
            System.out.printf("%s: Units=%.2f Cost=%.2f\n", getType(), units, cost);
        }
    }

    public abstract String getType();
}

class Fridge extends Appliance {
    public Fridge(double hours) { super(hours, 150); }
    @Override
    public String getType() { return "FRIDGE"; }
}

class AC extends Appliance implements SaverMode {
    public AC(double hours) { super(hours, 1500); }
    @Override
    public String getType() { return "AC"; }
    @Override
    public boolean supportsSaver() { return true; }
}

class TV extends Appliance {
    public TV(double hours) { super(hours, 100); }
    @Override
    public String getType() { return "TV"; }
}

class Washer extends Appliance implements SaverMode {
    public Washer(double hours) { super(hours, 500); }
    @Override
    public String getType() { return "WASHER"; }
    @Override
    public boolean supportsSaver() { return true; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = false;
            if (sc.hasNext()) {
                String next = sc.next();
                if (next.equals("SAVER")) saver = true;
            }

            Appliance a = null;
            if (type.equals("FRIDGE")) a = new Fridge(hours);
            else if (type.equals("AC")) a = new AC(hours);
            else if (type.equals("TV")) a = new TV(hours);
            else if (type.equals("WASHER")) a = new Washer(hours);

            if (a != null) {
                // To calculate total cost properly, we need to extract cost from report
                // For simplicity in this specific output format, we'll recalculate or
                // modify the report method to return cost.
                // Let's adjust the Appliance class slightly for the total.

                // Re-calculating for total accumulation:
                double cost = 0;
                boolean supported = true;
                if (saver) {
                    if (a instanceof SaverMode && ((SaverMode)a).supportsSaver()) {
                        cost = ((a.powerRating * a.hours * 0.75) / 1000.0) * 8.0;
                    } else {
                        supported = false;
                    }
                } else {
                    cost = ((a.powerRating * a.hours) / 1000.0) * 8.0;
                }

                if (!supported) {
                    System.out.println(a.getType() + ": saver mode not supported");
                } else {
                    double units = (saver ? (a.powerRating * a.hours * 0.75) : (a.powerRating * a.hours)) / 1000.0;
                    System.out.printf("%s: Units=%.2f Cost=%.2f\n", a.getType(), units, cost);
                    totalCost += cost;
                }
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
        sc.close();
    }
}