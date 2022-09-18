package com.eomcs.oop.ex11.overview.step2;

public class Test3 {
  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.offer("홍길동");
    myQueue.offer("이상준");
    myQueue.offer("엄홍길");
    myQueue.offer("엄기준");
    myQueue.offer("엄마");
    myQueue.offer("아빠");


    QueueIterator iterator = new QueueIterator(myQueue);
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}

