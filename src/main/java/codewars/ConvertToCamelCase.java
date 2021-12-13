package codewars;

/**
 * Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
 *
 * Examples
 * "the-stealth-warrior" gets converted to "theStealthWarrior"
 * "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
 */
class ConvertToCamelCase{
    static String toCamelCase(String s) {
        String[] dashless = s.split("-");
        String[] underscoreLess = s.split("_");
        StringBuilder finalString = new StringBuilder();

        if(dashless.length == 0 && underscoreLess.length == 0) return s;
        if (dashless.length > 0 ) {
            finalString = uppercaseFirstLetter(dashless);
            underscoreLess = finalString.toString().split("_");
        }

        if(underscoreLess.length > 0){
            finalString = uppercaseFirstLetter(underscoreLess);
        }
        return finalString.toString();
    }

    static StringBuilder uppercaseFirstLetter(String[] splitString) {
        String word;
        StringBuilder sb = new StringBuilder();
        if (splitString.length > 0) {
            sb.append(splitString[0]);
            for (int i = 1; i < splitString.length; i++) {
                word = splitString[i].substring(0,1).toUpperCase() + splitString[i].substring(1);
                sb.append(word);
            }
        }
        return sb;
    }
}
