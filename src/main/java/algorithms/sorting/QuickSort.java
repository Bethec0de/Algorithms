package algorithms.sorting;

/**
*   QUICKSORT(A, p, r)
*   if p< r
*    then q←PARTITION(A, p, r)
*       QUICKSORT(A, p, q–1)
*       QUICKSORT(A, q+1, r)
*/
public class QuickSort  {
    private static Integer[] numbers;
    private static Integer number;


    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }


}
