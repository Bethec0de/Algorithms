/**
 * Created with IntelliJ IDEA.
 * User: Jt
 * Date: 10/23/12
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */

package algorithms.interviews;


import java.util.HashMap;
import java.util.TreeMap;

public class AlgorithmFixture {


    //1.2
    public String reverseString(String stringToReverse){
        char[] charsInString = stringToReverse.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int counter = stringToReverse.length()-1; counter >=0; counter--){
            sb.append(charsInString[counter]);
        }

        return sb.toString();
    }


    //1.1
    public boolean StringHasAllUniqueCharacters(String stringToTest){
        boolean returnMe = true;
        HashMap<Integer,Character> mapOfUniqueCharacters = new HashMap<Integer,Character>();
        char[] charsInString = stringToTest.toCharArray();
        Character currentChar = null;
        for(int i = 0; i <= charsInString.length-1; i++){
            currentChar = charsInString[i];
            if(mapOfUniqueCharacters.containsValue(currentChar)){
                returnMe = false;
                break;
            }
            else{
                mapOfUniqueCharacters.put(i,currentChar);
                continue;
            }
        }
        return returnMe;
    }

    //1.4
    public String replaceSpacesWithAscii(String stringToReplace){
        return stringToReplace.replaceAll(" ", "%20");
    }

    //1.5
    public String compressStringWithCharacterCount(String stringToCompress){
        TreeMap<Character, Integer> characters = new TreeMap<Character, Integer>();
        char[] stringAsArray = stringToCompress.toCharArray();
        //for each unique (enforced by the key) character in the string, add a value to the hashmap
        for(char currentChar:stringAsArray){
            if(!characters.containsKey(currentChar)){
                characters.put(currentChar,0);
            }
        }
        //now add up the number of occurrences of each character in the string and make it the map value
        int currentValue = 0;
        for(char currentChar:stringAsArray){
            currentValue = characters.get(currentChar).intValue();
            characters.put(currentChar,currentValue+1);
        }

        //now add the value directly after the first occurrence of each letter in the string
        int indexOfChar = 0;
        StringBuilder sb = new StringBuilder();
        for(Character currentChar:characters.keySet()){
            indexOfChar = stringToCompress.indexOf(currentChar);
            sb.append(currentChar);
            sb.append(characters.get(currentChar).intValue());
        }

        if(sb.length()>=stringToCompress.length()){
            return  stringToCompress;
        }
        else{
            return sb.toString();
        }
    }


}
