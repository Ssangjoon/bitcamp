package com.eomcs.oop.ex11.overview.step1;

public class Test2 {
  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    myStack.push("홍길동");
    myStack.push("이상준");
    myStack.push("엄홍길");
    myStack.push("엄기준");
    myStack.push("엄마");
    myStack.push("아빠");


    while(myStack.size() > 0) {
      System.out.println(myStack.pop());
    }

    System.out.println(myStack.size());
  }
}

