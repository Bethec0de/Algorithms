package algorithms.sorting;

/**

 *  INSERTION-SORT (A, n)⊳A[1 . . n]
 *      for j ←2 to n
 *          dokey ←A[ j]
 *              i ←j –1
 *              whilei > 0 and A[i] > key
 *                  do A[i+1] ←A[i]
 *                      i ←i –1
 *              A[i+1] = key“
*/
public class InsertionSort {


    public static void insertionSort(Integer[] input){
        int currentInt, currentInnerInt, innerCounter;
        for(int counter = 1; counter < input.length; counter++){
            currentInt = input[counter];
            for(innerCounter = (counter-1); (innerCounter >=0 && currentInt < input[innerCounter]); innerCounter--){
                input[innerCounter+1] = input[innerCounter];
            }
            input[innerCounter+1] = currentInt;
        }
    }


}
