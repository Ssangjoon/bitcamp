package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class BookController {

  // Contact 객체 목록을 저장할 메모리 준비
  // => Object[] list = new Object[5];
  // => int size = 0;
  ArrayList bookList = new ArrayList();

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @PostMapping(value = "/book/add")
  public Object add(@RequestBody Book book) {
    //    System.out.println(book);
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(String press) {
    int index = indexOf(press);
    if (index == -1) {
      return "";
    }
    return bookList.get(index);
  }

  @RequestMapping("/book/update")
  public Object update(Book book) {
    int index = indexOf(book.getPress());
    if (index == -1) {
      return 0;
    }

    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(String press) {
    int index = indexOf(press);
    if (index == -1) {
      return 0;
    }

    bookList.remove(index);
    return 1;
  }

  int indexOf(String press) {
    for (int i = 0; i < bookList.size(); i++) {
      Book contact =  (Book) bookList.get(i);
      if (contact.getPress().equals(press)) { 
        return i;
      }
    }
    return -1;
  }
}




