package technical.challenges;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;

public class DevsuCodeChallenge {

    public static void main(String[] args) {
//        System.out.println("x=2, y=4, result:" + technical.challenges.DevsuCodeChallenge.calcItem1(2,4));
//        System.out.println("x=3, y=4, result:" + technical.challenges.DevsuCodeChallenge.calcItem1(3,4));
//        System.out.println("x=3, y=10, result:" + technical.challenges.DevsuCodeChallenge.calcItem1(3,10));
//        System.out.println("x=10, y=4, result:" + technical.challenges.DevsuCodeChallenge.calcItem1(10,4));

//        System.out.println("x=3, result:" + technical.challenges.DevsuCodeChallenge.calcItem2(20));
//        System.out.println("x=5, result:" + technical.challenges.DevsuCodeChallenge.calcItem2(1341));

//        System.out.println("x=3, result:" + technical.challenges.DevsuCodeChallenge.calcItem3odd(3));
//        System.out.println("x=5, result:" + technical.challenges.DevsuCodeChallenge.calcItem3odd(5));
//        System.out.println("x=8311, result:" + technical.challenges.DevsuCodeChallenge.calcItem3odd(8311));
//        System.out.println("x=3, result:" + technical.challenges.DevsuCodeChallenge.calcItem3even(3));
//        System.out.println("x=5, result:" + technical.challenges.DevsuCodeChallenge.calcItem3even(5));

//        System.out.println("result: " + technical.challenges.DevsuCodeChallenge.productSubArray(new
//        Double[]{-3.2, 4.2, 7.0, 5.4,
//                -2.2, -2.5}));
//        System.out.println("result: " + technical.challenges.DevsuCodeChallenge.productSubArray(new
//        Double[]{1.1, -5.7, 4.0, 9.3
//                , -5.7, 9.9, -1.4, 9.1, 2.0, -5.0, -9.0, 1.0}));

        System.out.println("x=1, result:" + DevsuCodeChallenge.calcPairRabbits(1));
        System.out.println("x=3, result:" + DevsuCodeChallenge.calcPairRabbits(3));
        System.out.println("x=39, result:" + DevsuCodeChallenge.calcPairRabbits(39));
    }

    public static double clockAngles(String[] hours) {
        DateTimeFormatter smartTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")
                .withResolverStyle(ResolverStyle.STRICT);
        double sum = 0, angle = 0;
        LocalTime time = null;
        for (String i : hours) {
            try {
                time = LocalTime.parse(i, smartTimeFormatter);
            } catch (DateTimeParseException e) {
                sum = sum - 100;
            }
            angle = 30 * time.getHour() - 5.5 * time.getMinute();
        }
        return sum;
    }

    public static int calcPairRabbits(int x) {
        int resultItem = 1;
        for (int i = 1; i <= x - 1; i++) {
            resultItem += 1;
        }
        return resultItem;
    }

    public static double productSubArray(Double[] array) {
        Double[] array1, array2;
        double product1 = 1, product2 = 1;
        double sum = 0;
        int index = 1;
        boolean cont = true;
        while (cont) {
            product1 = multiplyArray(array);
            if (product1 > 0) {
                sum = sumArray(array);
                cont = true;
            } else {
                array1 = Arrays.copyOfRange(array, 0 + index, array.length);
                array2 = Arrays.copyOfRange(array, 0, array.length - index);
                product1 = multiplyArray(array1);
                product2 = multiplyArray(array2);
                if (product1 > product2 && product1 > 0) {
                    System.out.println("arraySolved: " + Arrays.toString(array1));
                    sum = sumArray(array1);
                    cont = false;
                } else if (product1 < product2 && product2 > 0) {
                    System.out.println("arraySolved: " + Arrays.toString(array2));
                    sum = sumArray(array2);
                    cont = false;
                }
            }
            index++;
        }
        return sum;
    }

    private static double multiplyArray(Double[] array) {
        double product = 1;
        for (Double i : array) {
            product *= i;
        }
        return product;
    }

    private static double sumArray(Double[] array) {
        double sum = 0;
        for (Double i : array) {
            sum += i;
        }
        return sum;
    }

    public static int calcItem1(int x, int y) {
        int index = 2, resultItem = x;
        for (int i = 1; i <= y - 1; i++) {
            resultItem *= index;
            index++;
        }
        return resultItem;
    }

    public static int calcItem2(int x) {
        int resultItem = x;
        resultItem = (resultItem * resultItem) + 1;
        return resultItem;
    }

    public static int calcItem3odd(int x) {
        int index = 1, resultItem = 3;
        for (int i = 1; i <= x - 1; i++) {
            resultItem += index;
            index++;
        }
        return resultItem;
    }

    public static int calcItem3even(int x) {
        int resultItem = 4;
        for (int i = 1; i <= x - 1; i++) {
            resultItem += 8;
        }
        return resultItem;
    }
}
