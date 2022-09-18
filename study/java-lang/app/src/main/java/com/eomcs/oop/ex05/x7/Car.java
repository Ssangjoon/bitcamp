package com.eomcs.oop.ex05.x7;

public abstract class Car {
  int cc;
  int valve;

  public void start() {
    System.out.println("차에 시동을 걸다");
  }
  public void stop() {
    System.out.println("차에 시동을 끄다");
  }
  public abstract void run();

}
