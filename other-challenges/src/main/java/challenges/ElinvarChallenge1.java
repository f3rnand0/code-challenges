package technical.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElinvarChallenge1 {

    public static void main(String[] args) {
        System.out.println(new ElinvarChallenge1().solution("^vv<v"));
    }

    public int solution(String S) {
        Map<Character, Integer> arrowsCount = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            switch (ch) {
                case '^':
                    arrowsCount.put('^', arrowsCount.getOrDefault('^', 0) + 1);
                    break;
                case 'v':
                    arrowsCount.put('v', arrowsCount.getOrDefault('v', 0) + 1);
                    break;
                case '<':
                    arrowsCount.put('<', arrowsCount.getOrDefault('<', 0) + 1);
                    break;
                case '>':
                    arrowsCount.put('>', arrowsCount.getOrDefault('>', 0) + 1);
                    break;
            }
        }
        int timesCharMostRepeated = arrowsCount.entrySet().stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get()
                .getValue();
        return S.length() - timesCharMostRepeated;
    }
}
