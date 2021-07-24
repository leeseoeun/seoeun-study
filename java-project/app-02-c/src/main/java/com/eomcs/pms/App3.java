package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    final int MAX_LENGTH = 5;

    int[] no = new int[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] deadline = new Date[MAX_LENGTH];
    int[] status = new int[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];

    int size = 0;

    System.out.println("[작업]");

    System.out.print("프로젝트? ");
    String project = sc.nextLine();

    for (int i=0; i<MAX_LENGTH; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(sc.nextLine());

      System.out.print("내용? ");
      content[i] = sc.nextLine();

      System.out.print("완료 일? ");
      deadline[i] = Date.valueOf(sc.nextLine());

      System.out.println("상태? ");
      System.out.println("0: 신규");
      System.out.println("1: 진행 중");
      System.out.println("2: 완료");
      System.out.print("> ");
      status[i] = Integer.valueOf(sc.nextLine());   //기억!

      System.out.print("담당자? ");
      owner[i] = sc.nextLine();

      size++;

      System.out.println();

      System.out.print("계속 입력하시겠습니까? (y/N)");
      String input = sc.nextLine();

      if (!input.equalsIgnoreCase("y")) {
        break;
      }
    }

    sc.close();

    System.out.println("----------");

    System.out.printf("[프로젝트%s]\n", project);

    for (int i=0; i<size; i++) {
      String stateLabel = null;
      switch (status[i]) {
        case 1:
          System.out.println("상태: 진행 중");
          break;

        case 2:
          System.out.println("상태: 완료");
          break;

        default:
          System.out.println("상태: 신규");
      }

      System.out.printf("%d, %s, %s, %s, %s", no[i], content[i], deadline[i], stateLabel, owner[i]);
    }

  }

}
