package problems.class_problems;

import java.util.*;

abstract class Plot {
    protected String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public abstract double calculateArea();
    public abstract String getShapeType();

    public String getOwner() { return owner; }
}

class CircularPlot extends Plot {
    private double radius;

    public CircularPlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShapeType() { return "CIRCLE"; }
}

class RectangularPlot extends Plot {
    private double length, width;

    public RectangularPlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getShapeType() { return "RECTANGLE"; }
}

class TriangularPlot extends Plot {
    private double base, height;

    public TriangularPlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShapeType() { return "TRIANGLE"; }
}

public class GardenPlotReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Plot> plots = new ArrayList<>();
        double totalArea = 0.0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();

            Plot plot = null;
            switch (shape) {
                case "CIRCLE":
                    double r = sc.nextDouble();
                    plot = new CircularPlot(owner, r);
                    break;
                case "RECTANGLE":
                    double l = sc.nextDouble();
                    double w = sc.nextDouble();
                    plot = new RectangularPlot(owner, l, w);
                    break;
                case "TRIANGLE":
                    double b = sc.nextDouble();
                    double h = sc.nextDouble();
                    plot = new TriangularPlot(owner, b, h);
                    break;
            }

            if (plot != null) {
                plots.add(plot);
            }
        }

        for (Plot p : plots) {
            double area = p.calculateArea();
            totalArea += area;
            System.out.printf("%s(%s): %.2f\n", p.getOwner(), p.getShapeType(), area);
        }

        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}
