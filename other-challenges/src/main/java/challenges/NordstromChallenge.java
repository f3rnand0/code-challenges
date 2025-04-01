package technical.challenges;

/**
 * Letter Counter and Compression
 * Given a input string, write a function that returns the compressed string for the input String.
 * Example:
 * - Input: "abbccddeeefffgggg" - Output: "a1b2c2d2e3f3g4"
 * - Input: "Hello World" - Output: "h1e1l3o2w1r1d1"
 */

public class NordstromChallenge {

    public static void main(String[] args) {
        String output = NordstromChallenge.compressedString("abb");
        System.out.println(output);
        output = NordstromChallenge.compressedString("abbccddeeefffgggg");
        System.out.println(output);
        output = NordstromChallenge.compressedString("Hello World");
        System.out.println(output);
    }

    private static String compressedString(String input) { // O(N^2)
        input = input.toLowerCase();
        String output = "", str;
        long count;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) { // N
            if (!String.valueOf(chars[i]).equals(" ")) {
                int ch = chars[i];
                count = input.chars().filter(c -> c == ch).count(); // N
                str = String.valueOf(chars[i]);
                if (!output.contains(str))
                    output += str + count;
            }
        }
        return output;
    }
}
