package com.challenge.event.processor;


public class Event implements Comparable<Event>{
  private String identifier;
  private Long timestamp;
  private String payload;
  private Long checksum;

  public Event(String identifier, Long timestamp, String payload, Long checksum) {
    this.identifier = identifier;
    this.timestamp = timestamp;
    this.payload = payload;
    this.checksum = checksum;
  }

  public Event(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public Long getChecksum() {
    return checksum;
  }

  public void setChecksum(Long checksum) {
    this.checksum = checksum;
  }

  @Override
  public int compareTo(Event other) {
    return this.timestamp.compareTo(other.timestamp);
  }
}
