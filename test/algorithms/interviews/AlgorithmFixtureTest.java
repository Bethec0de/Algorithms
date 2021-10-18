package algorithms.interviews;

/**
 * Created with IntelliJ IDEA.
 * User: Jt
 * Date: 10/23/12
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AlgorithmFixtureTest {

    private AlgorithmFixture fixture;
    private final String stringToReverse = "Now is the time for all good men to come to the aide of their country.";
    private final String stringWithAsciiSpaces = "Now%20is%20the%20time%20for%20all%20good%20men%20to%20come%20to%20the%20aide%20of%20their%20country.";
    private final String orderReversed = ".yrtnuoc rieht fo edia eht ot emoc ot nem doog lla rof emit eht si woN";
    private final String uniqueCharactersPositive = "swarmed";
    private final String stringToCompress = "aaabcccccddeefffffffggg";
    private final String compressedString = "a3b1c5d2e2f7g3";
    private final String noCompressionString = "abcdefg";


    @Before
    public void setUp(){
        fixture = new AlgorithmFixture();
    }




    @Test
    public void TestReverseString(){
        Assert.assertTrue(fixture.reverseString(stringToReverse).equals(orderReversed));
    }

    @Test
    public void TestStringHasAllUniqueCharacters(){
        Assert.assertTrue("Expected:true - Got:" + fixture.StringHasAllUniqueCharacters(uniqueCharactersPositive),fixture.StringHasAllUniqueCharacters(uniqueCharactersPositive));
        Assert.assertFalse("Expected:true - Got:" + fixture.StringHasAllUniqueCharacters(uniqueCharactersPositive),fixture.StringHasAllUniqueCharacters(stringToReverse));
    }

    @Test
    public void TestReplaceSpacesWithAscii(){
        Assert.assertEquals("Expected " + stringWithAsciiSpaces + ": - Got " + fixture.replaceSpacesWithAscii(stringToReverse),fixture.replaceSpacesWithAscii(stringToReverse),stringWithAsciiSpaces);
    }

    @Test
    public void TestCompressStringWithCharacterCount(){
        Assert.assertEquals(fixture.compressStringWithCharacterCount(stringToCompress),compressedString);
        Assert.assertEquals(fixture.compressStringWithCharacterCount(fixture.compressStringWithCharacterCount(noCompressionString)),noCompressionString);

    }


}
