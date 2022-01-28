package com.eomcs.app1;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Worker extends Thread{
  Socket socket;

  public Worker (Socket socket ) {
    this.socket = socket;
  }

  @Override
  public void run() {
    try {
      Scanner in = new Scanner(socket.getInputStream());
      PrintStream out = new PrintStream(socket.getOutputStream());


      String requestLine = in.nextLine();
      String[] values = requestLine.split("/");

      while(true) {
        String str = in.nextLine();
        if (str.length() ==0 ) {
          break;
        }
      }
      String response = "Hello!";

      out.println("HTTP/1.1 200 OK");
      out.println("Content-Type: text/plain; charset=UTF-8");
      out.printf("Content-Length: %d\n", response);
      out.println();
      out.println(response);
      out.flush();


      if (values.length != 3) {
        out.println("계산식이 올바르지 않습니다.");

      }else {
        String op = values[0];
        if(op.equals("%2f")) {
          op = "/";
        }
        int a = Integer.parseInt(values[1]);
        int b = Integer.parseInt(values[2]);
        int result = 0;

        switch(op) {
          case "+" : 
            result = a + b;
            out.printf("상준 : %d %s %d = %d\n", a,op,b,result);
            break;
          case "-" : 
            result = a - b;
            out.printf("상준 : %d %s %d = %d\n", a,op,b,result);
            break;
          case "/" : 
            result = a / b;
            out.printf("상준 : %d %s %d = %d\n", a,op,b,result);
            break;
          case "*" : 
            result = a * b;
            out.printf("상준 : %d %s %d = %d\n", a,op,b,result);
            break;
          default:
            out.println("상준 : ㅎ 계산이 하고 싶어?");
        }
      }

      socket.close();
      System.out.println("클라이언트 연결 종료");

    } catch (Exception e) {
      e.printStackTrace();
    }
  } 
}
