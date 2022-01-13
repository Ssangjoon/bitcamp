package com.eomcs.oop.ex05.x2;

public class Engine {
  int cc; 
  int valve;

  public void run() {
    //하이브리드 전기차 구동 기능 추가
    if (kwh >0) {
      System.out.println("전기로 간다");
      return;
    }
    // 트레일러 장착 기능이 추가되었다면 다음과 같이 run() 메서드를 추가해야 한다. 
    if(trailer == null) {
      System.out.println("엔진이 돈다.");
    }else {
      System.out.println("느릿 느릿 조심히 움직인다. ");
    }
  }

  //1) 기존 코드에 기능 덧붙이기
  // 애플리케이션을 만들때마다 기능을 계추가하게 되어 
  // 한 클래스가 많은 역할을 수행하게 되었다.
  // 기존 코드를 변경하게 되면 버그가 추가될 가능성이 높아진다. 
  // 어떤 애플리케이션에서는 트럭 기능만 필요한 앱을 만드는 입장에서는 불필요한 기능 까지 가져가게된다. 
  // 유지보수에 좋지 안다. 
  public void start() {
    System.out.println("시동 건다");
  }
  public void stop() {
    System.out.println("시동 끈다.");
  }
  //트럭 기능 추가 
  public void dump() {
    System.out.println("짐내린다.");
  }

  // 트레일러 붙이는 기능 추가 
  CampingTrailer trailer;
  public void setTrailer(CampingTrailer trailer) {
    this.trailer = trailer;
  }

  //하이브리드카 기능 추가 
  int kwh;
  public void chargeBattery(int kwh) {
    this.kwh = kwh;
  }
}
