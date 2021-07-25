package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    final int MAX_LENGTH = 5;

    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] password = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH];
    String[] tel = new String[MAX_LENGTH];
    Date[] registeredDate = new Date[MAX_LENGTH];
    int size = 0;

    //프로젝트와 작업에도 각각 배열 크기 선언
    final int PROJECT_LENGTH = 5;
    int[] pNo = new int[PROJECT_LENGTH];
    String[] pTitle = new String[PROJECT_LENGTH];
    String[] pContent = new String[PROJECT_LENGTH];
    Date[] pStartDate = new Date[PROJECT_LENGTH];
    Date[] pEndDate = new Date[PROJECT_LENGTH];
    String[] pOwner = new String[PROJECT_LENGTH];
    String[] pMembers = new String[PROJECT_LENGTH];
    int pSize = 0;

    final int TASK_LENGTH = 5;
    int[] tNo = new int[TASK_LENGTH];
    String[] tContent = new String[TASK_LENGTH];
    Date[] tDeadline = new Date[TASK_LENGTH];
    int[] tStatus = new int[TASK_LENGTH];
    String[] tOwner = new String[TASK_LENGTH];
    int tSize = 0;

    while (true) {
      System.out.print("명령> ");
      String input = sc.nextLine();

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (input.equals("/member/add")) {
        System.out.println("[회원 등록]");
        System.out.print("번호? ");
        no[size] = Integer.parseInt(sc.nextLine());
        System.out.print("이름? ");
        name[size] = sc.nextLine();
        System.out.print("이메일? ");
        email[size] = sc.nextLine();
        System.out.print("사진? ");
        photo[size] = sc.nextLine();
        System.out.print("전화? ");
        tel[size] = sc.nextLine();
        registeredDate[size] = new Date(System.currentTimeMillis());

        size++;

      } else if (input.equals("/member/list")) {
        System.out.println("[회원 목록]");
        for (int i=0; i<size; i++) {
          System.out.printf("%d, %s, %s, %s, %s\n",
              no[i],
              name[i],
              email[i],
              tel[i],
              registeredDate[i]);
        }

      } else if (input.equals("/project/add")) {
        System.out.println("[프로젝트 등록]");
        System.out.print("번호? ");
        pNo[pSize] = Integer.parseInt(sc.nextLine());
        System.out.print("프로젝트명? ");
        pTitle[pSize] = sc.nextLine();
        System.out.print("시작일? ");
        pStartDate[pSize] = Date.valueOf(sc.nextLine());
        System.out.print("종료일? ");
        pEndDate[pSize] = Date.valueOf(sc.nextLine());
        System.out.print("만든이? ");
        pOwner[pSize] = sc.nextLine();
        System.out.print("팀원? ");
        pMembers[pSize] = sc.nextLine();

        pSize++;

      } else if (input.equals("/project/list")) {
        System.out.println("[프로젝트 목록]");
        for (int i=0; i<pSize; i++) {
          System.out.printf("%d, %s, %s, %s, %s\n",
              pNo[i],
              pTitle[i],
              pStartDate[i],
              pEndDate[i],
              pOwner[i]);
        }

      } else if (input.equals("/task/add")) {
        System.out.println("[작업 등록]");
        System.out.print("번호? ");
        tNo[tSize] = Integer.parseInt(sc.nextLine());
        System.out.print("내용? ");
        tContent[tSize] = sc.nextLine();
        System.out.print("마감일? ");
        tDeadline[tSize] = Date.valueOf(sc.nextLine());
        System.out.println("상태? ");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        System.out.print("> ");
        tStatus[tSize] = Integer.parseInt(sc.nextLine());
        System.out.print("만든이? ");
        tOwner[tSize] = sc.nextLine();

        tSize++;

      } else if (input.equals("/task/list")) {
        System.out.println("[작업 목록]");
        String statusLabel = null; //쌤한테 질문!
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

      } else {
        System.out.println("실행할 수 없는 명령어입니다.");
      }

      System.out.println();
    }

    sc.close();


  }

}
