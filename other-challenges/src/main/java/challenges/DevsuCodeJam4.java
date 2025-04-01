package technical.challenges;

public class DevsuCodeJam4 {

    public static void main(String[] args) {
        System.out.println("waysToGenerateString:" +
                           DevsuCodeJam4.waysToGenerateString("doggdog", "dog"));
    }

    public static Integer waysToGenerateString(String source, String target) {
        String[] arraySource = new String[source.length()];
        String[] arrayTarget = new String[target.length()];
        for (int i = 0; i < source.length(); i++) {
            arraySource[i] = source.substring(i, i + 1);
        }
        for (int i = 0; i < target.length(); i++) {
            arrayTarget[i] = target.substring(i, i + 1);
        }
        Boolean cont = true;
        int index1 = 0, index2 = 0;
        int ways = 0;
        while (cont) {
            if (arraySource[index1].equals(arrayTarget[index2])) {
                if (index2 < arrayTarget.length) {
                    if (index2 == arrayTarget.length - 1) {
                        ways++;
                    }
                    index1++;
                    index2++;
                }
            } else
                index1++;
            if (index1 == arraySource.length)
                cont = false;
        }
        return ways;
    }
}
