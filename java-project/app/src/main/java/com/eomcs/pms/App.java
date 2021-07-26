package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  //스캐너도 각 메서드에서 사용할 수 있도록 스태틱으로 선언
  static Scanner sc = new Scanner(System.in);

  static final int MAX_LENGTH = 5;
  static int[] no = new int[MAX_LENGTH];
  static String[] name = new String[MAX_LENGTH];
  static String[] email = new String[MAX_LENGTH];
  static String[] password = new String[MAX_LENGTH];
  static String[] photo = new String[MAX_LENGTH];
  static String[] tel = new String[MAX_LENGTH];
  static Date[] registeredDate = new Date[MAX_LENGTH];
  static int size = 0;

  static final int PROJECT_LENGTH = 5;
  static int[] pNo = new int[PROJECT_LENGTH];
  static String[] pTitle = new String[PROJECT_LENGTH];
  static String[] pContent = new String[PROJECT_LENGTH];
  static Date[] pStartDate = new Date[PROJECT_LENGTH];
  static Date[] pEndDate = new Date[PROJECT_LENGTH];
  static String[] pOwner = new String[PROJECT_LENGTH];
  static String[] pMembers = new String[PROJECT_LENGTH];
  static int pSize = 0;

  static final int TASK_LENGTH = 5;
  static int[] tNo = new int[TASK_LENGTH];
  static String[] tContent = new String[TASK_LENGTH];
  static Date[] tDeadline = new Date[TASK_LENGTH];
  static int[] tStatus = new int[TASK_LENGTH];
  static String[] tOwner = new String[TASK_LENGTH];
  static int tSize = 0;

  public static void main(String[] args) {
    while (true) {
      String input = promptString("명령? ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (input.equals("/member/add")) {
        addMember();

      } else if (input.equals("/member/list")) {
        listMembers();

      } else if (input.equals("/project/add")) {
        addProject();

      } else if (input.equals("/project/list")) {
        listProjects();

      } else if (input.equals("/task/add")) {
        addTask();

      } else if (input.equals("/task/list")) {
        listTasks();

      } else {
        System.out.println("실행할 수 없는 명령어입니다.");
      }

      System.out.println();
    }

    sc.close();


  }

  //스태틱 메서드는 클래스와 메인 메서드 사이에 분리
  static void addMember() {
    System.out.println("[회원 등록]");
    no[size] = promptInt("번호? ");
    name[size] = promptString("이름? ");
    email[size] = promptString("이메일? ");
    photo[size] = promptString("사진? ");
    tel[size] = promptString("전화? ");
    registeredDate[size] = new Date(System.currentTimeMillis());

    size++;
  }

  static void listMembers() {
    System.out.println("[회원 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i],
          name[i],
          email[i],
          tel[i],
          registeredDate[i]);
    }
  }

  static void addProject() {
    System.out.println("[프로젝트 등록]");
    pNo[pSize] = promptInt("번호? ");
    pTitle[pSize] = promptString("프로젝트명? ");
    pStartDate[pSize] = promptDate("시작일? ");
    pEndDate[pSize] = promptDate("종료일? ");
    pOwner[pSize] = promptString("만든이? ");
    pMembers[pSize] = promptString("팀원? ");

    pSize++;
  }

  static void listProjects() {
    System.out.println("[프로젝트 목록]");
    for (int i=0; i<pSize; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          pNo[i],
          pTitle[i],
          pStartDate[i],
          pEndDate[i],
          pOwner[i]);
    }
  }

  static void addTask() {
    System.out.println("[작업 등록]");
    tNo[tSize] = promptInt("번호? ");
    tContent[tSize] = promptString("내용? ");
    tDeadline[tSize] = promptDate("마감일? ");
    System.out.println("상태? ");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    tStatus[tSize] = promptInt("> ");
    tOwner[tSize] = promptString("만든이? ");

    tSize++;
  }

  static void listTasks() {
    System.out.println("[작업 목록]");
    String statusLabel = null;
    for (int i=0; i<tSize; i++) {
      switch (tStatus[i]) {
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
          tNo[i],
          tContent[i],
          tDeadline[i],
          statusLabel,
          tOwner[i]);
    }
  }

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

}