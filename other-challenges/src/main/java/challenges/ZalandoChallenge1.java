package technical.challenges;

import java.util.Arrays;

public class ZalandoChallenge1 {

    public static void main(String[] args) {
        //System.out.println(new ZalandoChallenge1().solution(new String[]{"...Xv", "Ax..^", ".XX
        // .."}));
        System.out.println(new ZalandoChallenge1().solution(
                new String[]{"X.....>", "..v..X.", ".>..X..", "A......"}));

    }

    public boolean solution(String[] B) {
        String[][] matrix = new String[B.length][B[0].length()];
        for (int i = 0; i < B.length; i++) {
            matrix[i] = B[i].split("");
        }
        System.out.println("first " + Arrays.deepToString(matrix));
        fillMatrixWithGuardsSight(matrix);
        System.out.println("guardsSight " + Arrays.deepToString(matrix));
        int rowAssasin = 0, colAssasin = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("A")) {
                    rowAssasin = i;
                    colAssasin = j;
                }
            }
        }
        return searchPath(matrix, rowAssasin, colAssasin, rowAssasin, colAssasin);
    }

    private boolean searchPath(String[][] matrix, int rowAssassin, int colAssassin, int previousRow,
                               int previousCol) {
        boolean result = false;
        int[] nextSpot = nextAvailableSpot(matrix, rowAssassin + 1, colAssassin);
        if (nextSpot != null && (nextSpot[0] != previousRow || nextSpot[1] != previousCol)) {
            if ((nextSpot[0] == matrix.length - 1) && (nextSpot[1] == matrix[0].length - 1))
                result = true;
            else result = result ||
                          searchPath(matrix, nextSpot[0], nextSpot[1], rowAssassin, colAssassin);
        }
        nextSpot = nextAvailableSpot(matrix, rowAssassin, colAssassin + 1);
        if (nextSpot != null && (nextSpot[0] != previousRow || nextSpot[1] != previousCol)) {
            if ((nextSpot[0] == matrix.length - 1) && (nextSpot[1] == matrix[0].length - 1))
                result = true;
            else result = result ||
                          searchPath(matrix, nextSpot[0], nextSpot[1], rowAssassin, colAssassin);
        }
        nextSpot = nextAvailableSpot(matrix, rowAssassin - 1, colAssassin);
        if (nextSpot != null && (nextSpot[0] != previousRow || nextSpot[1] != previousCol)) {
            if ((nextSpot[0] == matrix.length - 1) && (nextSpot[1] == matrix[0].length - 1))
                result = true;
            else result = result ||
                          searchPath(matrix, nextSpot[0], nextSpot[1], rowAssassin, colAssassin);
        }
        nextSpot = nextAvailableSpot(matrix, rowAssassin, colAssassin - 1);
        if (nextSpot != null && (nextSpot[0] != previousRow || nextSpot[1] != previousCol)) {
            if ((nextSpot[0] == matrix.length - 1) && (nextSpot[1] == matrix[0].length - 1))
                result = true;
            else result = result ||
                          searchPath(matrix, nextSpot[0], nextSpot[1], rowAssassin, colAssassin);
        }
        return result;
    }

    private int[] nextAvailableSpot(String[][] matrix, int row, int col) {
        if ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[0].length)) {
            if (matrix[row][col].equals(".")) return new int[]{row, col};
        }
        return null;
    }

    private void fillMatrixWithGuardsSight(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("v")) {
                    int counter = i + 1;
                    while (counter < matrix.length) {
                        if (!matrix[i][counter].equals(".")) {
                            if (!matrix[i][counter].equals("Y")) break;
                        } else matrix[i][counter] = "Y";
                        counter++;
                    }
                } else if (matrix[i][j].equals("^")) {
                    int counter = i - 1;
                    while (counter >= 0) {
                        if (!matrix[i][counter].equals(".")) {
                            if (!matrix[i][counter].equals("Y")) break;
                        } else matrix[i][counter] = "Y";
                        counter--;
                    }
                } else if (matrix[i][j].equals("<")) {
                    int counter = j - 1;
                    while (counter >= 0) {
                        if (!matrix[i][counter].equals(".")) {
                            if (!matrix[i][counter].equals("Y")) break;
                        } else matrix[i][counter] = "Y";
                        counter--;
                    }
                } else if (matrix[i][j].equals(">")) {
                    int counter = j + 1;
                    while (counter < matrix[i].length) {
                        if (!matrix[i][counter].equals(".")) {
                            if (!matrix[i][counter].equals("Y")) break;
                        } else matrix[i][counter] = "Y";
                        counter++;
                    }
                }
            }
        }
    }

}
