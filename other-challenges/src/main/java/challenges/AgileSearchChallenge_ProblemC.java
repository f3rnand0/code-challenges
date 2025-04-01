package technical.challenges;

import java.util.*;
import java.util.function.Predicate;

public class AgileSearchChallenge_ProblemC {

    private static final String CONTESTED_AREA = "Contested";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dimensions;
        int width, height;
        int employees;
        List<String> employeeList = new ArrayList<>();
        while (sc.hasNextLine()) {
            // Read dimensions, number of employees and employees data
            dimensions = sc.nextLine().split(" ");
            width = Integer.parseInt(dimensions[0]);
            height = Integer.parseInt(dimensions[1]);
            employees = Integer.parseInt(sc.nextLine());
            for (int i = 1; i <= employees; i++) {
                employeeList.add(sc.nextLine());
            }
            System.out.println(generateReport(width, height, employeeList));
            employeeList.clear();
        }
    }

    private static String generateReport(int width, int height, List<String> employeeList) {
        StringBuilder output = new StringBuilder();
        int totalArea = width * height;
        output.append("Total ");
        output.append(totalArea);
        output.append(System.getProperty("line.separator"));
        Map<String, Integer> employeesAreas = calculateAreas(employeeList);
        int unallocatedArea =
                totalArea - employeesAreas.values().stream().mapToInt(Integer::valueOf).sum();
        output.append("Unallocated ");
        output.append(unallocatedArea);
        output.append(System.getProperty("line.separator"));
        output.append("Contested ");
        output.append(employeesAreas.get(CONTESTED_AREA));
        output.append(System.getProperty("line.separator"));
        for (var entry : employeesAreas.entrySet()) {
            if (!entry.getKey().equals(CONTESTED_AREA)) {
                output.append(entry.getKey());
                output.append(" ");
                output.append(entry.getValue());
                output.append(System.getProperty("line.separator"));
            }
        }
        return output.toString();
    }

    private static Map<String, Integer> calculateAreas(List<String> employeeList) {
        String[] data;
        String employeeName;
        List<EmployeeData> employeesCoordinates = new ArrayList<>();
        Map<String, Integer> employeesAreas = new LinkedHashMap<>();
        List<EmployeeData> employeesContainedAreas = new ArrayList<>();

        // Fill data in a Map including employeeName and coordinates
        for (String employeeData : employeeList) {
            data = employeeData.split(" ");
            employeeName = data[0];
            int[][] coordinates = {{Integer.parseInt(data[1]), Integer.parseInt(data[2])},
                                   {Integer.parseInt(data[3]), Integer.parseInt(data[4])}};
            employeesCoordinates.add(new EmployeeData(employeeName, coordinates, 0));
        }

        boolean overlappedAreas, containedAreas, containedAreasReverse;
        int totalContestedArea = 0;
        // Check if there is contested space and calculate areas that overlap or contain each other
        for (int i = 0; i < employeeList.size() - 1; i++) {
            for (int j = i + 1; j < employeeList.size(); j++) {
                if (i != j) {
                    // Check if two areas overlap
                    overlappedAreas =
                            checkAreasOverlap(employeesCoordinates.get(i).getCoordinates(),
                                              employeesCoordinates.get(j).getCoordinates());
                    // Check if area1 contains area2
                    containedAreas =
                            checkAreasContainEachOther(employeesCoordinates.get(i).getCoordinates(),
                                                       employeesCoordinates.get(j)
                                                               .getCoordinates());
                    // Check if area2 contains area1
                    containedAreasReverse =
                            checkAreasContainEachOther(employeesCoordinates.get(j).getCoordinates(),
                                                       employeesCoordinates.get(i)
                                                               .getCoordinates());
                    if (overlappedAreas) {
                        int[][] employeeACoordinates = employeesCoordinates.get(i).getCoordinates();
                        int[][] employeeBCoordinates = employeesCoordinates.get(j).getCoordinates();
                        String employeeA = employeesCoordinates.get(i).getName();
                        String employeeB = employeesCoordinates.get(j).getName();
                        // Calculate overlapped areas
                        if (!(containedAreas || containedAreasReverse)) {
                            totalContestedArea += calculateOverlappedAreas(employeeA, employeeB,
                                                                           employeeACoordinates,
                                                                           employeeBCoordinates,
                                                                           employeesAreas);
                        }
                        // Calculate contained areas
                        else {
                            totalContestedArea += calculateContainedAreas(employeeA, employeeB,
                                                                          employeeACoordinates,
                                                                          employeeBCoordinates,
                                                                          employeesAreas,
                                                                          employeesContainedAreas);
                        }
                    }
                }
            }
        }
        Optional<EmployeeData> employeeMaxArea =
                employeesContainedAreas.stream().max(Comparator.comparing(EmployeeData::getArea));
        if (employeeMaxArea.isPresent()) {
            // Obtain overlapped area that was considered twice because of the algorithm
            int doublyContainedArea = getDoublyContainedArea(employeesContainedAreas);
            // Subtract contained area considered twice from total contested area
            totalContestedArea -= doublyContainedArea;
            // Add contained area considered twice to the largest area that contains other areas
            employeesAreas.put(employeeMaxArea.get().getName(),
                               employeesAreas.get(employeeMaxArea.get().getName()) +
                               doublyContainedArea);
        }
        employeesAreas.put(CONTESTED_AREA, totalContestedArea);

        // Calculate areas that don't overlap
        for (EmployeeData coordinates : employeesCoordinates) {
            if (!employeesAreas.containsKey(coordinates.getName())) {
                int area = Math.abs(
                        coordinates.getCoordinates()[0][0] - coordinates.getCoordinates()[1][0]) *
                           Math.abs(coordinates.getCoordinates()[0][1] -
                                    coordinates.getCoordinates()[1][1]);
                employeesAreas.put(coordinates.getName(), area);
            }
        }
        return employeesAreas;
    }

    private static boolean checkAreasOverlap(int[][] employeeArea1, int[][] employeeArea2) {
        return (employeeArea1[0][0] < employeeArea2[1][0]) &&
               (employeeArea2[0][0] < employeeArea1[1][0]) &&
               (employeeArea1[0][1] < employeeArea2[1][1]) &&
               (employeeArea2[0][1] < employeeArea1[1][1]);
    }

    private static int calculateOverlappedAreas(String employeeA, String employeeB,
                                                int[][] employeeACoordinates,
                                                int[][] employeeBCoordinates,
                                                Map<String, Integer> employeesAreas) {
        int areaEmployeeA = 0, areaEmployeeB = 0;
        if (!employeesAreas.containsKey(employeeA)) areaEmployeeA =
                Math.abs(employeeACoordinates[0][0] - employeeACoordinates[1][0]) *
                Math.abs(employeeACoordinates[0][1] - employeeACoordinates[1][1]);
        if (!employeesAreas.containsKey(employeeB)) areaEmployeeB =
                Math.abs(employeeBCoordinates[0][0] - employeeBCoordinates[1][0]) *
                Math.abs(employeeBCoordinates[0][1] - employeeBCoordinates[1][1]);

        int overlappedWidth = Math.min(employeeACoordinates[1][0], employeeBCoordinates[1][0]) -
                              Math.max(employeeACoordinates[0][0], employeeBCoordinates[0][0]);
        int overlappedHeight = Math.min(employeeACoordinates[1][1], employeeBCoordinates[1][1]) -
                               Math.max(employeeACoordinates[0][1], employeeBCoordinates[0][1]);
        int overLappedArea = 0;
        if (overlappedWidth > 0 && overlappedHeight > 0) {
            overLappedArea = overlappedWidth * overlappedHeight;
        }
        int tempAreaEmployeeA = employeesAreas.getOrDefault(employeeA, areaEmployeeA);
        int tempAreaEmployeeB = employeesAreas.getOrDefault(employeeB, areaEmployeeB);
        if (tempAreaEmployeeA > 0) employeesAreas.put(employeeA,
                                                      employeesAreas.getOrDefault(employeeA,
                                                                                  areaEmployeeA) -
                                                      overLappedArea);
        if (tempAreaEmployeeB > 0) employeesAreas.put(employeeB,
                                                      employeesAreas.getOrDefault(employeeB,
                                                                                  areaEmployeeB) -
                                                      overLappedArea);
        if (tempAreaEmployeeA == 0 && tempAreaEmployeeB == 0) return 0;
        else return overLappedArea;
    }

    private static boolean checkAreasContainEachOther(int[][] employeeArea1,
                                                      int[][] employeeArea2) {
        int employeeArea1Width = employeeArea1[1][0] - employeeArea1[0][0];
        int employeeArea1Height = employeeArea1[1][1] - employeeArea1[0][1];
        int employeeArea2Width = employeeArea2[1][0] - employeeArea2[0][0];
        int employeeArea2Height = employeeArea2[1][1] - employeeArea2[0][1];
        return ((employeeArea1[0][0] <= employeeArea2[0][0]) &&
                (employeeArea1[0][1] <= employeeArea2[0][1]) &&
                (employeeArea1[0][0] + employeeArea1Width >=
                 employeeArea2[0][0] + employeeArea2Width) &&
                (employeeArea1[0][1] + employeeArea1Height >=
                 employeeArea2[0][1] + employeeArea2Height));
    }

    private static int calculateContainedAreas(String employeeA, String employeeB,
                                               int[][] employeeACoordinates,
                                               int[][] employeeBCoordinates,
                                               Map<String, Integer> employeesAreas,
                                               List<EmployeeData> employeesContainedAreas) {
        int areaEmployeeA = 0, areaEmployeeB = 0;
        if (!employeesAreas.containsKey(employeeA)) areaEmployeeA =
                Math.abs(employeeACoordinates[0][0] - employeeACoordinates[1][0]) *
                Math.abs(employeeACoordinates[0][1] - employeeACoordinates[1][1]);
        if (!employeesAreas.containsKey(employeeB)) areaEmployeeB =
                Math.abs(employeeBCoordinates[0][0] - employeeBCoordinates[1][0]) *
                Math.abs(employeeBCoordinates[0][1] - employeeBCoordinates[1][1]);
        int overLappedArea;
        int tempAreaEmployeeA = employeesAreas.getOrDefault(employeeA, areaEmployeeA);
        int tempAreaEmployeeB = employeesAreas.getOrDefault(employeeB, areaEmployeeB);
        if (tempAreaEmployeeA >= tempAreaEmployeeB) {
            overLappedArea = tempAreaEmployeeB;
            if (tempAreaEmployeeA > 0) employeesAreas.put(employeeA,
                                                          employeesAreas.getOrDefault(employeeA,
                                                                                      areaEmployeeA) -
                                                          overLappedArea);
            employeesAreas.put(employeeB, 0);
        } else {
            overLappedArea = tempAreaEmployeeA;
            if (tempAreaEmployeeB > 0) employeesAreas.put(employeeB,
                                                          employeesAreas.getOrDefault(employeeB,
                                                                                      areaEmployeeB) -
                                                          overLappedArea);

            employeesAreas.put(employeeA, 0);
        }
        EmployeeData employeeDataA =
                new EmployeeData(employeeA, employeeACoordinates, tempAreaEmployeeA);
        EmployeeData employeeDataB =
                new EmployeeData(employeeB, employeeBCoordinates, tempAreaEmployeeB);
        if (!employeesContainedAreas.contains(employeeDataA))
            employeesContainedAreas.add(employeeDataA);
        if (!employeesContainedAreas.contains(employeeDataB))
            employeesContainedAreas.add(employeeDataB);
        return overLappedArea;
    }

    private static int getDoublyContainedArea(List<EmployeeData> employeesAreas) {
        if (employeesAreas.size() <= 2) return 0;
        Optional<EmployeeData> employeeMaxArea =
                employeesAreas.stream().max(Comparator.comparing(EmployeeData::getArea));
        int summedArea;
        String employeeNameMaxArea = employeeMaxArea.get().getName();
        Optional<EmployeeData> employeeSecondMaxArea = employeesAreas.stream()
                .filter(Predicate.not(x -> x.getName().equals(employeeNameMaxArea)))
                .max(Comparator.comparing(EmployeeData::getArea));
        String employeeNameSecondMaxArea = employeeSecondMaxArea.get().getName();
        summedArea = employeesAreas.stream()
                .filter(Predicate.not(x -> x.getName().equals(employeeNameMaxArea)))
                .filter(Predicate.not(x -> x.getName().equals(employeeNameSecondMaxArea)))
                .map(EmployeeData::getArea).reduce(0, Integer::sum);
        return summedArea;
    }

}
