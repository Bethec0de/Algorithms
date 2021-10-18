package datastructures;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;


public class SetTest {

    public static final String NOT_IMPLEMENTED = "Test not yet Implemented";

    private int initialCapacity;
    private Set fixture;
    private Object[] fixtureContents;
    private int modCapacity;
    private final String testObject = "Hello";


    @Before
    public void setUp() {
        initialCapacity = 0;
        fixtureContents = Set.create();
        modCapacity = 7;
    }

    @Test
    public void testCreate() {
        Assert.assertEquals(Set.capacity(), initialCapacity);
    }

    @Test
    public void testCreateWithCapacity() {
        Assert.assertEquals(Set.capacity(), initialCapacity);
        fixtureContents = Set.createWithCapacity(modCapacity);
        Assert.assertEquals(Set.capacity(), modCapacity);
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(Set.capacity(), initialCapacity);
        Set.add(testObject);
        Assert.assertEquals(Set.capacity(), initialCapacity+1);
    }

    @Test
    public void testRemove() {
        testAdd();
        Set.remove(testObject);
        Assert.assertEquals(Set.capacity(), initialCapacity);
    }

    @Test
    public void testCapacity() {
        testCreate();
    }


}
