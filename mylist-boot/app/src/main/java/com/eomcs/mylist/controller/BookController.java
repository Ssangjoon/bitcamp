package com.eomcs.mylist.controller;

import java.io.FileReader;
import java.io.FileWriter;
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


  public BookController() throws Exception {
    bookList = new ArrayList();
    System.out.println("BookController() 호출됨 ");

    FileReader in = new FileReader("books.csv");

    StringBuilder buf = new StringBuilder();
    int c;
    while ((c = in.read()) != -1) {
      if (c == '\n') { // 만약 읽은 문자가 줄바꿈 명령이라면 지금까지 읽은 csv데이터를 분석하여 Contact객체에 담는다. 
        bookList.add(Book.valueOf(buf.toString())); //파일에서 읽은 csv데이터로 객체를 초기화시킨후 목록에 등록한다. 
        buf.setLength(0); // 다음 데이터를 읽기 위해 버퍼를 초기화 시킨다. 

      } else {  //문자를 읽을 때마다 버퍼에 임시 보관한다      
        buf.append((char)c);
      }
    }

    in.close();
  }

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

  @RequestMapping("/book/save")
  public Object save() throws Exception {
    FileWriter out = new FileWriter("books.csv"); //따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 파일이 생성된다. 

    Object[] arr = bookList.toArray();
    for (Object obj : arr) {
      Book book = (Book) obj;
      out.write(book.toCsvString() + "\n");
    }
    out.close();
    return arr.length;
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




