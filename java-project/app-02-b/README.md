### **02-b. 값 다루기: 변수와 키보드 입력**<br>
1. 변수: 값을 저장하는 메모리, 저장한 값 변경, 저장한 값을 바꿀 수 있음<br>
<-> 상수: 저장한 값을 바꿀 수 없음<br>
2. 키보드: 표준 입력 장치<br>

<br>

3. 기본 데이터 타입: 값의 종류와 크기에 따라<br>
3-1. 정수 값: **byte** 1바이트, **short** 2바이트, **int** 3바이트, **long** 4바이트<br>
3-2. 부동 소수점 값: **float** 4바이트, **double** 8바이트<br>
3-3. 문자 값: **char** 2바이트<br>
3-4. 논리 값: **boolean** int 사용, 배열일 경우 byte 사용

#### **1. 훈련 목표**<br>
1. 키보드로 값을 입력받는 방법을 배움<br>
2. 값을 보관하기 위해 변수를 사용하는 방법을 배움<br>

#### **2. 훈련 내용**<br>
1. 콘솔을 통해 한명의 회원 정보를 입력받아 출력<br>
2. 콘솔을 통해 한개의 프로젝트 정보를 입력받아 출력<br>
3. 콘솔을 통해 한개의 작업 정보를 입력받아 출력<br>

#### **3. 실습**<br>
1. 한명의 회원 정보를 입력받아 출력<br>
1-1. 입력 값을 String 변수에 받음<br>

```console
[회원]
번호?
이름?
이메일?
암호?
사진?
전화?
----------
[회원]
번호: 101
이름: 춘식이
이메일: chun@test.com
암호: 1111
사진: chun.png
전화:010-1111-2222
가입 일: 2021-01-01
```

```java
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
    //new Date(System.currentTimeMillis()) 기억!

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
```

2.  한개의 프로젝트 정보를 입력받아 출력<br>
2-1. 번호는 int 변수에 받고, 시작 일과 종료일은 java.sql.Date 변수에 받음<br>

```console
[프로젝트]
번호?
프로젝트 명?
내용?
시작 일?
종료 일?
만든 이?
팀원?
----------
[프로젝트]
번호: 1201
프로젝트 명: 미니 프로젝트 관리 시스템 개발
내용: 소규모 팀을 위한 프로젝트 관리 시스템을 개발한다
시작 일: 2021-01-01
종료 일: 2021-12-31
만든 이: 춘식이
팀원: 춘식이, 라이언, 어피치
```

```java
public class App2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("[프로젝트]");

    System.out.print("번호? ");
    int no = sc.nextInt();
    sc.nextLine();
    //번호 뒤에 남아 있는 줄 바꿈 코드 제거 기억!

    System.out.print("프로젝트 명? ");
    String title = sc.nextLine();

    System.out.print("내용? ");
    String content = sc.nextLine();

    System.out.print("시작 일? ");
    Date startDate = Date.valueOf(sc.nextLine());
    //Date.valueOf() 기억!

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
    //Date: %s 기억!
    System.out.printf("종료 일: %s\n", endDate);
    System.out.printf("만든 이: %s\n", owner);
    System.out.printf("팀원: %s\n", members);
  }
}
```

3. 한개의 작업 정보를 입력받아 출력<br>
3-1. 프로젝트에서 수행할 작업 정보 출력<br>

```console
[작업]
프로젝트?
번호?
내용?
완료 일?
상태?
0: 신규
1: 진행 중
2: 완료
>
담당자?
----------
[작업]
프로젝트: 미니 프로젝트 관리 시스템 개발
번호: 1
내용: 요구 사항 수집
완료 일: 2021-01-31
상태: 진행 중
담당자: 춘식이
```

```java
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

    switch (status) {    //기억!
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
```
