package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Task;
import com.eomcs.util.Prompt;

public class TaskHandler {

  static final int MAX_LENGTH = 5;
  Task[] tasks = new Task[MAX_LENGTH];
  int size = 0;

  public void add(MemberHandler memberHandler) {
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

    while (true) {
      String owner = Prompt.promptString("담당자?(취소: 빈 문자열) ");
      if (memberHandler.exits(owner)) {
        task.owner = owner;
        break;
      } else if (owner.length() == 0) {
        System.out.println("작업 등록을 취소합니다.");
        return;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    this.tasks[this.size++] = task;
  }

  public void list() {
    System.out.println("[작업 목록]");
    String statusLabel = null;
    for (int i=0; i<this.size; i++) {
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
          this.tasks[i].no,
          this.tasks[i].content,
          this.tasks[i].deadline,
          statusLabel,
          this.tasks[i].owner);
    }
  }


}
