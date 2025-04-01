package technical.challenges;

import java.util.Arrays;

public class RTRChallenge1 {

    public static void main(String[] args) {
        System.out.println("smallest positive integer: " + solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println("smallest positive integer: " + solution(new int[]{-1, -3}));
        System.out.println("smallest positive integer: " + solution(new int[]{0}));
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int n = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == n)
                n++;
        }
        return n;
    }

}
