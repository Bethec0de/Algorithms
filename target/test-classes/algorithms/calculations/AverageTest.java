package algorithms.calculations;

import algorithms.caculations.Average;
import junit.framework.Assert;
import org.junit.Before;

/**
 * @author Jon Thomas <BR>
 *         Created  5/8/14 8:15 AM<BR>
 */
public class AverageTest {


    public String numbersToAverage;
    private Average average;
    public double expectedValue;


    @Before
    public void setup(){
        average = new Average();
        numbersToAverage = "1~10~15~15~15~15~15~100";
        expectedValue = 23.25;
    }

    @org.junit.Test
    public void testWeightedAverage(){
        try{
            double returnValue = Double.parseDouble(average.WeightedAverage(numbersToAverage));
            Assert.assertEquals(returnValue,expectedValue);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            Assert.fail("Weighted Average Test Failed on Exception");
        }
    }


}
