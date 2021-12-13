package codewars;

public class Maskify {
    public static String maskify(String str) {
        if (str == null){
            throw new IllegalArgumentException("Input string cannot be null");
        }
        char[] chars = str.toCharArray();
        int strLen = chars.length;
        for (int i = 0; i <= chars.length; i++) {
            if (i< chars.length-4){
                chars[i] = '#';
            }
        }
        return String.valueOf(chars);
    }
}