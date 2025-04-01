package technical.challenges;

import java.util.ArrayList;
import java.util.List;

public class AmazonChallenge2 {

    public static String decodeString(int numberOfRows, String encodedString) {
        List<String> list = new ArrayList(numberOfRows);
        int startIndex=0;
        int rowLength=encodedString.length() / numberOfRows;
        int endIndex=rowLength;
        while (endIndex <= encodedString.length()) {
            list.add(encodedString.substring(startIndex, endIndex));
            startIndex = endIndex;
            endIndex = endIndex + rowLength;
        }
        System.out.println(list);
        StringBuilder decoded = new StringBuilder();
        int listIndex = 0;
        int stringIndex=0;
        while (stringIndex<rowLength) {
            String value = String.valueOf(list.get(listIndex).charAt(stringIndex));
            if (value.equals("_"))
                decoded.append(" ");
            else
                decoded.append(value);
            listIndex++;
            if (listIndex==numberOfRows) {
                listIndex=0;
                stringIndex-= (numberOfRows-2);
            }
            else
                stringIndex++;
            System.out.println("listIndex " + listIndex);
            System.out.println("stringIndex" + stringIndex);
        }
        return decoded.toString().trim();

    }
}
