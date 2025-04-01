package technical.challenges;

public class SoshaceCodeChallenge1 {
    public static int crossedBricks(int[][] arr, int crossPoint) {
        int sum;
        int crossedBricks = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                if (sum >= crossPoint) {
                    if (sum > crossPoint)
                        crossedBricks++;
                    break;
                }
            }
        }
        return crossedBricks;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 2, 1},
                       {3, 1, 2},
                       {1, 3, 2},
                       {2, 4},
                       {3, 1, 2},
                       {1, 3, 1, 1}};
        System.out.println(SoshaceCodeChallenge1.crossedBricks(arr, 4));
    }
}