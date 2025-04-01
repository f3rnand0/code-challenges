package com.challenge.event.processor;

import java.util.NavigableSet;
import java.util.TreeSet;


public class EventProcessor {
  public static TreeSet<Event> events = new TreeSet<>();

  private static String template1 = "Event %s: average %d, windows ends %d";
  private static String template2 = "Event %s: Invalid checksum";

  public static String processEvent(Event event) {
    events.add(event);
    Event eventStart = new Event(events.last().getTimestamp() -60);
    NavigableSet<Event> subset = events.subSet(eventStart, true, events.last(), true);
    for (Event e : subset) {
      if (!validateChecksum(e.getPayload(), e.getChecksum())) {
        return String.format(template2, event.getIdentifier());
      }
    }

    return String.format(template1, event.getIdentifier(), 0, events.last().getTimestamp());
  }

  public static void clearEvents() {
    events.clear();
  }

  private static boolean validateChecksum(String payload, Long checksum) {
    int sum = 0;
    for (char c : payload.toCharArray()) {
      sum += c;
    }
    //System.out.println("sum = " + sum);
    return sum % 10 == checksum;
  }

  private static double average(NavigableSet<Event> events) {
    if (events.isEmpty()) {
      return 0;
    }
    int totalLength = 0;
    for (Event event : events) {
      totalLength += event.getPayload().length();
    }
    return (double) totalLength / events.size();
  }

}
