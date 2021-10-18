package stanford.algorithmsIlluminated1.countInversions;

import junit.framework.Assert;
import org.junit.Before;

public class InversionCounterTest {

    public long[] baseFixture;
    public long[] complexFixture;
    private InversionCounter objectUnderTest;
    public long expectedBaseValue, expectedComplexValue;


    @Before
    public void setup(){
        objectUnderTest = new InversionCounter();
        complexFixture = objectUnderTest.readInFileArray();
        baseFixture = new long[]{1,3,5,2,4,6};
        expectedBaseValue = 3;
        expectedComplexValue = 2407905288L;
    }

    @org.junit.Test
    public void testBruteForceBase(){
        try{
            long returnValue = objectUnderTest.BruteForce(baseFixture);
            Assert.assertEquals(expectedBaseValue, returnValue);
            System.out.format("Success, expected %d, got %d!!\n", expectedBaseValue, returnValue, returnValue);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            Assert.fail("Brute Force Base Test Failed on Exception");
        }
    }

    @org.junit.Test
    public void testBruteForceComplex(){
        try{
            long returnValue = objectUnderTest.BruteForce(complexFixture);
            Assert.assertEquals(expectedComplexValue, returnValue);
            System.out.format("Success, expected %d, got %d!!\n", expectedComplexValue, returnValue, returnValue);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            Assert.fail("Brute Force Complex Test Failed on Exception");
        }
    }



    @org.junit.Test
    public void testAsNLogNBase(){
        try{
            long returnValue = objectUnderTest.AsNLogN(baseFixture);
            Assert.assertEquals(expectedBaseValue, returnValue);
            System.out.format("Success, expected %d, got %d!!\n", expectedBaseValue, returnValue, returnValue);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            Assert.fail("AsNLogN Base Test Failed on Exception");
        }
    }

    @org.junit.Test
    public void testAsNLogNComplex(){
        try{
            long returnValue = objectUnderTest.AsNLogN(complexFixture);
            Assert.assertEquals(expectedComplexValue, returnValue);
            System.out.format("Success, expected %d, got %d!!\n", expectedComplexValue, returnValue);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            Assert.fail("AsNLogN Complex Test Failed on Exception");
        }
    }


}
