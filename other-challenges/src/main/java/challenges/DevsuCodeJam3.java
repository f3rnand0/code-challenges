package technical.challenges;

import java.util.Arrays;

public class DevsuCodeJam3 {

    public static void main(String[] args) {
        System.out.println("maximumSumPoints:" +
                           DevsuCodeJam3.maximumSumPoints(
                                   new int[]{1, 2}));
        System.out.println("maximumSumPoints:" +
                           DevsuCodeJam3.maximumSumPoints(
                                   new int[]{2, 1, 3}));
        System.out.println("maximumSumPoints:" +
                           DevsuCodeJam3.maximumSumPoints(
                                   new int[]{1, 2, 7, 4, 2}));
        System.out.println("maximumSumPoints:" +
                           DevsuCodeJam3.maximumSumPoints(
                                   new int[]{29, 99, 68, 1, 19, 25, 94, 43, 42, 10, 78, 53, 12, 7, 31, 42, 49,
                                             45, 70, 20, 76, 89, 16, 37, 92, 13, 6, 54, 99, 48, 63, 40, 56,
                                             23, 8, 95, 18, 37, 23, 52, 15, 44, 18, 55, 10, 79, 80, 31, 67,
                                             75, 48, 35, 79, 37, 41, 92, 51, 38, 91, 4, 55, 55, 17, 55, 37,
                                             87, 20, 5, 95, 86, 26, 60, 68, 19, 65, 96, 63, 70, 92, 59, 67,
                                             83, 17, 68, 100, 47, 74, 91, 0, 37, 10, 41, 2, 69, 74, 39, 70,
                                             32, 72, 63}));
        System.out.println("maximumSumPoints:" +
                           DevsuCodeJam3.maximumSumPoints(
                                   new int[]{99, 34, 50, 32, 61, 16, 55, 29, 68, 17, 77, 58, 60, 24, 9, 13,
                                             93, 55, 68, 63, 70, 41, 37, 38, 93, 68, 43, 35, 40, 51, 74, 26,
                                             78, 21, 25, 42, 18, 0, 17, 36, 55, 53, 61, 28, 4, 79, 71, 47, 98,
                                             57, 33, 89, 41, 16, 19, 13, 53, 69, 21, 81, 28, 11, 64, 19, 55,
                                             29, 27, 8, 77, 14, 75, 16, 54, 12, 20, 97, 31, 9, 4, 63, 83, 44,
                                             42, 81, 87, 4, 50, 28, 60, 96, 54, 51, 23, 70, 61, 10, 19, 48,
                                             71, 20}));
    }

    public static Integer maximumSumPoints(int[] array) {
        int maxSum = array[0];
        int sum = Arrays.stream(array).max().getAsInt();
        for (int i = 0; i < array.length; i++) {
            if (i + 2 < array.length && !(i == 0 && (i + 2 == array.length - 1))) {
                sum = array[i] + array[i + 2];
            }
            if (maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }
}
