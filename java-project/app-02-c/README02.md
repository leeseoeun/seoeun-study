### **02-c. 값 다루기: 배열과 흐름 제어문 활용**<br>
#### **3. 실습**<br>
1. 여러 명의 회원 정보를 입력받아 출력<br>

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

```java
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
```

2. 여러 개의 프로젝트 정보를 입력받아 출력<br>

```console
[프로젝트]
번호? 1201
프로젝트 명? 프로젝트1
내용? 내용1
시작 일? 2021-07-23
종료 일? 2021-08-13
만든 이? 춘식이
팀원? 라이언, 어피치

계속 입력하시겠습니까? (y/N) y

번호? 1202
프로젝트 명? 프로젝트2
내용? 내용2
시작 일? 2021-07-23
종료 일? 2021-08-13
만든 이? 라이언
팀원? 어피치, 춘식이

계속 입력하시겠습니까? (y/N)
----------
1201, 프로젝트1, 2021-07-23, 2021-08-13, 춘식이
1202, 프로젝트2, 2021-07-23, 2021-08-13, 라이언
```

```java
public class App2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    final int MAX_LENGTH = 5;

    int[] no = new int[MAX_LENGTH];
    String[] title = new String[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] startDate = new Date[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];
    String[] members = new String[MAX_LENGTH];

    int size = 0;

    System.out.println("[프로젝트]");

    for (int i=0; i<MAX_LENGTH; i++) {
      System.out.print("번호? ");
      no[i] = Integer.valueOf(sc.nextLine());
      //Integer.parseInt(sc.nextLine());

      System.out.print("프로젝트 명? ");
      title[i] = sc.nextLine();

      System.out.print("내용? ");
      content[i] = sc.nextLine();

      System.out.print("시작 일? ");
      startDate[i] = Date.valueOf(sc.nextLine());

      System.out.print("종료 일? ");
      endDate[i] = Date.valueOf(sc.nextLine());

      System.out.print("만든 이? ");
      owner[i] = sc.nextLine();

      System.out.print("팀원? ");
      members[i] = sc.nextLine();

      size++;

      System.out.println();

      System.out.println("계속 입력하시겠습니까? (y/N)");
      String input = sc.nextLine();

      if (!input.equalsIgnoreCase("y")) {   //기억!
        break;
      }
    }

    sc.close();

    System.out.println("----------");

    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i], title[i], startDate[i], endDate[i], owner[i]);
    }
  }
}
```

3. 한개의 작업 정보를 입력받아 출력<br>

```console
[작업]
프로젝트? 프로젝트1
번호? 1
내용? 작업1
완료 일? 2021-07-23
상태?
0: 신규
1: 진행 중
2: 완료
> 0
담당자? 춘식이

계속 입력하시겠습니까? (y/N) y

번호? 2
내용? 작업2
완료 일? 2021-07-23
상태?
0: 신규
1: 진행 중
2: 완료
> 1
담당자? 라이언

계속 입력하시겠습니까? (y/N)
----------
[프로젝트1]
1, 작업1, 2021-07-23, 신규, 춘식이
2, 작업2, 2021-07-23, 진행 중, 라이언
```

```java
public class App3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    final int MAX_LENGTH = 5;

    int[] no = new int[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] deadline = new Date[MAX_LENGTH];
    int[] status = new int[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];

    int size = 0;

    System.out.println("[작업]");

    System.out.print("프로젝트? ");
    String project = sc.nextLine();

    for (int i=0; i<MAX_LENGTH; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(sc.nextLine());

      System.out.print("내용? ");
      content[i] = sc.nextLine();

      System.out.print("완료 일? ");
      deadline[i] = Date.valueOf(sc.nextLine());

      System.out.println("상태? ");
      System.out.println("0: 신규");
      System.out.println("1: 진행 중");
      System.out.println("2: 완료");
      System.out.print("> ");
      status[i] = Integer.valueOf(sc.nextLine());   //기억!

      System.out.print("담당자? ");
      owner[i] = sc.nextLine();

      size++;

      System.out.println();

      System.out.print("계속 입력하시겠습니까? (y/N)");
      String input = sc.nextLine();

      if (!input.equalsIgnoreCase("y")) {
        break;
      }
    }

    sc.close();

    System.out.println("----------");

    System.out.printf("[프로젝트%s]\n", project);

    for (int i=0; i<size; i++) {
      String stateLabel = null;
      switch (status[i]) {
        case 1:
          System.out.println("상태: 진행 중");
          break;

        case 2:
          System.out.println("상태: 완료");
          break;

        default:
          System.out.println("상태: 신규");
      }

      System.out.printf("%d, %s, %s, %s, %s",
          no[i], content[i], deadline[i], stateLabel, owner[i]);
    }
  }
}
```
