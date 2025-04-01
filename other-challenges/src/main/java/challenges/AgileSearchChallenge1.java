package technical.challenges;

import java.util.Scanner;

public class AgileSearchChallenge1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long a = sc.nextLong(), b = sc.nextLong();
            System.out.println(differenceBetweenNonNegativeIntegers(a, b));
        }
    }

    public static Long differenceBetweenNonNegativeIntegers(long a, long b) {
        return Math.abs(a - b);
    }
}
