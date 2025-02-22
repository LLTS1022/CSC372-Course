import java.util.Scanner;

public class BinarySearchRuntimeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the number of elements in the list: ");
        long n = scanner.nextLong();

        // Calculate log2(n) to determine the number of comparisons
        double logBase2 = (Math.log(n) / Math.log(2));

        // Each comparison takes 1 microsecond
        long estimatedTimeMicroseconds = Math.round(logBase2);   // Each comparison takes 1 microsecond
        //long estimatedTimeMicroseconds = Math.round(logBase2) + 1; // Adding 1 to account for worst-case extra check (this checks for worst-case scenario)

        // Display results
        System.out.println("Estimated worst-case runtime for binary search: " 
                           + estimatedTimeMicroseconds + " µs");

        scanner.close();
    }
}
