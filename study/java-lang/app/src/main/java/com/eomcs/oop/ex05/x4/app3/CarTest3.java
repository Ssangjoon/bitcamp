package com.eomcs.oop.ex05.x4.app3;

// 캠핑카 만들기.
// 1) 기존 코드를 상속하여 새 클래스를 만든 후 기능 덧붙이기
public class CarTest3 {

  public static void main(String[] args) {
    // CampingTrailer 클래스를 만드다.
    // Engine 클래스에 트레일러를 설정하는 변수와 메서드를 추가한다. 

    // Car클래스를 상속받아 트레일려 연결 기능을 추가 
    // - trailer, SetTrailer() 추가 
    // - run() 변경 

    CampingTrailer trailer = new CampingTrailer();

    TrailerCar car = new TrailerCar();
    car.setTrailer(trailer);
    car.start();
    car.run();
    car.stop();
  }
}
