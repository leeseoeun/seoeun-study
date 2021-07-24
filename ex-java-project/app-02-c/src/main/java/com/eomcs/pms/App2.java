package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    final int MAX_LENGTH = 5;

    int[] no = new int[MAX_LENGTH];
    String[] title = new String[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] startDate = new Date[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];
    String[] members = new String[MAX_LENGTH];

    int size = 0;

    System.out.println("[프로젝트]");

    for (int i=0; i<MAX_LENGTH; i++) {
      System.out.print("번호? ");
      no[i] = Integer.valueOf(sc.nextLine());
      //Integer.parseInt(sc.nextLine());

      System.out.print("프로젝트 명? ");
      title[i] = sc.nextLine();

      System.out.print("내용? ");
      content[i] = sc.nextLine();

      System.out.print("시작 일? ");
      startDate[i] = Date.valueOf(sc.nextLine());

      System.out.print("종료 일? ");
      endDate[i] = Date.valueOf(sc.nextLine());

      System.out.print("만든 이? ");
      owner[i] = sc.nextLine();

      System.out.print("팀원? ");
      members[i] = sc.nextLine();

      size++;

      System.out.println();

      System.out.println("계속 입력하시겠습니까? (y/N)");
      String input = sc.nextLine();

      if (!input.equalsIgnoreCase("y")) {   //기억!
        break;
      }
    }

    sc.close();

    System.out.println("----------");

    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i], title[i], startDate[i], endDate[i], owner[i]);
    }

  }

}
