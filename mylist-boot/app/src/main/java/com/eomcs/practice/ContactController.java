package com.eomcs.practice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class ContactController {


  @RequestMapping("/contact/list")
  public Object list() {
    return ArrayList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    ArrayList.add(contact);
    return ArrayList.size;
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return "";
    }

    return ArrayList.contacts[index];
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = ArrayList.indexOf(contact.email);
    if (index == -1) {
      return 0;
    }

    return ArrayList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = ArrayList.indexOf(email);
    if (index == -1) {
      return 0;
    }

    ArrayList.remove(index);
    return 1;
  }
}


/*
 * 특정 기능을 수행하는 코드에 대해 메서드로 정의해두면 재사용이 쉽고 코드 유지보수가 쉽다.
- 코드를 메서드로 분리하는 경우
- 유사한 코드가 여러 곳에서 중복 사용될 때
- 코드의 기능을 명확하게 설명하고 싶을 때
 */

