package technical.challenges;

import java.util.ArrayList;
import java.util.List;

public class TuringCodeChallenge1 {

    public static int callPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        int i = 0;
        for (String str : ops) {
            if ("C".equals(str)) {
                scores.remove(i - 1);
                i--;
            } else if ("D".equals(str)) {
                Integer value = Integer.valueOf(scores.get(i - 1)) * 2;
                scores.add(value);
                i++;
            } else if ("+".equals(str)) {
                Integer value = Integer.valueOf(scores.get(i - 1)) + Integer.valueOf(scores.get(i - 2));
                scores.add(value);
                i++;
            } else {
                scores.add(Integer.valueOf(str));
                i++;
            }
        }
        return scores.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(callPoints(new String[]{"5", "2", "C", "D", "+"}));
    }


}