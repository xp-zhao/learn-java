package com.example.client;

import java.util.concurrent.TimeUnit;

public class RegisterClientTest {

//  @Test
  public void start() {
    RegisterClient registerClient = new RegisterClient();
    registerClient.start();
  }

  public static void main(String[] args) throws InterruptedException {
    RegisterClient registerClient = new RegisterClient();
    registerClient.start();
    TimeUnit.SECONDS.sleep(5);
    registerClient.showdown();
  }
}
