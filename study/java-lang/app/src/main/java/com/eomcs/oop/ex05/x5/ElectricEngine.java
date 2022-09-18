package com.eomcs.oop.ex05.x5;

public class ElectricEngine extends Option{

  public ElectricEngine(Car car) { //생성자에 자동차 객제주소를 받아서 내부 객체에 저장
    super(car);
  }

  int kwh;
  public void chargeBattery(int kwh) {
    this.kwh = kwh;
  }

  @Override
  public void start() {
    car.start();
  }
  @Override
  public void stop() {
    car.stop();
  }
  @Override
  public void run() {
    if (kwh > 0) {
      System.out.println("전기로 간다. ");
    } else {
      car.run();
    }
  }
}
