package technical.challenges;

import java.util.*;

public class AgileSearchChallenge_ProblemB {

    private static final String UNKNOWN_RESULT = "unknown";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> variables = new HashMap<>();
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] instructions = input.split(" ");
            String instructionType = instructions[0];
            // Based on instruction type store variables, do calcualtions or clear all variables
            if (InstructionType.DEF.getValue().equals(instructionType)) {
                variables.put(instructions[1], Integer.parseInt(instructions[2]));
            } else if (InstructionType.CALC.getValue().equals(instructionType)) {
                System.out.println(performCalculation(instructions, variables));
            } else if (InstructionType.CLEAR.getValue().equals(instructionType)) {
                variables.clear();
            }
        }
    }

    private static String performCalculation(String[] instructions,
                                             Map<String, Integer> variables) {
        boolean unknownResult = !variables.containsKey(instructions[1]);
        String operator;
        StringBuilder output = new StringBuilder();
        int result = 0;
        for (int i = 1; i < instructions.length; i += 2) {
            String variableName = instructions[i];
            // On first variable
            if (i == 1) {
                output.append(variableName);
                result = variables.getOrDefault(variableName, 0);
            }
            // for the rest of variables
            else {
                operator = instructions[i - 1];
                // Define an unknown result when a variable isn't defined
                if (!variables.containsKey(variableName)) unknownResult = true;
                    // Add or subtract to the result depending on the previous operator
                else {
                    if (operator.equals("+")) result += variables.get(variableName);
                    else if (operator.equals("-")) result -= variables.get(variableName);
                }
                // Append previous operator an current variable
                output.append(" ");
                output.append(operator);
                output.append(" ");
                output.append(variableName);
            }
        }
        // Append '=' operator
        output.append(" ");
        output.append(instructions[instructions.length - 1]);
        output.append(" ");
        // If there's a variable defined equal to the result and if all variables are defined in
        // the calculation display the respective variable in the result
        if (variables.containsValue(result) && !unknownResult)
            output.append(getKeyByValue(variables, result));
        // Otherwise, display unknown result
        else output.append(UNKNOWN_RESULT);
        return output.toString();
    }

    private static String getKeyByValue(Map<String, Integer> variables, int value) {
        for (Map.Entry<String, Integer> entry : variables.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
