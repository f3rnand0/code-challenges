package technical.challenges;

public class TalendlyCodeChallenge1_1 {
    public static boolean isValid(String s) {
        char[] chr = s.toCharArray();
        int counter = 0;
        for (int i = 0; i < chr.length; i++) {
            if (chr[i] == '(')
                counter++;
            else {
                counter--;
                if (counter < 0)
                    return false;
            }
        }
        if (counter == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(TalendlyCodeChallenge1_1.isValid("()"));
        System.out.println(TalendlyCodeChallenge1_1.isValid("()()"));
        System.out.println(TalendlyCodeChallenge1_1.isValid(")("));
    }
}