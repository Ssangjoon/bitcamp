package com.eomcs.oop.ex11.overview.step1;

public class Test1 {
  public static void main(String[] args) {
    MyList myList = new MyList();
    myList.add("홍길동");
    myList.add("이상준");
    myList.add("엄홍길");
    myList.add("엄기준");
    myList.add("엄마");
    myList.add("아빠");

    for(int i = 0; i < myList.size(); i++) {
      System.out.println(myList.get(i));
    }
    System.out.println(myList.size());
  }
}
