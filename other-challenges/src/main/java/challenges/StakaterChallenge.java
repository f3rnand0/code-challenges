package technical.challenges;

import java.util.HashSet;
import java.util.Set;

public class StakaterChallenge {

    public static void main(String[] args) {
        //StakaterChallenge.fizzBuzzFunction();
        System.out.println(StakaterChallenge.findPairOfNumbersSum2(new int[]{1, 2, 5, 7}, 8));
        System.out.println(StakaterChallenge.findPairOfNumbersSum2(new int[]{1, 4, 6, 9}, 13));
        System.out.println(StakaterChallenge.findPairOfNumbersSum2(new int[]{0, 2, 3, 4}, 5));
    }

    public static void fizzBuzzFunction() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static String findPairOfNumbersSum2(int[] array, int sum) {
        int difference = 0;
        Set<Integer> set = new HashSet<>();
        String result = "";
        for (int i = 0; i < array.length; i++) {
            set.add(sum - array[i]);
            if (set.contains(array[i])) {
                result = (sum - array[i]) + "," + array[i];
                return result;
            }
        }
        return result;
    }

    public static String findPairOfNumbersSum(int[] array, int sum) {
        // [5,2,1,7], 3
        // [5,2,1,7], 9   4, 2,1,7   7 1,7
        int leftPointer = 0, rightPointer = array.length - 1;
        String result = "";
        while (leftPointer < rightPointer) {
            int numbersSum = array[leftPointer] + array[rightPointer];
            if (numbersSum == sum) {
                result = array[leftPointer] + "," + array[rightPointer];
                break;
            } else if (numbersSum < sum) leftPointer++;
            else rightPointer--;
        }
        return result;
    }

}
