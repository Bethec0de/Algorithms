package codewars;

public class Trolls {
    public static String disemvowel(String str) {
        if (str == null) return "";
        char[] vowels = new char[]{'A','a','E','e','I','i','O','o','U','u'};
        for (char vowel: vowels){
            str = str.replace(""+vowel,"");
        }
        return str;
    }
}