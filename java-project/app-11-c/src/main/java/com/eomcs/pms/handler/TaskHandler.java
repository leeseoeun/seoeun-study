package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Task;
import com.eomcs.util.List;
import com.eomcs.util.Prompt;

public class TaskHandler {

  List<Task> taskList;

  MemberHandler memberHandler;
  public TaskHandler(List<Task> taskList, MemberHandler memberHandler) {
    this.taskList = taskList;
    this.memberHandler = memberHandler;
  }

  public void add() {
    Task task = new Task();

    System.out.println("[작업 등록]");
    task.setNo(Prompt.inputInt("번호? "));
    task.setContent(Prompt.inputString("내용? "));
    task.setDeadline(Prompt.inputDate("마감일? "));

    task.setStatus(promptStatus());

    task.setOwner(memberHandler.promptOwner("담당자?(취소: 빈 문자열) "));
    if (task.getOwner() == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    taskList.add(task);
  }

  public void list() {
    System.out.println("[작업 목록]");

    Task[] list = taskList.toArray(new Task[0]);

    for (Task task : list) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          task.getNo(),
          task.getContent(),
          task.getDeadline(),
          getStatusLabel(task.getStatus()),
          task.getOwner());
    }
  }

  public void detail() {
    System.out.println("[작업 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("내용: %s\n", task.getContent());
    System.out.printf("마감일: %s\n", task.getDeadline());

    System.out.printf("상태: %s\n", getStatusLabel(task.getStatus()));

    System.out.printf("담당자: %s\n", task.getOwner());
  }

  public void update() {
    System.out.println("[작업 변경]");

    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.getContent()));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.getDeadline()));

    int status = promptStatus(task.getStatus());

    String owner = memberHandler.promptOwner(String.format(
        "담당자(%s)?(취소: 빈 문자열) ", task.getOwner()));
    if (owner == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경을 취소하였습니다.");
      return;
    }

    task.setContent(content);
    task.setDeadline(deadline);
    task.setStatus(status);
    task.setOwner(owner);

    System.out.println("작업을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[작업 삭제]");

    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    taskList.remove(task);

    System.out.println("작업을 삭제하였습니다.");
  }

  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  private int promptStatus() {
    return promptStatus(-1);
  }

  private int promptStatus(int status) {
    if (status == -1) {
      System.out.println("상태?");
    } else {
      System.out.printf("상태(%s)?\n", getStatusLabel(status));
    }
    System.out.println("0: 신규");
    System.out.println("1: 진행 중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }

  public Task findByNo(int no) {
    Task[] arr = new Task[taskList.size()];
    arr = taskList.toArray(arr);

    for (Task task : arr) {
      if (task.getNo() == no) {
        return task;
      }
    }

    return null;
  }


}
