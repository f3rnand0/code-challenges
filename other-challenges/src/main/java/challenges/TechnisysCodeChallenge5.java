package technical.challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TechnisysCodeChallenge5 {
    public static int getMinimumConnections(boolean[][] matrix) {
        Map<Integer, Set<Integer>> connections = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != j) {
                    if (matrix[i][j]) {
                        set.add(j);
                        connections.put(i, set);
                    }
                }
            }
        }
        for (Map.Entry<Integer, Set<Integer>> entry : connections.entrySet()) {
            Set<Integer> conn = entry.getValue();
            for (Integer i : conn) {
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        boolean[][] matrix = new boolean[][]{
                {false, true, false, false, true},
                {true, false, false, false, false},
                {false, false, false, true, false},
                {false, false, true, false, false},
                {true, false, false, false, false}
        };
        System.out.println(TechnisysCodeChallenge5.getMinimumConnections(matrix)); // should print 1
    }
}