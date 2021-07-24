package com.eomcs.pms;

import java.util.Date;
import java.util.Scanner;

//1. 배열 사용 전
//2. 배열 사용 후
//3. 반복문 적용: while 문
//4. 반복문 적용: for 문
//5. 여러 문장에서 반복해서 사용하는 값은 변수에 담아서 사용
//6. 조회 용으로만 사용할 변수라면 상수로 선언
//7. 특정 조건에 따라 반복을 멈춤
//8. 날짜의 출력 형식을 "yyyy-MM-dd"로 변경

public class App {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    //5. 여러 문장에서 반복해서 사용하는 값은 변수에 담아서 사용
    //    int maxLength = 5;
    //6. 조회 용으로만 사용할 변수라면 상수로 선언
    final int MAX_LENGTH = 5;

    //2. 배열 사용 후
    int[] no = new int[MAX_LENGTH];
    String[] name = new String[MAX_LENGTH];
    String[] email = new String[MAX_LENGTH];
    String[] password = new String[MAX_LENGTH];
    String[] photo = new String[MAX_LENGTH];
    String[] tel = new String[MAX_LENGTH];
    Date[] registeredDate = new Date[MAX_LENGTH];

    int size = 0;

    System.out.println("[회원]");

    //4. 반복문 적용: for 문
    for (int i=0; i<MAX_LENGTH; i=i+1) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(sc.nextLine());

      System.out.print("이름? ");
      name[i] = sc.nextLine();

      System.out.print("이메일? ");
      email[i] = sc.nextLine();

      System.out.print("암호? ");
      password[i] = sc.nextLine();

      System.out.print("사진? ");
      photo[i] = sc.nextLine();

      System.out.print("전화? ");
      tel[i] = sc.nextLine();

      registeredDate[i] = new Date();

      size = size + 1;

      System.out.println();

      //7. 특정 조건에 따라 반복을 멈춤
      System.out.print("계속 입력하시겠습니까? (y/N) ");
      String input = sc.nextLine();

      if (input.equalsIgnoreCase("n") || input.equals("")) {    //기억!
        break;
      }
    }

    sc.close();

    System.out.println("----------");

    //8. 날짜의 출력 형식을 "yyyy-MM-dd"로 변경
    for (int i=0; i<size; i=i+1) {
      System.out.printf("%d, %s, %s, %s, %5$tY-%5$tm-%5$td\n",  //기억!
          no[i],
          name[i],
          email[i],
          tel[i],
          registeredDate[i]);
    }

  }

}
