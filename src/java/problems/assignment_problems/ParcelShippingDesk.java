package problems.assignment_problems;

import java.util.*;

interface Insurable {
    double calculateInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateCharge();
    public abstract String getType();

    // Helper to check if insurable
    public double getInsurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance(declaredValue);
        }
        return 0.0;
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double w, double v) { super(w, v); }
    @Override
    public double calculateCharge() { return 40 + (10 * weightKg); }
    @Override
    public String getType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double w, double v) { super(w, v); }
    @Override
    public double calculateCharge() { return 80 + (15 * weightKg); }
    @Override
    public String getType() { return "EXPRESS"; }
    @Override
    public double calculateInsurance(double declaredValue) { return declaredValue * 0.02; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double w, double v) { super(w, v); }
    @Override
    public double calculateCharge() { return (40 + (10 * weightKg)) + 50; } // Standard charge + handling
    @Override
    public String getType() { return "FRAGILE"; }
    @Override
    public double calculateInsurance(double declaredValue) { return declaredValue * 0.02; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            Parcel p = null;
            if (type.equals("STANDARD")) p = new StandardParcel(w, v);
            else if (type.equals("EXPRESS")) p = new ExpressParcel(w, v);
            else if (type.equals("FRAGILE")) p = new FragileParcel(w, v);
            if (p != null) parcels.add(p);
        }

        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = p.getInsurance();
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n",
                    p.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
        sc.close();
    }
}
