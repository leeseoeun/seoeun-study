### **03-b. 메서드 사용법: 메서드 활용**<br>
#### **3. 실습**<br>
7. 사용자로부터 입력받는 코드를 prompt() 메서드로 분리<br>
=> prompt() 메서드를 정의하고 관련된 코드를 가지고 옴<br>

```java
public class App {
    static String input;
    public static void main(String[] args) {
        while (true) {
            prompt();
        }
    }
    
    static void prompt() {
    System.out.print("명령> ");
    input = sc.nextLine();
    }
}
```

7-2. 명령어뿐만 아니라 사용자로부터 입력받는 기능을 모두 prompt()를 사용하여 처리<br>
=> prompt()를 호출할 때 사용자에게 출력할 프롬프트 메시지를 아규먼트로 넘김<br>
=> prompt()는 호출할 때 넘어온 프롬프트 메시지 값을 파라미터로 받음<br>

```java
public class App {
    static String input;

    public static void main(String[] args) {
        while (true) {
            prompt("명령> ");   //while 문 안에 넣기
        }

    static void addMember() {
        System.out.println("[회원 등록]");
        prompt("번호? ");
        no[size] = Integer.parseInt(input); //input = sc.nextLine(); 이니까
        prompt("이름? ");
        name[size] = input;
        prompt("이메일? ");
        email[size] = input;
        prompt("암호? ");
        password[isze] = input;
        prompt("사진? ");
        photo[size] = input;
        prompt("전화? ");
        tel[size] = input;
        registeredDate[size] = new Date(System.currentTimeMillis());

        size++;
    }
    
    static void addProject() {
        System.out.println("[프로젝트 등록]");
        prompt("번호? ");
        pNo[pSize] = Integer.parseInt(input);
        prompt("프로젝트명? ");
        pTitle[pSize] = input;
        prompt("내용? ");
        pContent[pSize] = input;
        prompt("시작일? ");
        pStartDate[pSize] = Date.valueOf(input);
        prompt("종료일? ");
        pEndDate[pSize] = Date.valueOf(input);
        prompt("만든이? ");
        pOwner[pSize] = input;
        prompt("팀원? ");
        pMembers[pSize] = input;

        pSize++;
    }

    static void addTask() {
        System.out.println("[작업 등록]");
        prompt("번호? ");
        tNo[tSize] = Integer.parseInt(input);
        prompt("내용? ");
        tContent[tSize] = input;
        prompt("마감일? ");
        tDeadline[tSize] = Date.valueOf(input);
        System.out.println("상태? ");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        prompt("> ");   //> 에 입력받으니까 상태? (x)
        tStatus[tSize] = Integer.parseInt(input);
        prompt("담당자? ");
        tOwner[tSize] = input;

        tSize++;
    }

    static void prompt(String title) {
        System.out.print(title);
        input = sc.nextLine();
    }
}
```

7-3. prompt()가 작업한 결과를 클래스 변수에 담지 말고 호출자에게 리턴<br>
=> prompt()를 실행한 후 사용자가 입력한 문자열 리턴<br>

```java
public class App {
    static String input;    //(x)
    
    public static void main(String[] args) {
        while (true) {
            String input = prompt("명령> ");    //리턴을 input에 담기
        }

    static void addMember() {
        System.out.println("[회원 등록]");
        no[size] = Integer.parseInt(prompt("번호? "));
        name[size] = prompt("이름? ");
        email[size] = prompt("이메일? ");
        password[size] = prompt("암호? ");
        photo[size] = prompt("사진? ");
        tel[size] = prompt("전화? ");
        registeredDate[size] = new Date(System.currentTimeMillis());

        size++;
    }

    static void addProject() {
        System.out.println("[프로젝트 등록]");
        pNo[pSize] = Integer.parseInt(prompt("번호? "));
        pTitle[pSize] = prompt("프로젝트명? ");
        pContent[pSize] = prompt("내용? ");
        pStartDate[pSize] = Date.valueOf(prompt("시작일? "));
        pEndDate[pSize] = Date.valueOf(prompt("종료일? "));
        pOwner[pSize] = prompt("만든이? ");
        pMembers[pSize] = prompt("팀원? ");

        pSize++;
    }

    static void addTask() {
        System.out.println("[작업 등록]");
        tNo[tSize] = Integer.parseInt(prompt("번호? "));
        tContent[tSize] = prompt("내용? ");
        tDeadline[tSize] = Date.valueOf(prompt("마감일? "));
        System.out.println("상태? ");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        tStatus[tSize] = Integer.parseInt(prompt("> "));
        tOwner[tSize] = prompt("담당자? ");

        tSize++;
    }

    static String prompt(String title) {
        System.out.print(title);
        String input = sc.nextLine();
        return input;
    }
}
```

8. prompt()를 목적에 따라 더 세분화하여 분리<br>
=> promptString(), promptInt(), promptDate()<br>

```java
public class App {
    public static void main(String[] args) {
        while (true) {
            String input = promptString("명령> ");
        }

    static void addMember() {
        System.out.println("[회원 등록]");
        no[size] = promptInt("번호? ");
        name[size] = promptString("이름? ");
        email[size] = promptString("이메일? ");
        password[size] = promptString("암호? ");
        photo[size] = promptString("사진? ");
        tel[size] = promptString("전화? ");
        registeredDate[size] = new Date(System.currentTimeMillis());

        size++;
    }

    static void addProject() {
        System.out.println("[프로젝트 등록]");
        pNo[pSize] = promptInt("번호? ");
        pTitle[pSize] = promptString("프로젝트명? ");
        pContent[pSize] = promptString("내용? ");
        pStartDate[pSize] = promptDate("시작일? ");
        pEndDate[pSize] = promptDate("종료일? ");
        pOwner[pSize] = promptString("만든이? ");
        pMembers[pSize] = promptString("팀원? ");

        pSize++;
    }

    static void addTask() {
        System.out.println("[작업 등록]");
        tNo[tSize] = promptInt("번호? ");
        tContent[tSize] = promptString("내용? ");
        tDeadline[tSize] = promptDate("마감일? ");
        System.out.println("상태? ");
        System.out.println("0: 신규");
        System.out.println("1: 진행중");
        System.out.println("2: 완료");
        tStatus[tSize] = promptInt("> ");
        tOwner[tSize] = promptString("담당자? ");

        tSize++;
    }

    static String promptString(String title) {
        System.out.print(title);
        return sc.nextLine();
    }

    static int promptInt(String title) {
        System.out.print(title);
        return Integer.parseInt(sc.nextLine());
    }

     static Date promptDate(String title) {
        System.out.print(title);
        return Date.valueOf(sc.nextLine());
     }
}
```

8-2. promptString(), promptInt(), promptDate()의 코드 정리

```java
public class App {
    
    public static void main(String[] args) {
    }
    
    static String promptString(String title) {
        System.out.print(title);
        return sc.nextLine();
    }

    static int promptInt(String title) {
        //    System.out.print(title);
        //promptString(title)이 리턴하면서 출력하니까 sysout(x)
        return Integer.parseInt(promptString(title));
    }

    static Date promptDate(String title) {
        return Date.valueOf(promptString(title));
    }
}
```

<br>

*한번 더 연습하기..~*