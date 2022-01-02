package com.eomcs.practice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class ContactController {



  @RequestMapping("/practice/list")
  public Object list() {
    return ArrayList0.toArray(); 
  }


  @RequestMapping("/practice/add")
  public Object add(Contact contact) {
    ArrayList0.add(contact);
    return ArrayList0.size;
  }

  @RequestMapping("/practice/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return ArrayList0.list[index];
  }

  @RequestMapping("/practice/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return 0;
    }
    return ArrayList0.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/practice/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    ArrayList0.remove(index);
    return 1;
  }

  static int indexOf(String email) {
    for (int i = 0; i < ArrayList0.size; i++) {
      Contact contact = (Contact)ArrayList0.list[i];
      if(contact.email.equals(email)) {
        return i;
      }
    }
    return -1;
  }

}


/*
 * 특정 기능을 수행하는 코드에 대해 메서드로 정의해두면 재사용이 쉽고 코드 유지보수가 쉽다.
- 코드를 메서드로 분리하는 경우
- 유사한 코드가 여러 곳에서 중복 사용될 때
- 코드의 기능을 명확하게 설명하고 싶을 때
 */

