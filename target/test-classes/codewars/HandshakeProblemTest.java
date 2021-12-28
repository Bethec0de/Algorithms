package codewars;

import junit.framework.TestCase;
import org.junit.Assert;

public class HandshakeProblemTest extends TestCase {

    private HandshakeProblem fixture;


    public void setUp(){
        fixture = new HandshakeProblem();
    }

    public void testMinimumPeopleToMakeHandshakeCount(){
        System.out.printf("Testing that we get %d from %d \n",1,0);
        Assert.assertEquals(1, fixture.minPeople(0) );
        System.out.printf("Testing that we get %d from %d \n",2,1);
        Assert.assertEquals(2, fixture.minPeople(1) );
        System.out.printf("Testing that we get %d from %d \n",3,3);
        Assert.assertEquals(3, fixture.minPeople(3) );
        System.out.printf("Testing that we get %d from %d \n",4,6);
        Assert.assertEquals(4, fixture.minPeople(6) );
        System.out.printf("Testing that we get %d from %d \n",5,7);
        Assert.assertEquals(5, fixture.minPeople(7) );

    }

}
