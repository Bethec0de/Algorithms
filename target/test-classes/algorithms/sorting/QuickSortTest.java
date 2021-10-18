package algorithms.sorting;

import algorithms.sorting.QuickSort;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @author 42six, a CSC Company <BR>
 *         Created  8/18/13 2:01 PM<BR>
 */
public class QuickSortTest {

    private int[] sortArray;
    private int[] copyOfPreSortedArray;


    @Before
    public void setUp(){
        Random generator = new Random();
        generator.setSeed(0);
        int randomInt = Integer.MIN_VALUE;
        sortArray = new int[100000];
        for (int i = 0; i<100000; i++){
            randomInt = generator.nextInt(1000000);
            sortArray[i] = randomInt;
        }

        copyOfPreSortedArray = sortArray.clone();
    }


    private void assertSorted(int[] input){
        int lastInt = Integer.MIN_VALUE;
        for(int currentInt : input){
            Assert.assertTrue(currentInt>=lastInt);
            //System.out.println("current:" + currentInt + " - last:" + lastInt);
            lastInt = currentInt;
        }
    }



    @Test
    public void testQuickSort() throws Exception {
        long start, end;
        start = System.currentTimeMillis();
        //System.out.println("Starting QuickSort at " + start);



        QuickSort.quickSort(sortArray, 0, sortArray.length-1);

        end = System.currentTimeMillis();
        //System.out.println("ending QuickSort at " + end);
        System.out.println("QuickSort took " + (end-start) + " milliseconds");
        assertSorted(sortArray);

    }
}
