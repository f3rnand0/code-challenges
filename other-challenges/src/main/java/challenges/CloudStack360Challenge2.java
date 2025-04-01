package technical.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CloudStack360Challenge2 {

    public static void main(String[] args) {
        System.out.println(CoinDetermine(4));
        System.out.println(CoinDetermine(12));
        System.out.println(CoinDetermine(16));
        System.out.println(CoinDetermine(17));
        System.out.println(CoinDetermine(18));
        System.out.println(CoinDetermine(26));
    }

    public static Integer CoinDetermine(int num) {
        int[] coins = new int[] {11, 9, 7, 5, 1};
        int sum = coins[0];
        int count = 1;
        int i = 0 ;
        while (sum < num) {
            sum += coins[i];
            count++;
            if (sum > num) {
                sum -= coins[i];
                i++;
                count--;
            }
        }
        return count;
    }
}
