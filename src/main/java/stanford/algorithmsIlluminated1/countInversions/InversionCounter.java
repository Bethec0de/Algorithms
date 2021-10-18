package stanford.algorithmsIlluminated1.countInversions;

import com.google.common.primitives.Longs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InversionCounter {

    /*
    Implementation in n^2 where first loop is n and there are n combinations to test (n*n = n^2)
    Quadratic performance
     */
    public long BruteForce(long[] input){
        long output = 0;
        for (int i = 0; i< input.length; i++){
            for (int j = i+1; j< input.length; j++){
                if(input[i] > input[j]){
                    output++;
                }
            }
        }
        return output;
    }

    /*
    Implementation of Divide and conquer can make this perform in O(n log n)
     */
    public long AsNLogN(long[] input){
        long leftOutput = 0, rightOutput = 0, splitOutput = 0, output = 0;
        long[] left, right, split;

        //test for base case and exit
        if(input.length > 1){
            left = Arrays.copyOfRange(input,0, input.length/2);
            right = Arrays.copyOfRange(input, input.length/2, input.length);
            output = AsNLogN(left) + AsNLogN(right) + merge(input, left, right);
        }
        return output;
    }

    /*
    Use Mergersort approach to get the count of inversions in the array while handling inversions that cross into different subsets
    This is almost normal merge sort, the whole magic is hidden in merge function.
    Note that while sorting algorithm remove inversions.
    While merging algorithm counts number of removed inversions (sorted out one might say).
    The only moment when inversions are removed is when algorithm takes element from the right side of an array and merge it to the main array.
    The number of inversions removed by this operation is the number of elements left from the the left array to be merged.
     */
    long merge(long[] arr, long[] left, long[] right) {
        int leftElement = 0, rightElement = 0;
        long inversionCount = 0;
        while (leftElement < left.length || rightElement < right.length) {
            if (leftElement == left.length) {
                arr[leftElement+rightElement] = right[rightElement];
                rightElement++;
            } else if (rightElement == right.length) {
                arr[leftElement+rightElement] = left[leftElement];
                leftElement++;
            } else if (left[leftElement] <= right[rightElement]) {
                arr[leftElement+rightElement] = left[leftElement];
                leftElement++;
            } else {
                arr[leftElement+rightElement] = right[rightElement];
                inversionCount += left.length-leftElement;
                rightElement++;
            }
        }
        return inversionCount;
    }


    long[] readInFileArray(){
        ArrayList<Long> result = new ArrayList<Long>();
        long[] output;
        try (Scanner s = new Scanner(new FileReader("/Users/jonthomas/source/Algorithms/src/main/java/stanford/algorithmsIlluminated1/countInversions/IntegerArray.txt"))) {
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
