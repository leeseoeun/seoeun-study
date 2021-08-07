## **03-b. 메서드 사용법: 메서드 활용**<br>
메서드: 코드를 기능 단위로 묶을 때 사용하는 문법<br>
1. 클래스 메서드(스태틱 메서드): static으로 선언<br>
2. 인스턴스 메서드(논스태틱 메서드)<br>

<br>

### **1. 훈련 목표**<br>
1. 메서드를 활용해서 코드를 기능 단위로 묶는 방법을 배움<br>
2. 메서드를 정의하고 사용하는 것을 연습<br>
3. 로컬 변수와 스태틱 필드의 사용 범위 이해<br>
4. 리팩토링의 개념과 목적 이해<br>
5. 리팩토링의 기법 중에서 '메서드 추출(Extract Method)' 연습<br>

<br>

### **2. 훈련 내용**<br>
1. 회원 데이터를 입력하고 목록을 조회하는 코드를 메서드로 분리<br>
2. 프로젝트 데이터를 입력하고 목록을 조회하는 코드를 메서드로 분리<br>
3. 작업 데이터를 입력하고 목록을 조회하는 코도를 메서드로 분리<br>

<br>

### **3. 실습**<br>
1. 1단계: 회원 데이터를 입력하는 코드를 메서드로 분리<br>
2. 2단계: 회원 데이터 목록을 출력하는 코드를 메서드로 분리<br>
<br>
3. 3단계: 프로젝트 데이터를 입력하는 코드를 메서드로 분리<br>
4. 4단계: 프로젝트 데이터 목록을 출력하는 코드를 메서드로 분리<br>
<br>
5. 5단계: 작업 데이터를 입력하는 코드를 메서드로 분리<br>
6. 6단계: 작업 데이터 목록을 출력하는 코드를 메서드로 분리<br>
<br>
각 메서드에서 각 클래스와 배열을 사용할 수 있도록 스태틱 멤버로 선언

<br>

```java
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
      System.out.print("명령> ");
      String input = sc.nextLine();

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
    System.out.print("번호? ");
    no[size] = Integer.parseInt(sc.nextLine());
    System.out.print("이름? ");
    name[size] = sc.nextLine();
    System.out.print("이메일? ");
    email[size] = sc.nextLine();
    System.out.print("암호? ");
    password[size] = sc.nextLine();
    System.out.print("사진? ");
    photo[size] = sc.nextLine();
    System.out.print("전화? ");
    tel[size] = sc.nextLine();
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
    System.out.print("번호? ");
    pNo[pSize] = Integer.parseInt(sc.nextLine());
    System.out.print("프로젝트명? ");
    pTitle[pSize] = sc.nextLine();
    System.out.print("내용? ");
    pContent[pSize] = sc.nextLine();
    System.out.print("시작일? ");
    pStartDate[pSize] = Date.valueOf(sc.nextLine());
    System.out.print("종료일? ");
    pEndDate[pSize] = Date.valueOf(sc.nextLine());
    System.out.print("만든이? ");
    pOwner[pSize] = sc.nextLine();
    System.out.print("팀원? ");
    pMembers[pSize] = sc.nextLine();

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
    System.out.print("담당자? ");
    tOwner[tSize] = sc.nextLine();

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


}
```
