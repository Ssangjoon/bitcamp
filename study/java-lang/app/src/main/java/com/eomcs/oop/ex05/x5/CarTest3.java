package com.eomcs.oop.ex05.x5;

public class CarTest3 {

  public static void main(String[] args) {
    Sedan sedan = new Sedan();

    ElectricEngine electricOption = new ElectricEngine(sedan);
    electricOption.chargeBattery(100);

    Trailer trailer = new Trailer(electricOption);
    electricOption.start();
    electricOption.run();
    electricOption.stop();

    System.out.println("------------------------");

    Truck truck = new Truck();
    //Trailer trailer2 = new Trailer(truck);
    ElectricEngine electricOption2 = new ElectricEngine(truck);
    electricOption2.chargeBattery(100);
    electricOption2.start();
    electricOption2.run();
    electricOption2.stop();
  }

}
