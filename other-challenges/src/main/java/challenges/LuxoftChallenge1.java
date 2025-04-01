package technical.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LuxoftChallenge1 {

    // [3,2,5,8,9,12,2,54,2,65,78,80]
    // 2, return 3
    // 54, return 1

    // O(n) T
    public static int getOccurrences1(int[] array, int number) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                counter++;
            }
        }
        return counter;
    }

    public static void calculateSquaresEvenNumbers(List<Integer> array, int number) {
        array.stream().filter(n -> (n%2==0)).map(n -> n*n).collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }
}
