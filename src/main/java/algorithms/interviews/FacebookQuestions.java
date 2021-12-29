package algorithms.interviews;

import java.util.Arrays;
import java.util.Stack;

public class FacebookQuestions {
/*
Return the number of parens needed to close the statement in a balanced way (order is important).
Input: ((( Return: 3
Input: ()) Return: 1
Input: (()) Return: 0
Input: )( Return: 2
*/
    //todo:Fails on usecase for 2 because of the order of open and closed parens
    public int returnNumberToBalance(String input){
        int returnCounter = 0;
        int countOPen= 0, countClosed = 0;
        Stack<Character> workingStack = new Stack<>();
        if (input == ""){
            return 0;
        }
        for (char c : input.toCharArray()){
            //evaluate how many need to be added to balance
            if(c == '(') {
                workingStack.push(c);
                returnCounter++;
            }
            else{
                if(!workingStack.isEmpty()){
                    workingStack.pop();
                }
                returnCounter--;
            }
        }
        return Math.abs(returnCounter);
    }

    /*
    input: abcab
    order: bca
    return: bbcaa
    */
    public String returnCustomOrderSort(String toSort, String order){
        char[] workingArray = toSort.toCharArray();

        char[] orders = order.toCharArray();

        Arrays.sort(workingArray);
        System.out.println(String.valueOf(workingArray));
        return "";
    }
}