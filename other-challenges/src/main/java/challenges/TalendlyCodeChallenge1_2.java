package technical.challenges;

import java.util.*;

public class TalendlyCodeChallenge1_2 {
    public static boolean isValid(String s) {
        char[] chr = s.toCharArray();
        Stack<Character> stack = new Stack();
        Stack<String> stack1 = new Stack();
        //stack.pop("C");
        for (int i = 0; i < chr.length; i++) {
            char c = chr[i];
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                char lastAperture = stack.pop();
                if (c == ')' && lastAperture == '(' ||
                    c == ']' && lastAperture == '[' ||
                    c == '}' && lastAperture == '{')
                    continue;
                else
                    return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
//        System.out.println(technical.challenges.TalendlyCodeChallenge1_2.isValid("({})"));
//        System.out.println(technical.challenges.TalendlyCodeChallenge1_2.isValid("(]()"));
//        System.out.println(technical.challenges.TalendlyCodeChallenge1_2.isValid("{()[()]}"));
        getMinorSquares(50);
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        int height = Integer.valueOf(input1.split(" ")[0]);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt())
            list.add(scanner.nextInt());
        getBridgeCrash(234, Arrays.asList(465, 453, 981, 463, 1235, 871, 475, 981));
    }


    public static String getBridgeCrash(int height, List<Integer> list) {
        for (Integer n : list) {
            if (height > n)
                return "Will crash on bridge " + list.indexOf(n);
        }
        return "Will not crash";
    }

    public static void getMinorSquares(int number) {
        int sqr = 1;
        int num = 1;
        while (sqr <= number) {
            System.out.println(sqr);
            ++num;
            sqr = num * num;
        }
    }
}