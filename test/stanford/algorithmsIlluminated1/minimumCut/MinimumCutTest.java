package stanford.algorithmsIlluminated1.minimumCut;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;


public class MinimumCutTest {

    private MinimunCut fixture;
    private HashMap adjacencyList;


    @Before
    public void setup() {
        fixture = new MinimunCut();
    }

    @Test
    public void testDetermineMinimumCut(){
        try{
            adjacencyList = fixture.readInFile();
            Assert.assertEquals(0,fixture.determineMinimumCut(adjacencyList));
        }
        catch(Exception ex){
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void testReadInFile(){
        try{
            HashMap testResult = fixture.readInFile();
            Assert.assertNotNull(testResult);
        }
        catch(Exception ex){
            Assert.fail(ex.getMessage());
        }

    }


    }
