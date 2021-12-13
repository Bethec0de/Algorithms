package algorithms.interviews;

import junit.framework.Assert;

public class IsAPrime {

    /**
     * Given an integer check to see if it is a Prime Number
     */
    static boolean isAPrime(int num){
        if(num < 1){
            return false;
        }
        for (int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] argv){
        Assert.assertEquals(true, isAPrime(269));
        Assert.assertEquals(false, isAPrime(121));
        Assert.assertEquals(false, isAPrime(-7));
    }

}
