### **05-a. 인스턴스 사용법: 클래스 필드와 클래스 메서드의 한계**<br>
1. 클래스: 최초로 사용할 때 한번만 로딩<br>
=> 2. 클래스 필드(스태틱 필드): 클래스가 로딩 할 때 한번만 생성<br>

#### **1. 훈련 목표**<br>
1. 클래스 필드의 한계 이해<br>
2. 클래스 필드 상태에서 기능을 확장하는 방법과 그 문제점 확인<br>

#### **2. 훈련 내용**<br>
1. 프로젝트 참여자들이 의견을 나눌 게시 판 추가<br>
1-1. 게시 글을 등록하고 목록 조회<br>

#### **3. 실습**<br>
1. 게시 글 입력 처리<br>
2. 게시 글 목록 출력 처리<br>
3. 게시 판에 좋아요 수 출력<br>

```java
public class Board {
  public int no;
  public String title;
  public String content;
  public String writer;
  public Date registeredDate;
  public int viewCount;
  public int like;
}
```

```java
public class BoardHandler {
  static final int MAX_LENGHT = 5;
  static Board[] boards = new Board[MAX_LENGHT];
  static int size = 0;

  public static void add() {
    Board board = new Board();
    System.out.println("[새 게시글]");
    board.no = Prompt.promptInt("번호? ");
    board.title = Prompt.promptString("내용? ");
    board.writer = Prompt.promptString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    boards[size++] = board;
  }

  public static void list() {
    System.out.println("[게시글 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %d\n",
          boards[i].no,
          boards[i].title,
          boards[i].writer,
          boards[i].registeredDate,
          boards[i].viewCount,
          boards[i].like);
    }
  }
}
```
