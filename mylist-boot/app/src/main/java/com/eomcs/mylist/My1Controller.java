package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
      if (contacts[i].split(",")[1].equals(date)) { 
        contacts[i] = contact;
        return 1;
      }
    }
    return 0;
  }


}
