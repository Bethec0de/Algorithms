package algorithms.interviews;

import junit.framework.TestCase;
import org.junit.Assert;

public class FacebookQuestionsTest extends TestCase {
/*
Input: ((( Return: 3
Input: ()) Return: 1
Input: (()) Return: 0
Input: )( Return: 2
*/
    private String fixtureReturn3, fixtureReturn1, fixtureReturn0, fixtureReturn2;
    private String fixtureSortInput, fixtureSortOrder, fixtureSortReturn;
    FacebookQuestions fixture;

    public void setUp(){
        fixture = new FacebookQuestions();
        }

    public void testReturnNumberToBalance(){
        try{
            fixtureReturn0 = "(())";
            fixtureReturn1 = "())";
            fixtureReturn2 = ")(";
            fixtureReturn3 = "(((";
            Assert.assertEquals(0,fixture.returnNumberToBalance(fixtureReturn0));
            Assert.assertEquals(3,fixture.returnNumberToBalance(fixtureReturn3));
            Assert.assertEquals(1,fixture.returnNumberToBalance(fixtureReturn1));
            Assert.assertEquals(2,fixture.returnNumberToBalance(fixtureReturn2));

        }
        catch(Exception ex){
            System.out.printf("Testcase failed with %s:%s", ex.toString(), ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void testReturnCustomOrderSort(){
        try{
            fixtureSortInput = "abcab";
            fixtureSortOrder = "bca";
            fixtureSortReturn = "bbcaa";
            Assert.assertEquals("", fixture.returnCustomOrderSort(fixtureSortInput, fixtureSortOrder));
        }
        catch(Exception ex){
            System.out.printf("Testcase failed with %:%", ex.getMessage());
            ex.printStackTrace();
        }
    }

}
