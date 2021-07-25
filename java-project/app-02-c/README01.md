## **02-c. 값 다루기: 배열과 흐름 제어문 활용**<br>
1. 배열: 같은 종류의 변수를 여러 개 만들 때 사용<br>
-> 인덱스: 배열의 각 변수를 가리킴, 0으로 시작<br>

<br>

2. 조건문: **if/else**, **switch**<br>
3. 반복문: **while**, **do/while**, **for**<br>
4. 흐름 제어문<br>

<br>

### **1. 훈련 목표**<br>
1. 배열을 생성하고, 배열에 값을 저장하고 꺼내는 방법을 배움<br>
2. 조건문과 반복문을 활용해서 프로그램의 실행 흐름을 제어하는 방법을 배움<br>

<br>

### **2. 훈련 내용**<br>
1. 콘솔을 통해 여러 명의 회원 정보를 입력받아 출력<br>
2. 콘솔을 통해 여러 개의 프로젝트 정보를 입력받아 출력<br>
3. 콘솔을 통해 여러 개의 작업 정보를 입력받아 출력<br>

<br>

### **3. 실습**<br>
#### **1단계: 여러 명의 회원 정보를 입력받아 출력**<br>
```console
[회원]
번호? 101
이름? 춘식이
이메일? chun@test.com
암호? 1111
사진? chun.png
전화? 010-1111-2222

계속 입력하시겠습니까? (y/N) y

번호? 102
이름? 라이언
이메일? ryan@test.com
암호? 2222
사진? ryan.png
전화? 010-2222-3333

계속 입력하시겠습니까? (y/N)
----------
101, 춘식이, chun@test.com, 010-1111-2222, 2021-07-22
102, 라이언, ryan@test.com, 010-2222-3333, 2021-07-22
```

<br>

```java
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

    //2. 배열 사용 후
    int[] no = new int[5];
    String[] name = new String[5];
    String[] email = new String[5];
    String[] password = new String[5];
    String[] photo = new String[5];
    String[] tel = new String[5];
    Date[] registeredDate = new Date[5];

    System.out.println("[회원]");

    //3. 반복문 적용: while 문 //기억!
    int i = 0;
    while (i < 5) {
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

      registeredDate[i] = new Date();   //기억!

      System.out.println();

      i = i+1;
    }

    sc.close();

    System.out.println("----------");

    i = 0;
    while (i < 5) {
      System.out.printf("번호: %d\n", no[i]);
      System.out.printf("이름: %s\n", name[i]);
      System.out.printf("이메일: %s\n", email[i]);
      System.out.printf("암호: %s\n", password[i]);
      System.out.printf("사진: %s\n", photo[i]);
      System.out.printf("전화: %s\n", tel[i]);
      System.out.printf("가입 일: %s\n", registeredDate[i]);
      System.out.println();

      i = i+1;
    }

  }

}
```
