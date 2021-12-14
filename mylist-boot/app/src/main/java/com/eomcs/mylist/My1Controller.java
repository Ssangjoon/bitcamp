package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class My1Controller {
  String[] lunches = new String[7];
  int size = 0;

  @RequestMapping("/my1/list")
  public Object list() {
    String[] arr = new String[size];
    for(int i = 0; i < size; i++) {
      arr[i] = lunches[i];
    }
    return arr;
  }

  @RequestMapping("/my1/add")
  public Object add(String name, String tel, String distance, String menu, String price, String kg, String star) {
    String lunch = name + "," + tel + "," + distance + "," + menu + "," +price + "," + kg + "," + star;
    lunches[size++] = lunch;
    return size;
  }
  @RequestMapping("/my1/get")
  public Object get(String tel) {
    for (int i = 0; i < size; i++) {
      if (lunches[i].split(",")[1].equals(tel)) {
        return lunches[i];
      }
    }
    return "";
  }
  @RequestMapping("/my1/update")
  public Object update(String name, String tel, String distance, String menu, String price, String kg, String star) {
    String lunch = name + "," + tel + "," + distance + "," + menu + "," +price + "," + kg + "," + star;
    for (int i = 0; i < size; i++) {
      if (lunches[i].split(",")[1].equals(tel)) { 
        lunches[i] = lunch;
        return 1;
      }
    }
    return 0;
  }
  @RequestMapping("/my1/delete")
  public Object delete(String tel) {
    for (int i = 0; i < size; i++) {
      if (lunches[i].split(",")[1].equals(tel)) { 

        // 현재 위치의 다음 항목에서 배열 끝까지 반복 하며 앞으로 값을 당겨온다. 
        for (int j = i + 1; j < size; j++) {
          lunches[j - 1] = lunches[j];
        }
        size--;
        return 1;
      }
    }
    return 0;
  }

}
