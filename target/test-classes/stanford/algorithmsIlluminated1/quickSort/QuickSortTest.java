package stanford.algorithmsIlluminated1.quickSort;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;


public class QuickSortTest {

    private long[] sortArray;
    private long[] copyOfPreSortedArray;


    @Before
    public void setUp(){
        Random generator = new Random();
        generator.setSeed(0);
        int randomInt = Integer.MIN_VALUE;
        sortArray = stanford.algorithmsIlluminated1.quickSort.QuickSort.readInFileArray();
        copyOfPreSortedArray = sortArray.clone();
    }


    private void assertSorted(long[] input){
        long lastInt = Integer.MIN_VALUE;
        for(long currentInt : input){
            Assert.assertTrue(currentInt>=lastInt);
            //System.out.println("current:" + currentInt + " - last:" + lastInt);
            lastInt = currentInt;
        }
    }



    @Test
    public void testQuickSort() throws Exception {
        long start, end;
        start = System.currentTimeMillis();
        System.out.println("Starting QuickSort at " + start);



        QuickSort.quickSort(sortArray, 0, sortArray.length-1);

        end = System.currentTimeMillis();
        System.out.println("ending QuickSort at " + end);
        System.out.println("QuickSort took " + (end-start) + " milliseconds");
        assertSorted(sortArray);
        System.out.printf("%d Comparisons made", QuickSort.comparisonCount);

    }
}
