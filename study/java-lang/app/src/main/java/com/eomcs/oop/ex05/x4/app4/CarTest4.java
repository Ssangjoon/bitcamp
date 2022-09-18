package com.eomcs.oop.ex05.x4.app4;


// 하이브리드카 만들기.
// 1) 기존 코드를 복제해온 후 하이브리드 기능 덧붙이기
public class CarTest4 {

  public static void main(String[] args) {
    // Car클래스를 상속받아 Hybrid 클래스를 만든 후 전기차 기능을 추가한다. 
    // => kwh 변수 추가 
    // => chargeBattery() 메서드 추가
    // => run() 변경

    HybridCar car = new HybridCar();
    car.chargeBattery(100);
    car.start();
    car.run();
    car.stop();

  }
}
