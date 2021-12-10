package com.eomcs.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //클라이언트 요청을 처리하는 역할
public class ContactController {
  //인스턴스 변수 
  // => 모든 인스턴스 메서드가 공유한다. 
  String[] contacts = new String[5];
  int size=0;
  @GetMapping("/contact/list")
  public Object list() {
    //    String[] contacts = {
    //        "홍길동, hong@test.com, 010-1111-2222, 비트캠프",
    //        "홍길동2, hong@test.com, 010-1111-2222, 비트캠프",
    //        "홍길동3, hong@test.com, 010-1111-2222, 비트캠프"
    //    };
    String[] records = new String[size];
    for(int i=0; i<size;i++) {
      records[i]=contacts[i];
    }
    return contacts;
  }

  @GetMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {

    contacts[size++] = name + "," + email + "," + tel + "," + company;
    //size++;

    return size;
  }

}
