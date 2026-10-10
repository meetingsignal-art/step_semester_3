package problems.class_problems;

import java.util.*;

abstract class ElectricityConnection {
    protected int units;

    public ElectricityConnection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class HomeConnection extends ElectricityConnection {
    public HomeConnection(int units) { super(units); }

    @Override
    public double calculateBill() {
        if (units <= 100) return units * 5.0;
        else return (100 * 5.0) + ((units - 100) * 7.0);
    }

    @Override
    public String getType() { return "HOME"; }
}

class ShopConnection extends ElectricityConnection {
    public ShopConnection(int units) { super(units); }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }

    @Override
    public String getType() { return "SHOP"; }
}

class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(int units) { super(units); }

    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }

    @Override
    public String getType() { return "FACTORY"; }
}

public class ElectricityBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<ElectricityConnection> connections = new ArrayList<>();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            ElectricityConnection conn = null;
            switch (type) {
                case "HOME": conn = new HomeConnection(units); break;
                case "SHOP": conn = new ShopConnection(units); break;
                case "FACTORY": conn = new FactoryConnection(units); break;
            }

            if (conn != null) connections.add(conn);
        }

        for (ElectricityConnection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f\n", c.getType(), bill);
        }

        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}