package technical.challenges;

import java.util.Arrays;
import java.util.Random;

public class ZalandoChallenge2 {

    public static void main(String[] args) {
        Random rd = new Random();
        int[] array = new int[4];
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt();
        }
        System.out.println(Arrays.toString(array));
        System.out.println(new ZalandoChallenge2().solution(array));
        System.out.println(
                new ZalandoChallenge2().solution(new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2}));
    }

    public int solution(int[] A) {
        int maxHeight = getMaximumNumber(A);
        int strokes = 0;
        //List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[j] > 0) {
                    strokes++;
                    if (strokes > 1000000001) return -1;
                    while (j < A.length && A[j] > 0) {
                        A[j]--;
                        j++;
                    }
                }

            }
        }
        return strokes;
    }

    /*public int solution(int[] A) {
        int maxHeight = getMaximumNumber(A);
        int[][] shape = generateShape(A, maxHeight);
        int strokes=0;
        for(int i=0; i<shape.length; i++) {
            for(int j=0; j<shape[i].length; j++) {
                if (shape[i][j] == 1) {
                    strokes++;
                    if (strokes > 1000000001)
                        return -1;
                }
                while (j< shape[i].length && shape[i][j] == 1) {
                    j++;
                }
            }
        }
        return strokes;
    }*/

    private int[][] generateShape(int[] A, int maxHeight) {
        int[][] shape = new int[maxHeight][A.length];
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            int j = 0;
            while (number > 0) {
                shape[j][i] = 1;
                number--;
                j++;
            }
        }
        return shape;
    }

    private int getMaximumNumber(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) max = A[i];
        }
        return max;
    }
}
