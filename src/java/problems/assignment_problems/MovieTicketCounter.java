package problems.assignment_problems;

import java.util.*;

abstract class Ticket {
    protected int count;
    private static final double CONVENIENCE_FEE = 20.0; // Written in ONE place only

    public Ticket(int count) {
        this.count = count;
    }

    // Template Method: Final so subclasses cannot change how the total is composed
    public final double calculateTotal() {
        return (getPricePerTicket() * count) + (CONVENIENCE_FEE * count);
    }

    protected abstract double getPricePerTicket();
    public abstract String getType();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) { super(count); }
    @Override
    protected double getPricePerTicket() { return 150.0; }
    @Override
    public String getType() { return "REGULAR"; }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) { super(count); }
    @Override
    protected double getPricePerTicket() { return 250.0; }
    @Override
    public String getType() { return "PREMIUM"; }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) { super(count); }
    @Override
    protected double getPricePerTicket() { return 400.0; }
    @Override
    public String getType() { return "RECLINER"; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Ticket> tickets = new ArrayList<>();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            Ticket t = null;
            if (type.equals("REGULAR")) t = new RegularTicket(count);
            else if (type.equals("PREMIUM")) t = new PremiumTicket(count);
            else if (type.equals("RECLINER")) t = new ReclinerTicket(count);

            if (t != null) tickets.add(t);
        }

        for (Ticket t : tickets) {
            double total = t.calculateTotal();
            grandTotal += total;
            System.out.printf("%s: %.2f\n", t.getType(), total);
        }
        System.out.printf("Total: %.2f\n", grandTotal);
        sc.close();
    }
}