package technical.challenges;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

public class VanHackChallenge4 {

    public static void main(String[] args) {
        System.out.println(mostFrequentDays(2022));
        System.out.println(mostFrequentDays(2024));
        System.out.println(mostFrequentDays(2427));
        System.out.println(mostFrequentDays(2185));
        System.out.println(mostFrequentDays(2860));
    }

    public static ArrayList<String> mostFrequentDays(int year) {
        List<String> days = List.of(DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL_STANDALONE,
                                                                    Locale.getDefault()),
                                    DayOfWeek.TUESDAY.getDisplayName(TextStyle.FULL_STANDALONE,
                                                                     Locale.getDefault()),
                                    DayOfWeek.WEDNESDAY.getDisplayName(TextStyle.FULL_STANDALONE,
                                                                       Locale.getDefault()),
                                    DayOfWeek.THURSDAY.getDisplayName(TextStyle.FULL_STANDALONE,
                                                                      Locale.getDefault()),
                                    DayOfWeek.FRIDAY.getDisplayName(TextStyle.FULL_STANDALONE,
                                                                    Locale.getDefault()),
                                    DayOfWeek.SATURDAY.getDisplayName(TextStyle.FULL_STANDALONE,
                                                                      Locale.getDefault()),
                                    DayOfWeek.SUNDAY.getDisplayName(TextStyle.FULL_STANDALONE,
                                                                    Locale.getDefault()));
        String firstDay = DayOfWeek.from(LocalDate.of(year, Month.JANUARY, 1))
                .getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault());
        int startDay = days.indexOf(firstDay);
        Map<String, Integer> numberOfDays = new LinkedHashMap<>();
        numberOfDays.put(
                DayOfWeek.MONDAY.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()), 0);
        numberOfDays.put(
                DayOfWeek.TUESDAY.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()),
                0);
        numberOfDays.put(
                DayOfWeek.WEDNESDAY.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()),
                0);
        numberOfDays.put(
                DayOfWeek.THURSDAY.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()),
                0);
        numberOfDays.put(
                DayOfWeek.FRIDAY.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()), 0);
        numberOfDays.put(
                DayOfWeek.SATURDAY.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()),
                0);
        numberOfDays.put(
                DayOfWeek.SUNDAY.getDisplayName(TextStyle.FULL_STANDALONE, Locale.getDefault()), 0);
        int i, j;
        for (Month month : Month.values()) {
            i = 0;
            j = 0;
            if (month.equals(Month.JANUARY) || month.equals(Month.MARCH) ||
                month.equals(Month.MAY) || month.equals(Month.JULY) || month.equals(Month.AUGUST) ||
                month.equals(Month.OCTOBER) || month.equals(Month.DECEMBER)) {
                while (i < 3) {
                    if (startDay == 7) startDay = 0;
                    numberOfDays.put(days.get(startDay), numberOfDays.get(days.get(startDay)) + 1);
                    startDay++;
                    i++;
                }
                while (j < 7) {
                    numberOfDays.put(days.get(j), numberOfDays.get(days.get(j)) + 4);
                    j++;
                }
            } else if (month.equals(Month.APRIL) || month.equals(Month.JUNE) ||
                       month.equals(Month.SEPTEMBER) || month.equals(Month.NOVEMBER)) {
                while (i < 2) {
                    if (startDay == 7) startDay = 0;
                    numberOfDays.put(days.get(startDay), numberOfDays.get(days.get(startDay)) + 1);
                    startDay++;
                    i++;
                }
                while (j < 7) {
                    numberOfDays.put(days.get(j), numberOfDays.get(days.get(j)) + 4);
                    j++;
                }
            }
            // For February
            else {
                // Only on leap year add an additional day
                if (Year.of(year).isLeap()) {
                    if (startDay == 7) startDay = 0;
                    numberOfDays.put(days.get(startDay), numberOfDays.get(days.get(startDay)) + 1);
                    startDay++;
                }
                while (j < 7) {
                    numberOfDays.put(days.get(j), numberOfDays.get(days.get(j)) + 4);
                    j++;
                }
            }
        }
        //numberOfDays.forEach((key, value) -> System.out.println(key + ":" + value));
        int maxNumber = Collections.max(numberOfDays.values());
        return (ArrayList<String>) numberOfDays.entrySet().stream()
                .filter(entry -> entry.getValue() == maxNumber).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
