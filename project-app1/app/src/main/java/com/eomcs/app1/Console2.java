package com.eomcs.app1;

import java.util.Arrays;
import java.util.Scanner;

public class Console2 {
  Scanner keyScan= new Scanner(System.in);

  Command2 prompt() {
    System.out.println("> ");
    String[] values = keyScan.nextLine().split(" ");
    return new Command2(values[0], Arrays.copyOfRange(values, 1, values.length));
  }

  void close() {
    keyScan.close();
  }
}
