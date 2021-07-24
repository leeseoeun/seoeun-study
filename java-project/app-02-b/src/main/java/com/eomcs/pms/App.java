package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("[회원]");

    System.out.print("번호? ");
    String no = sc.nextLine();

    System.out.print("이름? ");
    String name = sc.nextLine();

    System.out.print("이메일? ");
    String email = sc.nextLine();

    System.out.print("암호? ");
    String password = sc.nextLine();

    System.out.print("사진? ");
    String photo = sc.nextLine();

    System.out.print("전화? ");
    String tel = sc.nextLine();

    Date registeredDate = new Date(System.currentTimeMillis());
    //new Date(System.currentTimeMillis())

    sc.close(); //기억!

    System.out.println("----------");

    System.out.println("번호: " + no);
    System.out.println("이름: " + name);
    System.out.println("이메일: " + email);
    System.out.println("암호: " + password);
    System.out.println("사진: " + photo);
    System.out.println("전화: " + tel);
    System.out.println("가입 일: " + registeredDate);

  }

}
