### **04-d. 클래스 사용법: 의존 관계**<br>
의존 관계: 메서드를 사용하는 클래스(client)와 메서드를 제공하는 클래스(supplier)의 관계<br>

#### **1. 훈련 목표**<br>
1. 클래스 간의 의존 관계가 무엇인지 이해<br>
2. 의존 관계에서 클라이언트 역할과 공급자 역할 이해<br>
3. 조건 문, 반복 문 등 기본 문법을 활용해서 명령의 흐름을 제어하는 것을 연습<br>

#### **2. 훈련 내용**<br>
1. 프로젝트 생성자와 팀원을 등록할 때 회원 정보를 조회해서 등록<br>
2. 작업 담당자를 등록할 때 회원 정보를 조회해서 등록<br>

#### **3. 실습**<br>
1. 프로젝트 정보를 등록할 때 만든 이의 이름을 회원 정보에서 조회<br>
1-1. 만든 이의 이름이 유효하다면 다음 입력으로 넘어감<br>
1-2. 만든 이의 이름이 무효하다면 오류를 알리고 다시 입력받음<br>
```java
public class MemberHandler {
static boolean exits(String name) {
    for (int i=0; i<size; i++) {
        if (name.equals(members[i].name)) {
            return true;
        }
    }
    return false;
}
}
```
```java
public class ProjectHandler {
public static void add() {
    while (true) {
        String owner = Prompt.promptString("만든이? ");
        if (MemberHandler.exits(owner)) {
            project.owner = owner;
            break;
        }
        System.out.println("등록된 회원이 아닙니다.");
    }
}
}
```

<br>

2. 프로젝트의 만든 이 이름을 입력하지 않으면 프로젝트 등록 취소<br>
```java
public class ProjectHandler {
public static void add() {
    else if (owner.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
    }
}
}
```

<br>

3. 프로젝트 팀원을 등록할 때 회원 정보에서 조회<br>
3-1. 팀원 이름을 입력받고 등록된 회원이 아니면 오류를 알림<br>
3-2. 팀원 등록을 완료하고 싶다면 빈 문자열 입력<br>
```java
public class ProjectHandler {
public static void add() {
    String members = "";
    while (true) {
        String member = Prompt.promptString("팀원?(완료: 빈 문자열) ");
        if (MemberHandler.exits(member)) {
            members += "," + member;                continue;
        } else if (member.length() == 0) {
            break;
        }
        System.out.println("등록된 회원이 아닙니다.");
    }
    project.members = members;
}
}
```

<br>

4. 프로젝트 목록을 출력할 때 팀원 이름도 포함<br>
```java
public class ProjectHandler {
public static void add() {
    String members = "";
    while (true) {
        String member = Prompt.promptString("팀원?(완료: 빈 문자열) ");
        if (MemberHandler.exits(member)) {
            if (members.length() > 0) {
            members += ",";
            }
            members += member;

            //if (members.length() == 0) {
            //  members += member;
            //} else if (members.length() > 0) {
            //  members += "," + member;
            //}

            continue;
        } else if (member.length() == 0) {
            break;
        }
        System.out.println("등록된 회원이 아닙니다.");
    }
    project.members = members;
}
}
```
```java
public static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i=0; i<size; i++) {
        System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
            projects[i].no,
            projects[i].title,
            projects[i].startDate,
            projects[i].endDate,
            projects[i].owner,
            projects[i].members);
    }
}
```

<br>

5. 작업 정보를 등록할 때 담당자 이름을 회원 정보에서 조회<br>
5-1. 담당자의 이름이 유효하다면 다음 입력으로 넘어감<br>
5-2. 담당자의 이름이 무효하다면 오류를 알리고 다시 입력받음<br>
5-3. 담당자의 이름이 빈 문자열이라면 등록 취소<br>
```java
public class TaskHandler {
public static void add() {
while (true) {
    String owner = Prompt.promptString("담당자?(취소: 빈 문자열) ");
    if (MemberHandler.exits(owner)) {
        task.owner = owner;
        break;
    } else if (owner.length() == 0) {
        System.out.println("작업 등록을 취소합니다.");
        return;
    }
    System.out.println("등록된 회원이 아닙니다.");
    }
}
}
```
