### **04-a. 클래스 사용법: 메서드 분류**<br>
클래스: 여러 개의 메서드를 한 단위로 묶을 때 사용<br>

#### **1. 훈련 목표**<br>
1. 클래스를 이용해서 메서드를 한 단위로 묶는 법을 배움<br>
2. 리팩토링 기법 중에서 '클래스 추출(Extract Class)' 연습<br>

#### **2. 훈련 내용**<br>
1. 프롬프트 관련 메서드를 별도의 클래스로 분리<br>
2. 회원 관련 메서드를 별도의 클래스로 분리<br>
3. 프로젝트 관련 메서드를 별도의 클래스로 분리<br>
4. 작업 관련 메서드를 별도의 클래스로 분리<br>

#### **3. 실습**<br>
1. 사용자의 입력을 받는 프롬프트 메서드를 별도의 클래스로 분리<br>

```java
public class Prompt {
  static Scanner sc = new Scanner(System.in);

  static String promptString(String title) {
    System.out.print(title);
    return sc.nextLine();
  }

  static int promptInt(String title) {
    return Integer.parseInt(promptString(title));
  }

  static Date promptDate(String title) {
    return Date.valueOf(promptString(title));
  }
}
```

2. 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리<br>

```java
public class MemberHandler {
  static final int MAX_LENGTH = 5;
  static int[] no = new int[LENGTH];
  static String[] name = new String[LENGTH];
  static String[] email = new String[LENGTH];
  static String[] password = new String[LENGTH];
  static String[] photo = new String[LENGTH];
  static String[] tel = new String[LENGTH];
  static Date[] registeredDate = new Date[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[회원 등록]");
    no[size] = Prompt.promptInt("번호? ");
    name[size] = Prompt.promptString("이름? ");
    email[size] = Prompt.promptString("이메일? ");
    password[size] = Prompt.promptString("암호? ");
    photo[size] = Prompt.promptString("사진? ");
    tel[size] = Prompt.promptString("전화? ");
    registeredDate[size] = new Date(System.currentTimeMillis());

    size++;
  }

  static void list() {
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
}
```

3. 프로젝트 데이터 처리와 관련된 메서드를 별도의 클래스로 분리<br>

```java
public class ProjectHandler {
  static final int MAX_LENGTH = 5;
  static int[] no = new int[LENGTH];
  static String[] title = new String[LENGTH];
  static String[] content = new String[LENGTH];
  static Date[] startDate = new Date[LENGTH];
  static Date[] endDate = new Date[LENGTH];
  static String[] owner = new String[LENGTH];
  static String[] members = new String[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[프로젝트 등록]");
    no[size] = Prompt.promptInt("번호? ");
    title[size] = Prompt.promptString("프로젝트명? ");
    content[size] = Prompt.promptString("내용? ");
    startDate[size] = Prompt.promptDate("시작일? ");
    endDate[size] = Prompt.promptDate("종료일? ");
    owner[size] = Prompt.promptString("만든이? ");
    members[size] = Prompt.promptString("팀원? ");

    size++;
  }

  static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          no[i],
          title[i],
          startDate[i],
          endDate[i],
          owner[i]);
    }
  }
}
```

4. 작업 데이터 처리와 관련된 메서드를 별도의 클래스로 분리<br>

```java
public class TaskHandler {
  static final int LENGTH = 5;
  static int[] no = new int[LENGTH];
  static String[] content = new String[LENGTH];
  static Date[] deadline = new Date[LENGTH];
  static int[] status = new int[LENGTH];
  static String[] owner = new String[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[작업 등록]");
    no[size] = Prompt.promptInt("번호? ");
    content[size] = Prompt.promptString("내용? ");
    deadline[size] = Prompt.promptDate("마감일? ");
    System.out.println("상태? ");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    status[size] = Prompt.promptInt("> ");
    owner[size] = Prompt.promptString("담당자? ");

    size++;
  }

  static void list() {
    System.out.println("[작업 목록]");
    String statusLabel = null;
    for (int i=0; i<size; i++) {
      switch (status[i]) {
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
          no[i],
          content[i],
          deadline[i],
          statusLabel,
          owner[i]);
    }
  }
}
```

5. 자원 해제는 그 자원을 소유한 클래스에게 맡김<br>

```java
public class Prompt {
  static void close() {
    sc.close();
  }
}
```

```java
public class App {
  public static void main(String[] args) {
    Prompt.close();
  }
}
```
