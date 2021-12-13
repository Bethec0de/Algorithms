package codewars;

/**
 * Digital root is the recursive sum of all the digits in a number.
 *
 * Given n, take the sum of the digits of n.
 * If that value has more than one digit, continue reducing in this way until a single-digit number is produced.
 * The input will be a non-negative integer.
 * The digital root of a number is equal to the remainder when that number is divided by 9.
 * If the remainder is 0 and the number is greater than 0, then the digital root is 9. ...
 * For example, the digital root of the number 12,345 is 6 because 1 + 2 + 3 + 4 + 5 equals 15 and then 1 + 5 equals 6.

 */
public class DigitalRoot {
    public static int digital_root(int n) {
        //return the remainder of n divided by 9 + 1
        return (n - 1) % 9 + 1;
    }
}
