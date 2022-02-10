package com.eomcs.oop.ex11.overview.step2;

public class Test1 {
  public static void main(String[] args) {
    MyList myList = new MyList();
    myList.add("홍길동");
    myList.add("이상준");
    myList.add("엄홍길");
    myList.add("엄기준");
    myList.add("엄마");
    myList.add("아빠");

    ListIterator iterator = new ListIterator(myList);
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
