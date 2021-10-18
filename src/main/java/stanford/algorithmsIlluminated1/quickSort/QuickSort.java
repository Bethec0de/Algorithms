package stanford.algorithmsIlluminated1.quickSort;

import com.google.common.primitives.Longs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
*   QUICKSORT(A, p, r)
*   if p< r
*    then q←PARTITION(A, p, r)
*       QUICKSORT(A, p, q–1)
*       QUICKSORT(A, q+1, r)
*/
public class QuickSort {
    private static long[] numbers;
    private static long number;
    public static long comparisonCount = 0;

    public static void quickSort(long[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    /*partition around the last element in the array into 2 arrays
    where array 1 has all elements less than the pivot and array 2
    has all elements greater
    * */
    private static int partition(long[] arr, int begin, int end) {
        long pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                long swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        long swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        comparisonCount += end-1;
        return i+1;
    }

    public static long[] readInFileArray(){
        ArrayList<Long> result = new ArrayList<Long>();
        long[] output;
        try (Scanner s = new Scanner(new FileReader("/Users/jonthomas/source/Algorithms/src/main/java/stanford/algorithmsIlluminated1/quickSort/quickSort.txt"))) {
            while (s.hasNextLong()) {
                result.add(s.nextLong());
            }
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        return Longs.toArray(result);
    }
}
