package com.challenge;

// It should be possible to register an instance, identified by an address
// Each address should be unique, it should not be possible to register the same address more than
// once
// Load Balancer should accept up to 10 addresses

// Develop an algorithm that, when invoking the Load Balancer 's get() method multiple times,
// should return one backend-instance choosing between the registered ones randomly.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
  List<String> addresses = new ArrayList<>();
  long seed;

  LoadBalancer(long seed) {
    this.seed = seed;
  }

  public void registerAddress(String address) {
    if (addresses.contains(address)) {
      throw new RuntimeException("Address is already registered");
    }
    if (addresses.size() < 10) {
      addresses.add(address);
    } else {
      throw new RuntimeException("Load Balancer is full. Cannot register more addresses");
    }
  }

  public String get() {
    Random random = new Random();
    int index= random.nextInt(0,9);
    return addresses.get(index);
  }
}
