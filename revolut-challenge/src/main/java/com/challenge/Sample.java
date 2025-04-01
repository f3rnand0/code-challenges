package com.challenge;

public class Sample {
  public static boolean isPrime(int number) {
    if (number == 0) {
      return false;
    }
    if (number == 1 || number == 2 || number == 3) {
      return true;
    }
    for(int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}
