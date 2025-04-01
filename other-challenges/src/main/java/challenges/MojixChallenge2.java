package technical.challenges;

public class MojixChallenge2 {

    public String compressString(String input) {
        char current = input.charAt(0);
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        for (int i = 1; i < input.length(); i++) {
            if (current == input.charAt(i)) {
                counter++;
            } else {
                builder.append(current);
                if (counter != 1) {
                    builder.append(counter);
                }
                current = input.charAt(i);
                counter = 1;
            }
        }
        builder.append(current);
        if (counter != 1) {
            builder.append(counter);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MojixChallenge2().compressString("aaabbbbbcccc"));
        System.out.println(new MojixChallenge2().compressString("abc"));
    }
}
