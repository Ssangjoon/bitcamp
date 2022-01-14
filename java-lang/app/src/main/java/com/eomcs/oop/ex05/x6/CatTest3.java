package com.eomcs.oop.ex05.x6;

public class CatTest3 {


  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    SnowChain snowchain = new SnowChain(sedan);
    testCar(snowchain);

    System.out.println("------------------------");

    Truck truck = new Truck();
    BlackBox blackbox = new BlackBox(truck);
    testCar(blackbox);

    System.out.println("------------------------");

    Suv suv = new Suv();
    suv.active4wd(true);
    SnowChain snowchain2 = new SnowChain(suv);
    BlackBox blackbox2 = new BlackBox(snowchain2);
    testCar(blackbox2);
    //    BlackBox blackbox2 = new BlackBox(suv);
    //    SnowChain snowchain2 = new SnowChain(blackbox2);
    //    testCar(snowchain2);

  }

  static void testCar(Car car) {
    car.start();
    car.run();
    car.stop();
  }
}
