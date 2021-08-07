package com.eomcs.util;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {

  static Scanner sc = new Scanner(System.in);

  public static String promptString(String title) {
    System.out.print(title);
    return sc.nextLine();
  }

  public static int promptInt(String title) {
    return Integer.parseInt(promptString(title));
  }

  public static Date promptDate(String title) {
    return Date.valueOf(promptString(title));
  }

  public static void close() {
    sc.close();
  }


}
