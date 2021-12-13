package codewars;

public class MultiplesOf3Or5 {
    public int solution(int number) {
        int sum = 0;
        boolean divisibleBy3, divisibleBy5;
        for (int i=1; i<number; i++){

            divisibleBy3 = Math.floorMod(i,3) == 0;
            divisibleBy5 = Math.floorMod(i,5) == 0;

            if(divisibleBy3 || divisibleBy5){
                sum += i;
            }
        }
        return sum;
    }
}
