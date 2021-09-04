### **05-c. 인스턴스 사용법: 인스턴스 메서드가 필요한 이유와 사용법**<br>

#### **3. 실습**<br>
1. BoardHandlr의 메서드를 인스턴스 메서드로 전환<br>

```java
public class BoardHandler {
public static void main(String[] args) {
    Board[] boards = new Board[MAX_LENGHT];
    int size = 0;

    public static void add() {
        this.boards[this.size++] = board;
    }

    public static void list() {
        for (int i=0; i<this.size; i++) {
            System.out.printf("%d, %s, %s, %s, %d\n",
            this.boards[i].no,
            this.boards[i].title,
            this.boards[i].writer,
            this.boards[i].registeredDate,
            this.boards[i].viewCount,
            this.boards[i].like);
        }
    }
}
}
```

```java
public class App {
public static void main(String[] args) {
    BoardHandler boardHandler = new BoardHandler();
    else if (input.equals("/board/add")) {
        boardHandler.add();
    } else if (input.equals("/board/list")) {
        boardHandler.list();
    }
}
}
```

2. MemberHandler와 ProjectHandler, TaskHandler도 BoardHandler처럼 인스턴스 메서드로 전환<br>

```java
public class ProjectHandler {
//특정 인스턴스의 값을 다루고 싶다면 파라미터로 그 인스턴스의 주소를 받아야 함
public void add(MemberHandler memberHandler) {
    while (true) {
        if (memberHandler.exits(owner))
    }
    while (true) {
        if (memberHandler.exits(member))
    }
}
}
```

```java
public class App {
public static void main(String[] args) {
    else if (input.equals("/project/add")) {
        projectHandler.add(memberHandler);
    }
}
}
```
