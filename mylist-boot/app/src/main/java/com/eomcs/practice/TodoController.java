package com.eomcs.practice;

import org.springframework.web.bind.annotation.RequestMapping;

public class TodoController {


  @RequestMapping("/todo/list")
  public Object list() {
    return ArrayList2.toArray(); 
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    ArrayList2.add(todo);
    return ArrayList2.size;
  }


  @RequestMapping("/todo/get")
  public Object get(int index) {
    int index = ArrayList2.indexOf(email);
    if (index == -1) {
      return "";
    }

    return ArrayList2.todos[index];
  }

  @RequestMapping("/todo/update")
  public Object update(Todo todo) {
    int index = ArrayList2.indexOf(todo.email);
    if (index == -1) {
      return 0;
    }

    return ArrayList2.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo/delete")
  public Object delete(String email) {
    int index = ArrayList2.indexOf(email);
    if (index == -1) {
      return 0;
    }

    ArrayList2.remove(index);
    return 1;
  }
}
