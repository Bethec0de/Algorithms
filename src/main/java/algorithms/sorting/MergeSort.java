package algorithms.sorting;


/**
*   MERGE-SORT A[1 . . n]
*      1.If n= 1, done.
*      2.Recursively sort A[ 1 . . ⎡n/2⎤]
*       and A[ ⎡n/2⎤+1 . . n ] .
*      3.“Merge”the 2sorted lists.
 */
public class MergeSort {




    //given an array of whole numbers
    //split in half until each array is only 2
    //sort each array
    //merge and sort each array until you are back to the original size


    private static int[] originalArray, finalArray;
    private static int countOfNumbers;

  /*  public static int[] mergeSort(int[] num){

        if(num.length <= 1){
            return num;
        }
        else{
            int low = 0;
            int high = num.length -1;
            //split the array in half
            //recursively call for each half (a,b)
            //merge the two
                /*int mid = high/2;
                mergeSort(num, low, mid);
                mergeSort(num, mid+1, high);
                merge(low, mid, high);
            }
        }
    }

    public static void mergeSort(int low, int high) {
        if (high <= low) ;

        int mid = (low+high)/2;
/*        mergeSort(low, mid);
        mergeSort(mid+1, high);
        merge(low, mid, high);
    }

    /*private static void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            finalArray[i] = originalArray[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (finalArray[i] <= finalArray[j]) {
                originalArray[k] = finalArray[i];
                i++;
            } else {
                originalArray[k] = finalArray[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            originalArray[k] = finalArray[i];
            k++;
            i++;
        }

    }*/

}
