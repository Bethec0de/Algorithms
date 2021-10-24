package algorithms.sorting;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * @author 42six, a CSC Company <BR>
 *         Created  8/6/13 6:52 PM<BR>
 */
public class InsertionSortTest {

    private Integer[] sortArray;
    private Integer[] copyOfPreSortedArray;


    @Before
    public void setUp(){
        Random generator = new Random();
        generator.setSeed(0);
        int randomInt = Integer.MIN_VALUE;
        sortArray = new Integer[100000];
        for (int i = 0; i<100000; i++){
            randomInt = generator.nextInt(1000000);
            sortArray[i] = randomInt;
        }

        copyOfPreSortedArray = sortArray.clone();
    }


    private void assertSorted(Integer[] input){
        int lastInt = Integer.MIN_VALUE;
        for(int currentInt : input){
            Assert.assertTrue(currentInt>=lastInt);
            //System.out.println("current:" + currentInt + " - last:" + lastInt);
            lastInt = currentInt;
        }
    }



    @Test
    public void testInsertionSort() throws Exception {
        long start, end;
        start = System.currentTimeMillis();
        //System.out.println("Starting Insertion InsertionSort at " + start);

        InsertionSort.insertionSort(sortArray);

        end = System.currentTimeMillis();
        //System.out.println("ending Insertion InsertionSort at " + end);
        System.out.println("InsertionSort took " + (end-start) + " milliseconds");
        assertSorted(sortArray);

    }


}
