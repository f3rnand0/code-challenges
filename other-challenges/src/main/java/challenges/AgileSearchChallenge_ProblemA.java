package technical.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgileSearchChallenge_ProblemA {

    private static final String ANOMALY = "(ANOMALY)";
    private static final String ENTRY = "entry";
    private static final String ENTERED = "entered";
    private static final String EXITED = "exited";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        List<String> accessList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String access = sc.nextLine();
            System.out.println(trackEmployeeAccess(access, accessList));
        }
    }

    public static String trackEmployeeAccess(String access, List<String> accessList) {
        String[] accessValues = access.split(" ");
        StringBuilder output = new StringBuilder();
        String action = accessValues[0].equals(ENTRY) ? ENTERED : EXITED;
        String name = accessValues[1];
        // When there was an entry or exit the first time
        if (!accessList.contains(access)) {
            // If the action is an entry
            if (accessValues[0].equals(ENTRY)) {
                accessList.add(access);
                addAccessOutput(output, name, action);
            }
            // If the action is an exit
            else {
                // If there was an entry before, remove it
                if (accessList.contains(ENTRY + " " + accessValues[1])) {
                    accessList.remove(ENTRY + " " + accessValues[1]);
                    addAccessOutput(output, name, action);
                }
                // If there was an entry before, report an anomaly
                else {
                    addAccessOutput(output, accessValues[1], action);
                    output.append(" ");
                    output.append(ANOMALY);
                }
            }
        }
        // // When there was an entry or exit already, report an anomaly
        else {
            addAccessOutput(output, name, action);
            output.append(" ");
            output.append(ANOMALY);
        }
        return output.toString();
    }

    private static void addAccessOutput(StringBuilder output, String name, String action) {
        output.append(name);
        output.append(" ");
        output.append(action);
    }
}
