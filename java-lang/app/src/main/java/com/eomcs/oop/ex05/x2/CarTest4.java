package com.eomcs.oop.ex05.x2;

// 하이브리드카 만들기.
// 1) 기존 코드에 기능 덧붙이기
public class CarTest4 {

  public static void main(String[] args) {
    // Engine 클래스에 시동 걸고 끄는 기능을 추가한다. 
    // => start(), stop() 메서드 추가
    // => run()메서드 변경 

    CampingTrailer trailer = new CampingTrailer();

    Engine car = new Engine();
    //  car.chargeBattery(100);
    car.start();
    car.run();
    car.stop();

  }
}
