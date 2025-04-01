package technical.challenges;

import java.util.Arrays;

public class SouthworksCodeChallengeSample {

    public static void main(String[] args) {
        SouthworksCodeChallengeSample so = new SouthworksCodeChallengeSample();
        System.out.println("lowest positive int: " + so.solution(new int[]{1, 2, 3}));
        System.out.println("lowest positive int: " + so.solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println("lowest positive int: " + so.solution(new int[]{-1, -3}));
        System.out.println("lowest positive int: " + so.solution(new int[]{1, 2, 5}));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        if (A[A.length - 1] <= 0)
            return 1;
        for (int i = 0; i < A.length - 1; i++) {
            if ((A[i + 1] - A[i]) > 1)
                return A[i] + 1;
        }
        return A[A.length - 1] + 1;
    }
}
