package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  static Scanner sc = new Scanner(System.in);

  static String promptString(String title) {
    System.out.print(title);
    return sc.nextLine();
  }

  static int promptInt(String title) {
    return Integer.parseInt(promptString(title));
  }

  static Date promptDate(String title) {
    return Date.valueOf(promptString(title));
  }

  static void close() {
    sc.close();
  }


}
