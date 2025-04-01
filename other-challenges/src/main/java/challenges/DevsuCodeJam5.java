package technical.challenges;

public class DevsuCodeJam5 {

    public static void main(String[] args) {
        System.out.println("maximumArea:" +
                           DevsuCodeJam5.maximumArea(
                                   new int[]{1, 1, 1, 3}));
        System.out.println("maximumArea:" +
                           DevsuCodeJam5.maximumArea(
                                   new int[]{3, 1, 3, 1}));
        System.out.println("maximumArea:" +
                           DevsuCodeJam5.maximumArea(
                                   new int[]{1, 2}));
        System.out.println("maximumArea:" +
                           DevsuCodeJam5.maximumArea(
                                   new int[]{2, 5, 7}));
        System.out.println("maximumArea:" +
                           DevsuCodeJam5.maximumArea(
                                   new int[]{78, 28, 76, 33, 91, 100, 91, 93, 90, 98, 26, 91, 7, 49, 98, 16,
                                             93, 6, 28, 16, 4, 87, 24, 90, 100, 76, 57, 36, 43, 62, 97, 70,
                                             28, 4, 64, 89, 44, 17, 50, 82, 81, 64, 30, 100, 80, 7, 87, 57,
                                             36, 88, 15, 76, 17, 82, 84, 68, 29, 26, 78, 50, 7, 47, 61, 85,
                                             20, 86, 5, 34, 10, 92, 10, 9, 62, 43, 57, 75, 20, 50, 1, 60, 78,
                                             25, 93, 47, 32, 52, 9, 5, 88, 26, 10, 73, 71, 89, 4, 1, 9, 53,
                                             60, 8}));
        System.out.println("maximumArea:" +
                           DevsuCodeJam5.maximumArea(
                                   new int[]{30, 73, 88, 71, 26, 68, 95, 38, 68, 55, 96, 95, 39, 62, 100, 30,
                                             33, 71, 46, 72, 72, 8, 37, 27, 79, 36, 32, 36, 90, 39, 4, 45, 3,
                                             39, 24, 9, 66, 22, 95, 46, 97, 24, 99, 58, 98, 66, 48, 53, 78,
                                             82, 30, 58, 86, 45, 25, 59, 49, 16, 65, 93, 55, 72, 58, 78, 75,
                                             32, 65, 100, 62, 66, 100, 12, 81, 68, 7, 6, 78, 70, 76, 71, 82,
                                             50, 98, 65, 39, 34, 68, 11, 96, 86, 28, 95, 75, 11, 10, 20, 8,
                                             20, 27, 59}));
    }

    public static Integer maximumArea(int[] array) {
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i + 1;
            int minHeight = 0;
            while (index < array.length) {
                if (array[i] < array[index])
                    minHeight = array[i];
                else
                    minHeight = array[index];
                area = (2 * (index - i)) * minHeight;
                if (area > maxArea)
                    maxArea = area;
                index++;
            }
        }
        return maxArea;
    }
}
