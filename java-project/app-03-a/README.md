## **03-a. 메서드 사용 법: 프로그램의 시작 점(entry point), main()**<br>
JVM으로 클래스를 실행하면 그 클래스에 정의된 **main()** 메서드를 찾아 명령어 실행<br>
    -> JVM(자바 가상 머신, Java virtual machine): 자바 언어로 작성된 프로그램을 해석해서 실행하는 가상적 컴퓨터<br>
    *출처: 한국정보통신기술협회, 정보통신용어사전*

<br>

### **1. 훈련 목표**<br>
1. 클래스 실행과 main() 메서드의 관계 이해<br>
2. 조건 문, 반복 문, 블록, 배열 등의 활용 연습<br>

<br>

### **2. 훈련 내용**<br>
1. 1단계: 명령 프롬프트 출력<br>
2. 2단계: 명령어를 입력받아 출력<br>
3. 3단계: 명령어를 입력받는 것을 반복<br>
<br>
4. 4단계: '/member/add', '/member/list' 명령 구분<br>
5. 5단계: '/member/add' 명령 처리<br>
6. 6단계: '/member/list' 명령 처리<br>
<br>
7. 7단계: '/project/add' 명령 처리<br>
8. 8단계: '/project/list' 명령 처리<br>
<br>
9. 9단계: '/task/add' 명령 처리<br>
10. 10단계: '/task/list' 명령 처리<br>

<br>

```java
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

      } else {
        System.out.println("실행할 수 없는 명령어입니다.");
      }

      System.out.println();
    }

    sc.close();


  }

}
```

<br>

*훈련 내용만 보고 하는 것 연습하기..~*