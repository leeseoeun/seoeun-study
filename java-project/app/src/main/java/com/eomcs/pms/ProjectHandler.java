package com.eomcs.pms;

import java.sql.Date;

public class ProjectHandler {

  static final int LENGTH = 5;
  static int[] no = new int[LENGTH];
  static String[] title = new String[LENGTH];
  static String[] content = new String[LENGTH];
  static Date[] startDate = new Date[LENGTH];
  static Date[] endDate = new Date[LENGTH];
  static String[] owner = new String[LENGTH];
  static String[] members = new String[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[프로젝트 등록]");
    no[size] = Prompt.promptInt("번호? ");
    title[size] = Prompt.promptString("프로젝트명? ");
    content[size] = Prompt.promptString("내용? ");
    startDate[size] = Prompt.promptDate("시작일? ");
    endDate[size] = Prompt.promptDate("종료일? ");
    owner[size] = Prompt.promptString("만든이? ");
    members[size] = Prompt.promptString("팀원? ");

    size++;
  }

  static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i],
          title[i],
          startDate[i],
          endDate[i],
          owner[i]);
    }
  }


}
