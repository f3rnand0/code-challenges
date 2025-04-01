package technical.challenges;

public class DevsuCodeJam6 {

    public static void main(String[] args) {
        System.out.println("canReachLastLeaf:" +
                           DevsuCodeJam6.canReachLastLeaf(
                                   new int[]{3, 1, 1, 1}));
        System.out.println("canReachLastLeaf:" +
                           DevsuCodeJam6.canReachLastLeaf(
                                   new int[]{1, 0, 1}));
        System.out.println("canReachLastLeaf:" +
                           DevsuCodeJam6.canReachLastLeaf(
                                   new int[]{1, 2, 2, 5, 2, 5, 2, 5, 5, 4, 4, 4, 4, 4, 2, 4, 0, 3, 3, 3, 4, 2,
                                             4, 3, 2, 3, 5, 0, 3, 4, 2, 2, 1, 1, 3, 5, 2, 2, 4, 4, 1, 4, 1, 3,
                                             5, 3, 1, 3, 1, 5, 2, 0, 3, 5, 5, 2, 4, 0, 4, 3, 1, 4, 5, 0, 3, 4,
                                             5, 2, 4, 5, 4, 4, 1, 5, 0, 4, 5, 0, 5, 2, 0, 5, 0, 3, 3, 4, 1, 5,
                                             3, 4, 1, 1, 1, 2, 5, 0, 3, 5, 2, 1}));
        System.out.println("canReachLastLeaf:" +
                           DevsuCodeJam6.canReachLastLeaf(
                                   new int[]{5, 2, 5, 5, 4, 1, 3, 1, 2, 0, 0, 0, 0, 4, 0, 3, 0, 4, 4, 1, 3, 3,
                                             5, 1, 5, 5, 4, 4, 2, 3, 0, 3, 3, 1, 0, 5, 2, 4, 2, 1, 0, 1, 4, 3,
                                             3, 5, 1, 3, 5, 4, 1, 2, 0, 4, 2, 2, 0, 1, 2, 5, 4, 5, 4, 4, 0, 4,
                                             0, 1, 0, 5, 3, 1, 1, 4, 5, 3, 1, 0, 5, 1, 5, 5, 3, 3, 2, 0, 3, 4,
                                             0, 1, 5, 0, 4, 2, 2, 0, 3, 2, 3, 2}));

    }

    public static Boolean canReachLastLeaf(int[] array) {
        int jumps = 0;
        for (int i = 0; i < array.length; i++) {
            jumps = jumps + array[i];
            if (jumps >= 1) {
                jumps = jumps - 1;
            } else return false;
        }
        return true;
    }
}
