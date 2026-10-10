package problems.assignment_problems;

import java.util.*;

abstract class Room {
    protected String type;
    protected int units;

    public Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    public abstract double calculateBill();

    public String getType() {
        return type;
    }
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super("SINGLE", units);
    }

    @Override
    public double calculateBill() {
        return 8 * units; // ₹8 per unit
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super("SHARED", units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (6 * units) / occupants; // ₹6 per unit, split among occupants
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super("AC", units);
    }

    @Override
    public double calculateBill() {
        return (10 * units) + 200; // ₹10 per unit + ₹200 fixed
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Room> rooms = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room room;
            if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else if (type.equals("AC")) {
                room = new ACRoom(units);
            } else {
                room = new SingleRoom(units);
            }

            rooms.add(room);
        }

        for (Room r : rooms) {
            double bill = r.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f\n", r.getType(), bill);
        }

        System.out.printf("Total: %.2f\n", total);
        sc.close();
    }
}