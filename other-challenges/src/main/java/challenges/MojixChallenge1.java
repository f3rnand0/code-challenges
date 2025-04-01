package technical.challenges;

public class MojixChallenge1 {

    public static void main(String[] args) {
        System.out.println(isParenthesesBalanced("()"));
        System.out.println(isParenthesesBalanced(")("));
        System.out.println(isParenthesesBalanced("()("));
        System.out.println(isParenthesesBalanced("())"));
        System.out.println(isParenthesesBalanced(""));
        System.out.println(isParenthesesBalanced(" "));
        System.out.println(isParenthesesBalanced("((()()))"));
        System.out.println(isParenthesesBalanced("((())))"));
        System.out.println(isParenthesesBalanced("(((()))"));
        System.out.println(isParenthesesBalanced("(()"));
        System.out.println(isParenthesesBalanced(")()"));
    }

    public static boolean isParenthesesBalanced(String str) {
        int counter = 0;
        if (str.isBlank()) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (counter < 0) return false;
            if (str.charAt(i) == '(') {
                counter++;
            } else if (str.charAt(i) == ')') {
                counter--;
            }
        }
        return (counter == 0);
    }
}