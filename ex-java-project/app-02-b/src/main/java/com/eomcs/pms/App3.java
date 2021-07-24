package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("[작업]");

    System.out.print("프로젝트? ");
    String project = sc.nextLine();

    System.out.print("번호? ");
    int no = Integer.parseInt(sc.nextLine());
    //int no = sc.nextInt();
    //sc.nextLine();

    System.out.print("내용? ");
    String content = sc.nextLine();

    System.out.print("완료 일? ");
    Date deadline = Date.valueOf(sc.nextLine());

    System.out.println("상태? ");
    System.out.println("0: 신규");
    System.out.println("1: 진행 중");
    System.out.println("2: 완료");
    System.out.print("> ");
    int status = Integer.parseInt(sc.nextLine());

    System.out.print("담당자? ");
    String owner = sc.nextLine();

    sc.close();

    System.out.println("----------");

    System.out.printf("프로젝트: %s\n", project);
    System.out.printf("번호: %d\n", no);
    System.out.printf("내용: %s\n", content);
    System.out.printf("완료 일: %s\n", deadline);

    switch(status) {    //기억!
      case 1:
        System.out.println("상태: 진행 중");
        break;

      case 2:
        System.out.println("상태: 완료");
        break;

      default:
        System.out.println("상태: 신규");
        //case 0:
        //System.out.println("상태: 신규");
        //break;
    }

    System.out.printf("담당자: %s\n", owner);

  }

}
