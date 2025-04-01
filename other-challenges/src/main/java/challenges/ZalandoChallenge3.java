package technical.challenges;

public class ZalandoChallenge3 {

    public static void main(String[] args) {
        System.out.println(new ZalandoChallenge3().solution(new int[]{1, 1, 1, 1, 2}, 2));
        System.out.println(new ZalandoChallenge3().solution(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new ZalandoChallenge3().solution(new int[]{-1, 2, 6, 9, 16}, 0));
    }

    int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (A[m] > X) {
                r = m - 1;
            } else if (A[m] < X) {
                l = m + 1;
            } else {
                return m;
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }

}
