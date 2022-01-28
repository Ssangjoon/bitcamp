package com.eomcs.app1;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) throws Exception{
    System.out.println("[계산기 서버]");

    //1) 클라이언트 App의 연결을 준비한다. 
    ServerSocket serversocket = new ServerSocket(8888);

    while(true) {
      System.out.println("클라이언트의 연결을 기다림"); 
      Socket socket = serversocket.accept(); //  클라이언트가 연결될 때까지 리턴하지 않는다. 
      System.out.println("클라이언트와 연결됨");

      Worker worker = new Worker(socket);
      worker.start(); 
      System.out.println("작업자에게 클라이언트 요청을 맡겼음!");
    }

  }
  // 서버쪽 연결 도구 종료
  //    serversocket.close();
  //    System.out.println("서버 종료");

}


