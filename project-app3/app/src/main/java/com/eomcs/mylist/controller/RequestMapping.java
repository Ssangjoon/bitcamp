package com.eomcs.mylist.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE}) //value = {ElementType.METHOD, ...} 하나일 때는 축약 가능하다. 
@Retention(RetentionPolicy.SOURCE)
public @interface RequestMapping {
  String value(); //페이지 컨틀롤러의 path 를 저장할 프로퍼티  
}
