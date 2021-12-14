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


  @RequestMapping("/contact/get")
  public Object get(String email) {
    for (int i = 0; i < size; i++) { //size : 배열에 입력된 개수
      /* 학습용
          String contact = contacts[i]; // 예)"u1,u1@test.com,1111,비트캠프"
          String[] values = contact.split(","); //예) {"u1","u1@test.com","1111","비트캠프"}
          if (values[1]equals(email){  //예) "u1@test.com"
          return contacts[i]
      };     */

      //실전
      if (contacts[i].split(",")[1].equals(email)) { 
        return contacts[i];
      }
    }
    return "";
  }
  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    String contact = name + "," + email + "," + tel + "," + company;
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { 
        contacts[i] = contact;
        return 1;
      }
    }
    return 0;
  }
  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { 

        // 현재 위치의 다음 항목에서 배열 끝까지 반복 하며 앞으로 값을 당겨온다. 
        for (int j = i + 1; j < size; j++) {
          contacts[j - 1] = contacts[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }
}


