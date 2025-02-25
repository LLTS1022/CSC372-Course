//This file contains the selection sort algorithm. It takes an arraylist and a comparator as arguments and then sorts the list based on th given comparator.
import java.util.ArrayList;
import java.util.Comparator;

public class SelectionSort {
    public static <T> void selectionSort(ArrayList<T> list, Comparator<? super T> comp) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (comp.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
      
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }
}
