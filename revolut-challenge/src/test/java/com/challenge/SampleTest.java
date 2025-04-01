package com.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleTest {
  @Test
  public void numberOneIsPrime() {
    assertTrue(Sample.isPrime(1));
  }

  @Test
  public void numberTwoIsPrime() {
    assertTrue(Sample.isPrime(2));
  }

  @Test
  public void numberThreeIsPrime() {
    assertTrue(Sample.isPrime(3));
  }

  @Test
  public void numberFourIsNotPrime() {
    assertFalse(Sample.isPrime(4));
  }
}
