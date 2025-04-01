package technical.challenges;

public class DevsuCodeJam7 {

    public static void main(String[] args) {
        System.out.println("maximumMomentum:" +
                           DevsuCodeJam7.maximumMomentum(
                                   new int[]{1, 1, 1, 1}, new int[]{10,10,10,10}, 2));
    }

    public static int maximumMomentum(int[] damage, int[] victories, int c) {
        int sumDamage = 0;
        for (int i = 0; i < damage.length; i++) {
            sumDamage = damage[i];
            while (i < c) {
                sumDamage += damage[i];
                i++;
            }
        }
        return 0;
    }
}
