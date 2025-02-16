import java.util.Scanner;

public class RecursiveProduct {
    //Recursive method that calculates the product of numbers, I will use the array structure in this instance.
    public static int product(int[] numbers, int index) {
        //Base case: If the index reaches 0, return the first element of the array.
        if (index == 0) {
            return numbers[0];
        }
        //Recursive case: Multiply the current element with the reuive call.
        return numbers[index] * product(numbers, index - 1);
    } 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        //Getting the user's input
        System.out.println("Hello, enter 5 numbers: ");
    }
}
