package com.challenge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

class LoadBalancerTest {

  static LoadBalancer loadBalancer;
  static String address1;
  static String address2;

  @BeforeAll
  public static void setup() {
    loadBalancer = new LoadBalancer(1L);
    address1 = "addressA";
    address2 = "addressA";
  }

  @BeforeEach
  public void setupEach() {
    loadBalancer.addresses.clear();
  }

  @Test
  public void registerAddress_addressRegistered() {
    loadBalancer.registerAddress(address1);
    assertEquals(1, loadBalancer.addresses.size());
  }

  @Test
  public void registerDuplicateAddress_addressNotRegistered() {
    loadBalancer.registerAddress(address1);
    assertThrows(RuntimeException.class, () -> loadBalancer.registerAddress(address2));
  }

  @Test
  public void registerManyAddresses_loadBalancerIsFull() {
    for(int i = 0; i < 10; i++) {
      loadBalancer.registerAddress("address" + i);
    }
    assertThrows(RuntimeException.class, () -> loadBalancer.registerAddress(address1));
  }

  @Test
  public void getAddress_randomAddress() {
    for(int i = 0; i < 10; i++) {
      loadBalancer.registerAddress("address" + i);
    }
    String address1 = loadBalancer.get();
    String address2 = loadBalancer.get();
    assertEquals(address1, address2);
  }
}
