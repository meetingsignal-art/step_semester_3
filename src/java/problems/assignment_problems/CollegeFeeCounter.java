package problems.assignment_problems;

import java.util.*;

abstract class Student {
    protected String name;
    private static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) { this.name = name; }

    public final double calculateTotalFee() {
        double tuition = getTuition();
        if (usesBus()) {
            tuition += TRANSPORT_FEE;
        }
        return tuition;
    }

    protected abstract double getTuition();
    protected abstract boolean usesBus();
    public String getName() { return name; }
}

class DayScholar extends Student {
    public DayScholar(String name) { super(name); }
    @Override
    protected double getTuition() { return 40000.0; }
    @Override
    protected boolean usesBus() { return true; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    @Override
    protected double getTuition() { return 40000.0 + 60000.0; }
    @Override
    protected boolean usesBus() { return false; }
}

class Scholar extends Student {
    public Scholar(String name) { super(name); }
    @Override
    protected double getTuition() { return 20000.0; }
    @Override
    protected boolean usesBus() { return true; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Student> students = new ArrayList<>();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s = null;
            if (type.equals("DAY_SCHOLAR")) s = new DayScholar(name);
            else if (type.equals("HOSTELLER")) s = new Hosteller(name);
            else if (type.equals("SCHOLAR")) s = new Scholar(name);
            if (s != null) students.add(s);
        }

        for (Student s : students) {
            double fee = s.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", s.getName(), fee);
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
        sc.close();
    }
}