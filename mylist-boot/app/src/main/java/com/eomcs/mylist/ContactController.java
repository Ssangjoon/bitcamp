package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청을 처리한다는 것을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 인식한다. 
public class ContactController {
  // add와 list는 
  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    String[] arr = new String[size]; //배열에 저장된 값만 복사할 새 배열을 만든다. 
    for(int i=0; i<size; i++) {
      arr[i] = contacts[i]; //전체 배열에서 값이 들어있는 항목만 복사한다. 
      //arr[i] = contacts[size];
    }// contact[size]가 아닌이유?
    return arr; // 복사한 항목들을 담고 있는 새 배열들을 리턴한다. 
  }
  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    String contact = name + "," + email + "," + tel + "," + company;
    contacts[size++] = contact;
    return size;
  }

}


