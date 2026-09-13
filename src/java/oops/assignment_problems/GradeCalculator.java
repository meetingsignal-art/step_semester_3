package oops.assignment_problems;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    char calculateGrade() {
        if (marks >= 90) return 'A';
        if (marks >= 80) return 'B';
        if (marks >= 70) return 'C';
        if (marks >= 60) return 'D';
        return 'F';
    }

    void displayResult() {
        System.out.println(name + ": Marks=" + marks + ", Grade=" + calculateGrade());
    }
}

public class GradeCalculator {
    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 85);
        Student s2 = new Student("Anita", 92);
        s1.displayResult();
        s2.displayResult();
    }
}