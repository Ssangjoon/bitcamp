// 활용 - 클래스 파일 이름을 출력할 때 패키지 이름을 포함하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0730x {

  public static void main(String[] args) throws Exception {

    // 클래스 이름을 출력할 때 패키지 이름을 포함해야 한다.
    // 예) ch01.Test01
    // 예) ch22.a.Test14
    //
    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);
  }
  static boolean printClasses(File dir) {
    class JavaClassFilter implements FileFilter {

    }
    File[] files = dir.listFiles();

    for(File f : files) {
      if (f.isFile() && f.getName().endsWith(".class")){
        System.out.println(f.getName());
      } else if () {

      }
    }
  }
}


