package com.eomcs.oop.ex11.overview.step1;

public class Test3 {
  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.offer("홍길동");
    myQueue.offer("이상준");
    myQueue.offer("엄홍길");
    myQueue.offer("엄기준");
    myQueue.offer("엄마");
    myQueue.offer("아빠");


    while(myQueue.size() > 0) {
      System.out.println(myQueue.poll());
    }
    System.out.println(myQueue.size());
  }
}

