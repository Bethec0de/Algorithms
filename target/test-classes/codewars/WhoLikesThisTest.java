package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhoLikesThisTest {
    @Test
    public void staticTests() {
        assertEquals("no one likes this", WhoLikesThis.whoLikesIt(null));
        assertEquals("no one likes this", WhoLikesThis.whoLikesIt());
        assertEquals("Peter likes this", WhoLikesThis.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", WhoLikesThis.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", WhoLikesThis.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesThis.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}
