package com.eomcs.oop.ex05.x6;

public abstract class Car {
  int cc;
  int valve; 

  public void start() {
    System.out.println("차 시동 걸다");
  }
  public void stop() {
    System.out.println("차 시동 끄다");
  }
  public abstract void run();
}
