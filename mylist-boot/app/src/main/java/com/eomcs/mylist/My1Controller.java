package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
//이 클래스가 클라이언트 요청을 처리한다는 것을 표시한다.
//이 표시(애노테이션)가 붙어 있어야만 스프링부트가 인식한다. 
public class My1Controller {
  String[] contacts = new String[4];
  int size = 0;

  @RequestMapping("/my1/list")
  public Object list() {
    String[] arr = new String[size];
    for (int i=0; i < size; i++) {
      arr[i] = contacts[i];
    }
    return arr;
  }

  @RequestMapping("/my1/add")
  public Object add(String date, String subject, String underStanding, String face) {
    contacts[size ++] = date + "," + subject + "," + underStanding + "," + face;
    return size; 
  }

  @RequestMapping("/my1/get")
  public Object get(String date) {
    //    for (String contact : contacts) {
    //      if (date.equals(contact.split(",")[0])) {
    for (int i=0; i<size; i++) {
      if(contacts[i].split(",")[0].equals(date)) {
        return contacts[i];
      }
    }
    return "";
  }
  @RequestMapping("/my1/update")
  public Object update(String date, String subject, String underStanding, String face) {
    String contact = date + "," + subject + "," + underStanding + "," + face;
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[0].equals(date)) { 
        contacts[i] = contact;
        return 1;
      }
    }
    return 0;
  }

  @RequestMapping("/my1/delete")
  public Object delete(String date) {
    for (int i = 0; i < size; i++) {
      if (contacts[i].split(",")[0].equals(date)) { 

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
