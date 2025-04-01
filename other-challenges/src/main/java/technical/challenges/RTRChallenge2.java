package technical.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RTRChallenge2 {

    public static void main(String[] args) {
        Map<String, UserStats> map1 = new HashMap<>();
        map1.put("1", new UserStats(Optional.of(1L)));
        map1.put("2", new UserStats(Optional.of(1L)));
        map1.put("4", new UserStats(Optional.empty()));
        Map<String, UserStats> map2 = new HashMap<>();
        map2.put("1", new UserStats(Optional.empty()));
        map2.put("2", new UserStats(Optional.empty()));
        Map<String, UserStats> map3 = new HashMap<>();
        map3.put("2", new UserStats(Optional.of(4L)));
        map3.put("3", new UserStats(Optional.of(3L)));
        Map<String, UserStats> map4 = new HashMap<>();
        map4.put(null, new UserStats(Optional.of(4L)));
        Map<String, UserStats> map5 = new HashMap<>();
        map5.put("5", null);
        map5.put("5", new UserStats(Optional.of(0L)));
        Map<String, UserStats> map6 = new HashMap<>();
        System.out.println("map visits by user: " + count(map1, map2, map3, map4, map5, map6, null));
        System.out.println("map visits by user: " + count());
        System.out.println("map visits by user: " + count(null));

        System.out.println("map visits by user: " + count2(map1, map2, map3, map4, map5, map6, null));
        System.out.println("map visits by user: " + count2());
        System.out.println("map visits by user: " + count2(null));
    }

    // With streams
    static Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> mappedVisitors = new HashMap<>();
        if (visits != null) {
            for (int i = 0; i < visits.length; i++) {
                if (visits[i] != null) {
                    visits[i].entrySet().stream()
                            .filter(m -> m != null || m.getKey() != null || m.getValue() != null)
                            .forEach(filteredMap -> {
                                Long id, count;
                                try {
                                    id = Long.parseLong(filteredMap.getKey());
                                } catch (NumberFormatException e) {
                                    id = null;
                                }
                                if (id != null && filteredMap.getValue() != null &&
                                    filteredMap.getValue().getVisitCount().isPresent()) {
                                    count = filteredMap.getValue().getVisitCount().get();
                                    if (mappedVisitors.containsKey(id)) {
                                        mappedVisitors.put(id, mappedVisitors.get(id) + count);
                                    } else {
                                        mappedVisitors.put(id, count);
                                    }
                                }
                            });
                }
            }
        }
        return mappedVisitors;
    }

    // With for loops
    static Map<Long, Long> count2(Map<String, UserStats>... visits) {
        Map<Long, Long> mappedVisitors = new HashMap<>();
        if (visits != null) {
            for (int i = 0; i < visits.length; i++) {
                if (visits[i] != null) {
                    visits[i].forEach((key, value) -> {
                        Long id, count;
                        try {
                            id = Long.parseLong(key);
                        } catch (NumberFormatException e) {
                            id = null;
                        }
                        if (id != null && value != null) {
                            if (value.getVisitCount() != null && value.getVisitCount().isPresent()) {
                                count = value.getVisitCount().orElse(0L);
                                if (count > 0) {
                                    if (mappedVisitors.containsKey(id)) {
                                        mappedVisitors.put(id, mappedVisitors.get(id) + count);
                                    } else {
                                        mappedVisitors.put(id, count);
                                    }
                                }
                            }
                        }
                    });
                }
            }
        }
        return mappedVisitors;
    }
}
