package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam0110Test {

  static void printSpaces(int len) {
    int spaceCnt = 1;
    while (spaceCnt <= len) {
      System.out.print(" ");
      spaceCnt++;
    }
  }
  static void printStars(int len) {
    for (int i = 0; i<len; i++) {
      System.out.print("*");
    } 
  }
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    int starLen = 1;
    while (starLen <= len) {
      printSpaces((len-starLen) / 2);

      for(int starLen = 1; starLen <= len; starLen +=2) {
        printSpaces()
      }

      System.out.println();
      starLen += 2;
    }
  }
}