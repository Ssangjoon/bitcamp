package com.eomcs.app1;

public class CommandHandler2 {
  void doHelp() {
    System.out.println("add [값1] [값2]   더하기 계산을 수행한다.");
    System.out.println("minus [값1] [값2]   빼기 계산을 수행한다.");
    System.out.println("help                   도움말을 출력한다.");
  }

  void doAdd(Command2 command2) {
    if (command2.getParamSize() != 3) {
      System.out.println("명령어 입력 형식이 옳지 않습니다.");
    } else {
      int v1 = command2.getInt(0);
      int v2 = command2.getInt(1);
      System.out.printf("%d + %d = %d", v1, v2, v1+v2);
    }
  }
  void doMinus(Command2 command2) {
    if (command2.getParamSize() != 3) {
      System.out.println("명령어 입력 형식이 옳지 않습니다.");
    } else {
      int v1 = command2.getInt(0);
      int v2 = command2.getInt(1);
      System.out.printf("%d - %d = %d", v1, v2, v1-v2);
    }
  }


}
