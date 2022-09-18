package com.eomcs.oop.ex05.x4.app1;

import com.eomcs.oop.ex05.x4.Engine;

public class Car extends Engine{

  public void start() {
    System.out.println("시동 건다");
  }
  public void stop() {
    System.out.println("시동 끈다.");
  }

}
