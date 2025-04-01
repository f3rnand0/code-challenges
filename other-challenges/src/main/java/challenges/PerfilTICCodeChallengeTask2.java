package technical.challenges;

import java.util.Arrays;

public class PerfilTICCodeChallengeTask2 {

    public static void main(String[] args) {
        PerfilTICCodeChallengeTask2 so = new PerfilTICCodeChallengeTask2();
        int[][] A = new int[][]{
                {1, 0, 0},
                {0, 1, 1},
                {1, 1, 0}
        };
        System.out.println("gameOfLife: " + Arrays.deepToString(so.gameOfLife(A, 1)));
        System.out.println("gameOfLife: " + Arrays.deepToString(so.gameOfLife(A, 2)));
        String str = "";
        int[][] arr = Arrays.stream(str.substring(2, str.length() - 2).split("\\],\\["))
                .map(e -> Arrays.stream(e.split("\\s*,\\s*"))
                        .toArray(Integer[]::new)).toArray(int[][]::new);
    }

    public int[][] gameOfLife(int[][] initial_board, int steps) {
        int[][] B = null;
        int rows = initial_board.length;
        int cols = initial_board[0].length;
        int counterAlives = 0;
        boolean inBounds1, inBounds2, inBounds3, inBounds4;
        for (int k = 0; k < steps; k++) {
            int[][] finalA = initial_board;
            B = java.util.Arrays.stream(initial_board).map(x -> x.clone()).toArray($ -> finalA.clone());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
//                index = i+1;
                    inBounds1 = ((i + 1) >= 0) && ((i + 1) < initial_board.length);
                    inBounds2 = ((i - 1) >= 0) && ((i - 1) < initial_board.length);
                    inBounds3 = ((j + 1) >= 0) && ((j + 1) < initial_board.length);
                    inBounds4 = ((j - 1) >= 0) && ((j - 1) < initial_board.length);

                    if (inBounds1) {
                        if (inBounds4) {
                            if (initial_board[i + 1][j - 1] == 1)
                                counterAlives++;
                        }
                        if (initial_board[i + 1][j] == 1)
                            counterAlives++;
                        if (inBounds3) {
                            if (initial_board[i + 1][j + 1] == 1)
                                counterAlives++;
                        }
                    }
                    if (inBounds2) {
                        if (inBounds4)
                            if (initial_board[i - 1][j - 1] == 1)
                                counterAlives++;
                        if (initial_board[i - 1][j] == 1)
                            counterAlives++;
                        if (inBounds3)
                            if (initial_board[i - 1][j + 1] == 1)
                                counterAlives++;
                    }
                    if (inBounds4)
                        if (initial_board[i][j - 1] == 1)
                            counterAlives++;
                    if (inBounds3)
                        if (initial_board[i][j + 1] == 1)
                            counterAlives++;

                    // Check neighbours cells of dead cell
                    if (initial_board[i][j] == 0) {
                        if (counterAlives == 3)
                            B[i][j] = 1;
                    }
                    // Check neighbours cells of alive cell
                    else {
                        if (counterAlives != 2 && counterAlives != 3)
                            B[i][j] = 0;
                    }
                    counterAlives = 0;
                }
            }
            initial_board = B;
        }
        return B;
    }
}
