package com.eomcs.pms;

import java.sql.Date;

public class TaskHandler {

  static final int LENGTH = 5;
  static int[] no = new int[LENGTH];
  static String[] content = new String[LENGTH];
  static Date[] deadline = new Date[LENGTH];
  static int[] status = new int[LENGTH];
  static String[] owner = new String[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[작업 등록]");
    no[size] = Prompt.promptInt("번호? ");
    content[size] = Prompt.promptString("내용? ");
    deadline[size] = Prompt.promptDate("마감일? ");
    System.out.println("상태? ");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    status[size] = Prompt.promptInt("> ");
    owner[size] = Prompt.promptString("담당자? ");

    size++;
  }

  static void list() {
    System.out.println("[작업 목록]");
    String statusLabel = null;
    for (int i=0; i<size; i++) {
      switch (status[i]) {
        case 1:
          statusLabel = "진행중";
          break;
        case 2:
          statusLabel = "완료";
          break;
        default:
          statusLabel = "신규";
      }

      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i],
          content[i],
          deadline[i],
          statusLabel,
          owner[i]);
    }
  }


}
