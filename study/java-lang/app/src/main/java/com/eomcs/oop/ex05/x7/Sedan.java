package com.eomcs.oop.ex05.x7;

public class Sedan extends Car{
  int auto;
  boolean openedSunroof;

  @Override
  public void run() {
    System.out.println("세단이 달린다");
  }
  public void openSunroof() {
    System.out.println("썬루프가 열린다");
    this.openedSunroof = true;
  }
  public void closeSunroof() {
    System.out.println("썬루프가 닫힌다");
    this.openedSunroof = false;  // 이것도 if문으로 작동 여부를 골라야 하는거 아닌가? 
  }
}
