package technical.challenges;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AdyenChallenge1 {

    public static void main(String[] args) {
    }

    static final class BinRange {
        final String start;
        final String end;
        final String cardType;

        BinRange(String start, String end, String cardType) {
            this.start = start;
            this.end = end;
            this.cardType = cardType;
        }
    }

    interface CardTypeCache {
        /**
         * @param cardNumber 12 to 23 digit card number.
         * @return the card type for this cardNumber or null if the card number does not
         * fall into any valid bin ranges.
         */
        String get(String cardNumber);
    }

    static class FastCache implements CardTypeCache {
        //String cardNumber;
        //String cardType;
        Map<List<String>, String> cacheRanges;

        public FastCache(Map<List<String>, String> cache) {
            this.cacheRanges = cache;
        }

        @Override
        public String get(String cardNumber) {
            //System.out.println("cardNumber " + cardNumber);
            //cacheRanges.forEach((key, value) -> System.out.println(key + ":" + value));
            for (Map.Entry<List<String>, String> entry : cacheRanges.entrySet()) {
                Long card = Long.parseLong(cardNumber.substring(0, 12));
                Long rangeStart = Long.parseLong(entry.getKey().get(0));
                Long rangeEnd = Long.parseLong(entry.getKey().get(1));
                if (rangeStart <= card && rangeEnd >= card) return entry.getValue();
            }
            return null;
        }
    }

    /**
     * @param binRanges the list of card bin ranges to build a cache from.
     *
     * @return an implementation of CardTypeCache.
     */
    public static CardTypeCache buildCache(List<BinRange> binRanges) {
        Map<List<String>, String> cacheRanges = new LinkedHashMap<>();
        for (BinRange range : binRanges) {
            cacheRanges.put(Arrays.asList(range.start, range.end), range.cardType);
        }
        CardTypeCache cache = new FastCache(cacheRanges);
        return cache;
    }

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        String identifier;
        String[] data;
        int balance;
        Map<String,Integer> transactionsMap = new HashMap<>();
        List<String> rejectedTransactions = new ArrayList<>();
        for(int i=0; i<transactions.size(); i++) {
            data = transactions.get(i).split(",");
            identifier = String.join(",", data[0], data[1], data[2]);
            int quantity = Integer.parseInt(data[3]);
            String transactionId = data[4];
            if (transactionsMap.containsKey(identifier)) {
                balance = transactionsMap.get(identifier);
                if ((quantity + balance) > creditLimit)
                    rejectedTransactions.add(transactionId);
                else
                    transactionsMap.put(identifier, quantity + balance);
            }
            else {
                balance = 0;
                if ((quantity + balance) > creditLimit)
                    rejectedTransactions.add(transactionId);
                else
                    transactionsMap.put(identifier, quantity);
            }
        }
        return rejectedTransactions;
    }



}
