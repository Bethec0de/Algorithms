package algorithms.sorting;

import junit.framework.Assert;
import org.junit.Before;

import java.util.Random;

/**
 * @author JT <BR>
 *   Added 18 Oct 2021<BR>
 */
public class MergeSortTest {

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


/*
    @Test
    public void testMergeSort() throws Exception {
        long start, end;
        start = System.currentTimeMillis();
        //System.out.println("Starting MergeSort at " + start);



        MergeSort.mergeSort(new int[]{5,1,3,6,2,7,4,9,8});

        end = System.currentTimeMillis();
        //System.out.println("ending MergeSort at " + end);
        System.out.println("MergeSort took " + (end-start) + " milliseconds");
        assertSorted(sortArray);

    }

 */
}
