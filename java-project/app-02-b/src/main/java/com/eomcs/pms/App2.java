package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("[프로젝트]");

    System.out.print("번호? ");
    int no = sc.nextInt();
    sc.nextLine();
    //번호 뒤에 남아 있는 줄 바꿈 코드 제거

    System.out.print("프로젝트 명? ");
    String title = sc.nextLine();

    System.out.print("내용? ");
    String content = sc.nextLine();

    System.out.print("시작 일? ");
    Date startDate = Date.valueOf(sc.nextLine());
    //Date.valueOf()

    System.out.print("종료 일? ");
    Date endDate = Date.valueOf(sc.nextLine());

    System.out.print("만든 이? ");
    String owner = sc.nextLine();

    System.out.print("팀원? ");
    String members = sc.nextLine();

    sc.close();

    System.out.println("----------");

    System.out.printf("번호: %d\n", no);
    System.out.printf("프로젝트 명: %s\n", title);
    System.out.printf("내용: %s\n", content);
    System.out.printf("시작 일: %s\n", startDate);
    //Date: %s
    System.out.printf("종료 일: %s\n", endDate);
    System.out.printf("만든 이: %s\n", owner);
    System.out.printf("팀원: %s\n", members);

  }

}
