package string.assignment_problems;

public class TrafficSignalSimulator {
    public static void simulateTrafficSignal(int cycles) {
        String[] states = {"Red", "Green", "Yellow"};
        String[] meanings = {"Stop", "Go", "Prepare to stop"};

        for (int i = 0; i < cycles * 3; i++) {
            int stateIndex = i % 3;
            System.out.println(states[stateIndex] + " - " + meanings[stateIndex]);
        }
    }

    public static void main(String[] args) {
        simulateTrafficSignal(3);
    }
}