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
    private String testObject = "Hello";


    @Before
    public void setUp() {
        initialCapacity = 0;
        fixtureContents = fixture.create();
        modCapacity = 7;
    }

    @Test
    public void testCreate() {
        Assert.assertEquals(fixture.capacity(), initialCapacity);
    }

    @Test
    public void testCreateWithCapacity() {
        Assert.assertEquals(fixture.capacity(), initialCapacity);
        fixtureContents = fixture.createWithCapacity(modCapacity);
        Assert.assertEquals(fixture.capacity(), modCapacity);
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(fixture.capacity(), initialCapacity);
        fixture.add(testObject);
        Assert.assertEquals(fixture.capacity(), initialCapacity+1);
    }

    @Test
    public void testRemove() {
        testAdd();
        fixture.remove(testObject);
        Assert.assertEquals(fixture.capacity(), initialCapacity);
    }

    @Test
    public void testCapacity() {
        testCreate();
    }


}
