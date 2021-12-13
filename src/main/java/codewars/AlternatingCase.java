package codewars;

public class AlternatingCase {

    public static String toAlternativeString(String string) {
        //iterate over each character in the string
        char[] worker = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char current : worker) {
            if (Character.isUpperCase(current)) {
                sb.append(String.valueOf(current).toLowerCase());
            } else {
                sb.append(String.valueOf(current).toUpperCase());
            }
        }
        return sb.toString();
    }
}