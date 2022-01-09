package com.eomcs.mylist.domain;

public class Todo {
  String title;
  boolean done;


  public Todo(String csvStr) {
    // 예)csvStr = "a,a@test.com,010,x"

    String[] values = csvStr.split(","); // ["a","a@test.com","010","x"]
    this.setTitle(values[0]);  // 배열에 들어있는 각 항목을 객체의 필드에 저장한다. 
    this.setDone(Boolean.valueOf(values[1]));
  }


  public static Todo valueOf(String csvStr) {
    // 예)csvStr = "a,a@test.com,010,x"

    String[] values = csvStr.split(","); // ["a","a@test.com","010","x"]

    Todo todo = new Todo();
    todo.setTitle(values[0]);  
    todo.setDone(Boolean.valueOf(values[1]));

    return todo;
  }

  public String toCsvString() {
    return String.format("%s,%b",
        this.getTitle(),
        this.isDone());
  }

  public Todo() {
    System.out.println("Todo() 호출");
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public boolean isDone() {
    return done;
  }
  public void setDone(boolean done) {
    this.done = done;
  }

  @Override
  public String toString() {
    return "Todo [title=" + title + ", done=" + done + "]";
  } 

}
