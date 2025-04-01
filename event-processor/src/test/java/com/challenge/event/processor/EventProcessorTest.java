package com.challenge.event.processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventProcessorTest {

  @Test
  public void givenEventsprocessThem() {
    Event event1 = new Event("4", 456L, "Box", 7L);
    Event event2 = new Event("5", 466L, "AAA", 1L);
    Event event3 = new Event("6", 506L, "xyz", 3L);
    System.out.println(EventProcessor.processEvent(event1));
    System.out.println(EventProcessor.processEvent(event2));
    System.out.println(EventProcessor.processEvent(event3));
    EventProcessor.clearEvents();
  }
}
