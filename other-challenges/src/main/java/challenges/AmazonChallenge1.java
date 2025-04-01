package technical.challenges;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AmazonChallenge1 {

    public static List<String> groupTransactions(List<String> transactions) {
        Map<String, Long>
                groupedTransactions = transactions.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<String> result = groupedTransactions.entrySet().stream()
                .sorted((Comparator.comparing(Map.Entry<String, Long>::getValue).reversed()
                        .thenComparing(Map.Entry::getKey)))
                .map(e -> e.getKey() + " " + e.getValue()).collect(Collectors.toList());
        return result;
    }
}
