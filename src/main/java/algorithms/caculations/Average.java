package algorithms.caculations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Jon Thomas<BR>
 *         Created  4/29/14 6:05 PM<BR>
 */

public class Average {
    public String WeightedAverage(String tildeDelimitedListOfNumbers) {
        if(tildeDelimitedListOfNumbers == null){
            throw new IllegalArgumentException("tildeDelimitedListOfNumbers cannot be null");
        }
        else
        {
            ArrayList<Double> doubles = getNumbers(tildeDelimitedListOfNumbers);
            return String.valueOf(computeWeightedAverage(doubles));
        }
    }


    /**
     * Take a list of numbers, passed in as a String, convert them to An ArrayList of Doubles and Return
     * @param tildeDelimitedListOfNumbers
     * @return  ArrayList of Corresponding Doubles
     * @throws IllegalArgumentException if any of the passed in values are non numeric or outside the bounds of 0-100
     */
    private ArrayList<Double> getNumbers(String tildeDelimitedListOfNumbers){
        ArrayList<Double> doubles = new ArrayList<Double>();
        String[] stringNumbers = tildeDelimitedListOfNumbers.split("~");

        double validationVariable = 0;
        //for each entry in the passed in list, validate the entry is a number between 0 and 100
        for(String currentArgument: stringNumbers){
            try{
                validationVariable = Double.valueOf(currentArgument);
                if(validationVariable < 0 || validationVariable > 100){
                    throw new IllegalArgumentException();
                }
            }
            catch(Exception ex){
                throw new IllegalArgumentException("Please verify that all the passed in values are numbers between 0 and 100 (inclusive).");

            }

        }
        //now that we have validated the entries add each one to our ArrayList of Doubles
        for(String currentValue : stringNumbers){
            doubles.add(Double.valueOf(currentValue));
        }
        return doubles;
    }

    /**
     * Compute the weighted average of the numbers in the list by:
     * <ul>
     *     <li>Creating a list of each unique number that was passed in</li>
     *     <li>Adding them to a Map (as the key) and Determine the corresponding value as the number of occurrences of that number in the list</li>
     *     <li>Determine the weight of each number in the unique list as the ration of the number of times it appears in the list to the size of the complete list (of unique entries)</li>
     *     <li>
     *         For each element in the list
     *         <ul>
     *             <li>Multiply the number by its calculated weight</li>
     *             <li>add the proiduct of the two to the running total</li>
     *         </ul>
     *     </li>
     *     <li>After finishing the list the running total is the weighted average</li>
     * </ul>
     * @param doubles
     * @return the Weighted average of the items in the list
     */
    private double computeWeightedAverage(ArrayList<Double> doubles){
        HashMap<Double, Integer> uniqueNumbers = new HashMap<Double,Integer>();
        int currentCount;

        //create a map of each unique number passed in with a count of times it appears in the list
        for(double currentDouble : doubles){
            //if its already in the list increment the count
            currentCount= 1;
            if(uniqueNumbers.containsKey(currentDouble)){
                currentCount = uniqueNumbers.get(currentDouble);
                uniqueNumbers.put(currentDouble, ++currentCount);
            }
            //otherwise put it in with the initial count of 1
            else{
                uniqueNumbers.put(currentDouble,currentCount);
            }
        }
        //save the number of uniquew numbers in the list
        int countOfNumbers = doubles.size();
        double countOfValue = 0;
        double runningTotal = 0;
        double weight = 0;
        double currentValue = 0;
        double currentKey;
        List<Double> keys = new ArrayList(uniqueNumbers.keySet());

        //for each unique number
        for(int i = 0; i < keys.size(); i++){
            currentKey = keys.get(i);
            countOfValue = uniqueNumbers.get(currentKey).doubleValue();
            //Determine the weight of the unique number
            weight = (countOfValue/countOfNumbers);

            //multiply the count times the weight
            currentValue = currentKey * weight ;
            //add the currentValue to the running total
            runningTotal = runningTotal + currentValue;

        }
        double finalValue = runningTotal;
        return finalValue;
    }

}
