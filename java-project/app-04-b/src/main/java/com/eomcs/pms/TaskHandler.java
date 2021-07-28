package com.eomcs.pms;

public class TaskHandler {

  static final int LENGTH = 5;
  static Task[] tasks = new Task[LENGTH];
  static int size = 0;

  static void add() {
    Task task = new Task();

    System.out.println("[작업 등록]");
    task.no = Prompt.promptInt("번호? ");
    task.content = Prompt.promptString("내용? ");
    task.deadline = Prompt.promptDate("마감일? ");
    System.out.println("상태? ");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    task.status = Prompt.promptInt("> ");
    task.owner = Prompt.promptString("담당자? ");

    tasks[size++] = task;
  }

  static void list() {
    System.out.println("[작업 목록]");
    String statusLabel = null;
    for (int i=0; i<size; i++) {
      switch (tasks[i].status) {
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
          tasks[i].no,
          tasks[i].content,
          tasks[i].deadline,
          statusLabel,
          tasks[i].owner);
    }
  }


}
