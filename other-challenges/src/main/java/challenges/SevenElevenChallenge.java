package technical.challenges;

import java.util.HashSet;
import java.util.Set;

public class SevenElevenChallenge {

    // we have an array of continues numbers from 1 to n, which is not sorted. Now there is one
    // number that is missing and another that is duplicate, we have to print both the duplicate
    // and missing number
    //ex: 6,1,5,3,3,4 -> 2 is missing, 3 is repeated

    public void findDuplicateAndMissing(int[] array) {
        int duplicate=0, missing=0;
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (numbers.contains(array[i])) {
                duplicate = array[0];
            } else {
                numbers.add(array[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (!numbers.contains(i)) {
                missing = i;
            }
        }
        System.out.println("duplicate: " + duplicate + ", missing: " + missing);
    }

}
