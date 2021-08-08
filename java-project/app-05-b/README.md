### **05-b. 인스턴스 사용법: 인스턴스 필드가 필요한 이유와 사용법**<br>
1. 인스턴스 필드D
1-1. new 명령을 통해 Heap 영역에 생성<br>
1-2. 개별적으로 다뤄야 할 값이라면 인스턴스 필드로 선언<br>

2. 인스턴스 메서드<br>
2-1. 인스턴스 필드를 다룸<br>
2-2. 호출할 때 반드시 유효한 레퍼런스(인스턴스 주소)가 있어야 함<br>
2-3. 레퍼런스는 인스턴스 메서드의 내장 로컬 변수인 this에 저장<br>

#### **1. 훈련 목표**<br>
1. 인스턴스 필드와 인스턴스 메서드를 사용할 수 있음<br>
2. 스태틱 필드와 인스턴스 필드의 차이점과 용도 이해<br>
3. 스태틱 메서드와 인스턴스 메서드의 차이점와 용도 이해<br>

#### **2. 훈련 내용**<br>
1. 여러 개의 게시 판을 다루기 위해 BoardHandler의 필드와 메서드를 인스턴스 멤버로 전환<br>
2. 기존의 MemberHandler와 ProjectHandler, TaskHandler도 필드와 메서드를 인스턴스 멤버로 전환<br>

#### **3. 실습**<br>
1. 게시 글 목록 데이터를 보관하는 레퍼런스 배열을 인스턴스 변수로 전환<br>

```java
public class BoardHandler {
public static void main(String[] args) {
    Board[] boards = new Board[MAX_LENGHT];
    int size = 0;

    public static void add(BoardHandler that) {
        that.boards[that.size++] = board;
    }

    public static void list(BoardHandler that) {
        for (int i=0; i<that.size; i++) {
            System.out.printf("%d, %s, %s, %s, %d\n",
            that.boards[i].no,
            that.boards[i].title,
            that.boards[i].writer,
            that.boards[i].registeredDate,
            that.boards[i].viewCount,
            that.boards[i].like);
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
        BoardHandler.add(boardHandler);
    } else if (input.equals("/board/list")) {
        BoardHandler.list(boardHandler);
    }
}
}
```
