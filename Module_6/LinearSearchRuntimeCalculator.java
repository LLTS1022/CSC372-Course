import java.util.Scanner;

public class LinearSearchRuntimeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the number of elements in the list
        System.out.print("Enter the number of elements in the list: ");
        long n = scanner.nextLong();

        // Each comparison takes 1 microsecond (worst-case checks all elements)
        long estimatedTimeMicroseconds = n;

        // Display result
        System.out.println("Estimated worst-case runtime for linear search: " 
                           + estimatedTimeMicroseconds + " µs");

        scanner.close();
    }
}
