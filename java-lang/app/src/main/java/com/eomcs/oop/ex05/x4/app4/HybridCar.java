package com.eomcs.oop.ex05.x4.app4;

import com.eomcs.oop.ex05.x4.app1.Car;

public class HybridCar extends Car{
  //하이브리드카 기능 추가 
  int kwh;
  public void chargeBattery(int kwh) {
    this.kwh = kwh;
  }

  //super클래스로부터 상속 받은 run()메서들 현재 클래스의 역할에 맞게 재정의한다. =>오버라이딩
  @Override
  public void run() {
    //하이브리드 전기차 구동 기능 추가
    if (kwh >0) {
      System.out.println("전기로 간다");
    } else {
      super.run();
    }
  }
}
