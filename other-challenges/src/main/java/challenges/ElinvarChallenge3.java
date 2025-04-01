package technical.challenges;

public class ElinvarChallenge3 {

    public static void main(String[] args) {
        System.out.println(new ElinvarChallenge3().solution("a?bb"));
        System.out.println(new ElinvarChallenge3().solution("??abb"));
        System.out.println(new ElinvarChallenge3().solution("a?b?aa"));
        System.out.println(new ElinvarChallenge3().solution("aa??aa"));
        System.out.println(new ElinvarChallenge3().solution("a?a"));
        System.out.println(new ElinvarChallenge3().solution("a??"));
    }

    public String solution(String S) {
        if (!S.contains("?")) return S;
        char currentChar, previousChar;
        char replaceChar = 'a';
        int counter = 1;
        StringBuilder solution = new StringBuilder(S);
        if (S.endsWith("?")) if (S.charAt(S.length() - 1) == 'a') replaceChar = 'b';
        else if (S.charAt(S.length() - 1) == 'b') replaceChar = 'a';
        solution.setCharAt(S.length() - 1, replaceChar);
        for (int i = S.length() - 1; i > 0; i--) {
            currentChar = S.charAt(i);
            previousChar = S.charAt(i - 1);
            if (previousChar == '?') {
                if (currentChar == 'a') replaceChar = 'b';
                else if (currentChar == 'b') replaceChar = 'a';
                solution.setCharAt(i - 1, replaceChar);
                //counter = counter == 2 ? counter = 1 : counter++;
            }
            if (currentChar == previousChar) counter++;
            else counter = 1;
        }
        return solution.toString();
    }

}
