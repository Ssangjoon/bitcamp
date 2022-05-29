package com.eomcs.mylist.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //value = {ElementType.METHOD, ...} 하나일 때는 축약 가능하다. 
@Retention(RetentionPolicy.SOURCE)
public @interface RequestMapping {

}
