package technical.challenges;

import java.util.ArrayList;
import java.util.List;

public class SouthworksCodeChallengeTask1 {

    public static void main(String[] args) {
        SouthworksCodeChallengeTask1 so = new SouthworksCodeChallengeTask1();
//        System.out.println("5 digit injected: " + so.solution(268));
//        System.out.println("5 digit injected: " + so.solution(670));
//        System.out.println("5 digit injected: " + so.solution(0));
//        System.out.println("5 digit injected: " + so.solution(-999));
//        System.out.println("5 digit injected: " + so.solution(-2));
        System.out.println("5 digit injected: " + so.solution(0));
        System.out.println("5 digit injected: " + so.solution(1));
        System.out.println("5 digit injected: " + so.solution(5));
        System.out.println("5 digit injected: " + so.solution(6));
        System.out.println("5 digit injected: " + so.solution(999));
        System.out.println("5 digit injected: " + so.solution(0001));
        System.out.println("5 digit injected: " + so.solution(0005));
        System.out.println("5 digit injected: " + so.solution(0007));
    }

    public int solution(int N) {
        String number = String.valueOf(N);
        List<Integer> ints = new ArrayList<>(number.length() + 1);
        int digit, i = 0;
        if (N < 0) {
            int Nsize = ((Integer) N).toString().length() - 1;
            return (N - (5 * (int) Math.pow(10, Nsize)));
        } else {
            for (char c : number.toCharArray()) {
                digit = Character.getNumericValue(c);
                if (digit <= 5) {
                    ints.add(i, 5);
                    ints.add(digit);
                    i += 2;
                } else {
                    ints.add(i, digit);
                    i++;
                }
            }
            if (!ints.contains(5))
                ints.add(5);
            String newN = "";
            for (Integer a : ints) {
                newN += a.toString();
            }
            return Integer.parseInt(newN);
        }
    }
}
