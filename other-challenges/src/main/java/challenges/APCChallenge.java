package technical.challenges;

import java.util.*;

public class APCChallenge {

    private static final String UNKNOWN_RESULT = "unknown";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, List<Integer>> sawMills = new HashMap<>();
        Integer sawMillsNumber = 0, trunksNumber = 0;
        StringBuilder builder = new StringBuilder();
        while (sc.hasNextLine()) {
            sawMillsNumber = Integer.valueOf(sc.nextLine());
            if (sawMillsNumber > 0) {
                for (int i = 0; i < sawMillsNumber; i++) {
                    trunksNumber = Integer.valueOf(sc.nextInt());
                    List<Integer> trunks = new ArrayList<>(trunksNumber);
                    for (int j = 0; j < trunksNumber; j++) {
                        trunks.add(sc.nextInt());
                    }
                    sc.nextLine();
                    sawMills.put(i, trunks);
                    calculateMaxProfitSawnWood(sawMills, builder);
                }
            } else break;
        }
        System.out.println("sawMillsNumber " + sawMillsNumber);
        for (Map.Entry<Integer, List<Integer>> entry : sawMills.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }
    }

    private static void calculateMaxProfitSawnWood(Map<Integer, List<Integer>> sawMills,
                                                   StringBuilder builder) {
        for (Map.Entry<Integer, List<Integer>> entry : sawMills.entrySet()) {

        }
    }
}
