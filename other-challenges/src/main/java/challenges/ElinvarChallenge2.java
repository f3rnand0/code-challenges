package technical.challenges;

public class ElinvarChallenge2 {

    public static void main(String[] args) {
        System.out.println(new ElinvarChallenge2().solution("abccbd", new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println(new ElinvarChallenge2().solution("aabbcc", new int[]{1, 2, 1, 2, 1, 2}));
        System.out.println(new ElinvarChallenge2().solution("aaaa", new int[]{3, 4, 5, 6}));
        System.out.println(new ElinvarChallenge2().solution("ababa", new int[]{3, 4, 5, 6}));
    }

    public int solution(String S, int[] C) {
        if (S.length() <= 1) return 0;
        char currentChar, nextChar;
        int minimumCost = 0;
        for (int i = 0; i < S.length() - 1; i++) {
            currentChar = S.charAt(i);
            nextChar = S.charAt(i + 1);
            if (currentChar == nextChar) {
                minimumCost += Math.min(C[i], C[i + 1]);
            }
        }
        return minimumCost;
    }

}
