package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Task;
import com.eomcs.util.Prompt;

public class TaskHandler {

  static class Node {
    Task task;
    Node next;

    public Node(Task task) {
      this.task = task;
    }
  }

  Node head;
  Node tail;
  int size = 0;

  MemberHandler memberHandler;

  public TaskHandler(MemberHandler memberHandler) {
    this.memberHandler = memberHandler;
  }

  public void add() {
    Task task = new Task();

    System.out.println("[작업 등록]");
    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");

    task.status = promptStatus();

    task.owner = promptOwner("담당자?(취소: 빈 문자열) ");
    if (task.owner == null) {
      System.out.println("작업 등록을 취소합니다.");
      return;
    }

    Node node = new Node(task);

    if (head == null) {
      tail = head = node;
    } else {
      tail.next = node;
      tail = node;
    }

    size++;
  }

  public void list() {
    System.out.println("[작업 목록]");

    if (head == null) {
      return;
    }

    Node node = head;

    do {
      System.out.printf("%d, %s, %s, %s, %s\n",
          node.task.no,
          node.task.content,
          node.task.deadline,
          getStatusLabel(node.task.status),
          node.task.owner);

      node = node.next;
    } while (node != null);
  }

  public void detail() {
    System.out.println("[작업 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("내용: %s\n", task.content);
    System.out.printf("마감일: %s\n", task.deadline);

    System.out.printf("상태: %s\n", getStatusLabel(task.status));

    System.out.printf("담당자: %s\n", task.owner);
  }

  public void update() {
    System.out.println("[작업 변경]");

    int no = Prompt.inputInt("번호? ");

    Task task = findByNo(no);

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", task.content));
    Date deadline = Prompt.inputDate(String.format("마감일(%s)? ", task.deadline));

    int status = promptStatus(task.status);

    String owner = promptOwner(String.format(
        "담당자(%s)?(취소: 빈 문자열) ", task.owner));
    if (owner == null) {
      System.out.println("작업 변경을 취소합니다.");
      return;
    }

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 변경을 취소하였습니다.");
      return;
    }

    task.content = content;
    task.deadline = deadline;
    task.status = status;
    task.owner = owner;

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

    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.task == task) {
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next;
        }

        node.next = null;

        if (node == tail) {
          tail = prev;
        }

        break;
      }

      prev = node;
      node = node.next;
    }

    size--;

    System.out.println("작업을 삭제하였습니다.");
  }

  private Task findByNo(int no) {
    Node node = head;

    while (node != null) {
      if (node.task.no == no) {
        return node.task;
      }

      node = node.next;
    }

    return null;
  }

  private String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  private String promptOwner(String label) {
    while (true) {
      String owner = Prompt.inputString(label);
      if (this.memberHandler.exits(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
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


}
