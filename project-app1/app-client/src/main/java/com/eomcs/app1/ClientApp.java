package com.eomcs.app1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {

  public static void main(String[] args) throws UnknownHostException, IOException {
    System.out.println("[계산기 클라이언트]");

    //1) 서버 애플리케이션과 네트워크 연결을 수행한다. 
    Socket socket = new Socket("127.0.0.1", 8888); // 서버와 연결될때까지 객체를 생성하지 않는다. 
    System.out.println("서버와 연결되었음");

    // 데이터를 주고 받기 위한 입출력 스트림을 준비한다. 
    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    // 서버에 데이터를 보낸다. 
    out.println("이상준");

    // 서버가 응답한 데이터를 읽는다. 
    String response = in.nextLine(); // 서버가 한줄의 문자열을 리턴할 때 까지 리턴하지 않는다. 
    System.out.println("==> "+ response);

    //입출력 도구를 다 사용했으면 자원을 해제한다. 
    out.close();
    in.close();

    //2) 서버 애플리케이션과 연결된 것을 끊는다. 
    socket.close();
    System.out.println("서버연결 종료");
  }

}
