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
    String[] arr = new String[size]; 
    for(int i=0; i<size; i++) {
      arr[i] = contacts[i]; 
    }
    return arr; 
  }
  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    contacts[size++] = createCSV(name, email, tel, company);
    return size;
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contacts[index];
  }
  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    int index = indexOf(email);
    if (index == 1) {
      return 0;
    }
    contacts[index] = createCSV(name, email, tel, company);
    return 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    remove(index);
    return 1;
  }
  // 기능 : 입력받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어준다. 
  String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }

  // 이메일로 연락처 정보를 찾는다.
  // 찾은 연락처의 배열 인덱스를 리턴한다. 
  int indexOf(String email) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) { 
        return i;
      }
    }  
    return -1;
  }
  //기능 
  // 배열에서 지정한 항목을 삭제한다. 
  //
  String remove(int index) {
    String old = contacts[index];
    for (int i = index + 1; i < size; i++) {
      contacts[i - 1] = contacts[i];
    }
    size--;
    return old; 
  }
}


