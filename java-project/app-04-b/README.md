## **04-b. 클래스 사용법: 새 데이터 타입 정의**<br>
클래스
1. 메서드를 관리하기 쉽게 분류<br>
  -> 여러 개의 값을 묶어 한단위로 다룸
2. 새 데이터 타입 정의<br>
  -> 여러 개의 변수를 묶어 클래스로 정의<br>
  => 인스턴스: 클래스 정의에 따라 준비한 메모리<br>

<br>

### **1. 훈련 목표**<br>
1. 클래스를 활용해서 사용자 정의 데이터 타입을 만드는 방법을 배움<br>
2. 클래스를 가지고 메모리를 준비하는 방법을 배움<br>
3. 클래스와 인스턴스의 관계 이해<br>
4. 인스턴스와 레퍼런스의 관계 이해<br>
5. 레퍼런스 배열을 다루는 방법을 배움<br>

<br>

### **2. 훈련 내용**<br>
1. 클래스로 회원 정보를 저장할 때 새 메모리 타입을 정의하고 사용<br>
2. 클래스로 프로젝트 정보를 저장할 때 새 메모리 타입을 정의하고 사용<br>
3. 클래스로 작업 정보를 저장할 때 새 메모리 타입을 정의하고 사용<br>

### **3. 실습**<br>
1. 1단계: 회원 정보를 저장할 때 새 메모리 타입 정의<br>
```java
public class Member {

  //스태틱 변수는 클래스가 로딩될 때 자동으로 딱 한번 생성되기 때문에
  //개별 데이터를 저장할 수 없으니까 static (x)
  //배열 (x)
  int no;
  String name;
  String email;
  String password;
  String photo;
  String tel;
  Date registeredDate;


}
```
```java
public class MemberHandler {

  static final int LENGTH = 5;
  static Member[] members = new Member[LENGTH]; //스태틱 메서드에서 쓰니까 static
  static int size = 0;

  static void add() {
    Member member = new Member();

    System.out.println("[회원 등록]");
    member.no = Prompt.promptInt("번호? ");
    member.name = Prompt.promptString("이름? ");
    member.email = Prompt.promptString("이메일? ");
    member.password = Prompt.promptString("암호? ");
    member.photo = Prompt.promptString("사진? ");
    member.tel = Prompt.promptString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    members[size++] = member;
  }

  static void list() {
    System.out.println("[회원 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          members[i].no,
          members[i].name,
          members[i].email,
          members[i].tel,
          members[i].registeredDate);
    }
  }


}
```

<br>

2. 2단계: 프로젝트 정보를 저장할 때 새 메모리 타입을 정의<br>
```java
public class Project {

  int no;
  String title;
  String content;
  Date startDate;
  Date endDate;
  String owner;
  String members;


}
```
```java
public class ProjectHandler {

  static final int LENGTH = 5;
  static Project[] projects = new Project[LENGTH];
  static int size = 0;

  static void add() {
    Project project = new Project();
    
    System.out.println("[프로젝트 등록]");
    project.no = Prompt.promptInt("번호? ");
    project.title = Prompt.promptString("프로젝트명? ");
    project.content = Prompt.promptString("내용? ");
    project.startDate = Prompt.promptDate("시작일? ");
    project.endDate = Prompt.promptDate("종료일? ");
    project.owner = Prompt.promptString("만든이? ");
    project.members = Prompt.promptString("팀원? ");

    projects[size++] = project;
  }

  static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          projects[i].no,
          projects[i].title,
          projects[i].startDate,
          projects[i].endDate,
          projects[i].owner);
    }
  }


}
```

<br>

3. 3단계: 작업 정보를 저장할 때 새 메모리 타입 정의<br>
```java
public class Task {

  int no;
  String content;
  Date deadline;
  int status;
  String owner;


}
```
```java
public class TaskHandler {

  static final int LENGTH = 5;
  static Task[] tasks = new Task[LENGTH];
  static int size = 0;

  static void add() {
    Task task = new Task();

    System.out.println("[작업 등록]");
    task.no = Prompt.promptInt("번호? ");
    task.content = Prompt.promptString("내용? ");
    task.deadline = Prompt.promptDate("마감일? ");
    System.out.println("상태? ");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    task.status = Prompt.promptInt("> ");
    task.owner = Prompt.promptString("담당자? ");

    tasks[size++] = task;
  }

  static void list() {
    System.out.println("[작업 목록]");
    String statusLabel = null;
    for (int i=0; i<size; i++) {
      switch (tasks[i].status) {
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
          tasks[i].no,
          tasks[i].content,
          tasks[i].deadline,
          statusLabel,
          tasks[i].owner);
    }
  }


}
```
