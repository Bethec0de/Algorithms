package algorithms.interviews;

import junit.framework.Assert;
import junit.framework.TestCase;

public class AmazonFibonacciTest extends TestCase {


    private int[] fibonacciSequence;
    private AmazonFibonacci fixture;

    public void setUp() throws Exception {
        super.setUp();
        fibonacciSequence = new int[]{0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811};
        fixture = new AmazonFibonacci();
    }


    public void testGetFibonacci(){
        try{
            int returnValue = Integer.MIN_VALUE;
            for(int i = 0; i < fibonacciSequence.length; i++){
                returnValue = fixture.getFibonacci(i);
                Assert.assertEquals("For index " + i + " expected value " + fibonacciSequence[i] + " but received " + returnValue, fibonacciSequence[i], returnValue);
                System.out.println("Index[" + i + "]; value[" + returnValue + "]");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
            Assert.fail(ex.getMessage());
        }

    }

    public void tearDown() throws Exception {

    }

}