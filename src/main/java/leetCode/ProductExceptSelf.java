package leetCode;

import org.junit.Assert;

public class ProductExceptSelf {
    //problem O(N)
        public int[] productExceptSelf(int[] nums) {
            int[] answers = new int[nums.length];
            int currentProduct = 0;
            int currentIndex = 0;
            for(int currentNum: nums){
                //dont get the product of self
                if(nums[currentIndex] == currentNum){
                    currentIndex++;
                    continue;
                }
                else{
                    currentProduct = (currentProduct== 0)?currentNum: currentProduct * currentNum;
                    currentIndex++;
                }
                answers[currentIndex] = currentProduct;
            }
            return answers;
        }

        public boolean testProductExceptSelf(){
            int[] fixtureNums = new int[]{1,2,3,4,5};
            int[] answerNums = new int[]{100,60,40,30,24};
            Assert.assertArrayEquals(answerNums,productExceptSelf(fixtureNums));
            return true;
        }

        public static void main(String[] argv){
            System.out.println("Result is " + new ProductExceptSelf().testProductExceptSelf());
        }

    }
