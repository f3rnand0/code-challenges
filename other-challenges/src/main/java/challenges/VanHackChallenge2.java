package technical.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VanHackChallenge2 {

    public static void main(String[] args) {
        String contents = "Beth,Charles,Danielle,Adam,Eric\n" +
                          "17945,10091,10088,3907,10132\n" +
                          "2,12,13,48,11";
        VanHackChallenge2.sortCsvColumns(contents);
    }

    public static String sortCsvColumns(String csv_data) {
        String[] rows = csv_data.split("\n");
        List<String> rowsList =
                Arrays.stream(csv_data.replace("\n", ",").split(",")).map(s -> s.replace("\\n", ", "))
                        .collect(Collectors.toList());
        int numRows = rows.length;
        int numColumns = rows[0].split(",").length;
        String[] columnsArray = new String[numColumns];
        int k = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (columnsArray[j] != null)
                    columnsArray[j] = columnsArray[j] + "," + rowsList.get(j+k);
                else
                    columnsArray[j] = rowsList.get(j+k);
            }
            k += numColumns;
        }

        Arrays.sort(columnsArray);
        System.out.println("columnsArray " + Arrays.toString(columnsArray));
        String output = null;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (output != null)
                    if (j != 0)
                        output += "," + columnsArray[j].split(",")[i];
                    else
                        output += columnsArray[j].split(",")[i];
                else
                    output = columnsArray[j].split(",")[i];
            }
            if (i < numRows - 1)
                output += "\\n";
        }
        System.out.println("output " + output);
        return output;
    }
}
