package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Book;
import com.eomcs.util.ArrayList;

@RestController 
public class BookController {

  ArrayList bookList = new ArrayList();

  public BookController() throws Exception {
    System.out.println("BookController() 호출됨!");
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("books.ser2")));

      //    while (true) {
      //      try {
      //        Book book = new Book();
      //        book.setTitle(in.readUTF());
      //        book.setAuthor(in.readUTF());
      //        book.setPress(in.readUTF());
      //        book.setPage(in.readInt());
      //        book.setPrice(in.readInt());
      //        //book.setReadDate(Date.valueOf(in.readUTF()));
      //        String date = in.readUTF();
      //        if(date.length() > 0) {
      //          book.setReadDate(Date.valueOf(date));
      //        }
      //        book.setFeed(in.readUTF());
      //
      //        bookList.add(book);
      //
      //      } catch (Exception e) {
      //        break;
      //      }
      //    }
      bookList = (ArrayList)in.readObject();

      in.close();
    } catch (Exception e) {
      System.out.println("독서록 데이터를 로딩 하는 중 오류 발생");
    }}

  @RequestMapping("/book/list")
  public Object list() {
    return bookList.toArray(); 
  }

  @RequestMapping("/book/add")
  public Object add(Book book) {
    bookList.add(book);
    return bookList.size();
  }


  @RequestMapping("/book/get")
  public Object get(int index) {
    if (index < 0 || index >= bookList.size()) {
      return "";
    }
    return bookList.get(index);
  }

  @RequestMapping("/book/update")
  public Object update(int index, Book book) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.set(index, book) == null ? 0 : 1;
  }

  @RequestMapping("/book/delete")
  public Object delete(int index) {
    if (index < 0 || index >= bookList.size()) {
      return 0;
    }
    return bookList.remove(index) == null ? 0 : 1;
  }

  @RequestMapping("/book/save")
  public Object save() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("books.ser2")));

    //    Object[] arr = bookList.toArray();
    //    for (Object obj : arr) {
    //      Book book = (Book) obj;
    //      out.writeUTF(book.getTitle());
    //      out.writeUTF(book.getAuthor());
    //      out.writeUTF(book.getPress());
    //      out.writeInt(book.getPage());
    //      out.writeInt(book.getPrice());
    //      out.writeUTF(book.getReadDate().toString());
    //      out.writeUTF(book.getFeed());
    //    }
    out.writeObject(bookList);

    out.close();
    return bookList.size();
  }
}




