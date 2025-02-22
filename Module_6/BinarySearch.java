import java.io.*;

class BinarySearch {
  
    // Returns index of x if it is present in arr[], along with iteration count
    int binarySearch(int arr[], int x)
    {
        int low = 0, high = arr.length - 1;
        int iterations = 0; // Counter to count the number of iterations

        while (low <= high) {
            iterations++; // Increment counter each iteration
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (arr[mid] == x) {
                System.out.println("Number of iterations: " + iterations);
                return mid;
            }

            // If x greater, ignore left half
            if (arr[mid] < x)
                low = mid + 1;

            // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was not present
        System.out.println("Number of iterations: " + iterations);
        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 1, 3, 7, 9, 12, 15, 18, 21, 25, 28, 30, 33, 37, 40, 42, 45, 48, 50, 53, 55, 
            58, 60, 63, 67, 70, 72, 75, 78, 80, 83, 85, 88, 90, 93, 97, 100, 103, 105, 108, 
            110, 113, 115, 118, 120, 123, 125, 128, 130, 133, 137, 140, 143, 145, 148, 150, 
            153, 157, 160, 163, 165, 168, 170, 173, 175, 178, 180, 183, 185, 188, 190, 193, 
            195, 198, 200, 203, 207, 210, 213, 215, 218, 220, 223, 225, 228, 230, 233, 235, 
            238, 240, 243, 245, 248, 250, 253, 255, 258, 260, 263, 265, 268, 270, 273, 275, 
            278, 280, 283, 285, 288, 290, 293, 295, 298, 300 };
        int x = 150;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }
}
