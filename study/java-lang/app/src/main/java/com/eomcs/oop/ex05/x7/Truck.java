package com.eomcs.oop.ex05.x7;

public class Truck extends Car{
  int weight;

  @Override
  public void start() { 
    this.launch();
  }
  @Override
  public void stop() {
    this.stopping();
  }
  @Override
  public void run() {
    this.go();
  }
  public void launch() {
    System.out.println("트럭이 시동을 켠다");
  }
  public void stopping() {
    System.out.println("트럭 시동을 끈다");
  }
  public void go() {
    System.out.println("트럭이 달린다.");
  }
  public void dump() {
    System.out.println("짐을 많이 싫을 수 있다.");
  }
}
