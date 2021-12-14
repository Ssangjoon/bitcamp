package com.eomcs.web.javascript;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex00Controller {

  @RequestMapping("/javascript/ex00/exam06")
  public Object exam06() {
    return "<ul><li>홍길동</li><li>임꺽정</li><li>유관순</li></ul>";
    // UI조각을 만들어 던진다. server rendering?
  }

  @RequestMapping("/javascript/ex00/exam07")
  public Object exam07() {
    String[] names = {"홍길동", "임꺽정", "유관순"};
    return names;// 클라이언트에 보내는 것은 UI가 아니라 데이터이다. 
    /* ==> 안드로이드,아이폰,,,,, 기타등등 기기가 많이 생겨나면서 데이터만 보내주고 
    알아서 처리하길,,,,, 즉 더 많은 기기에서 데이터를 활용하고 UI는 받는 쪽에서 알아서 하는 방향으로 
     */
  }
}
