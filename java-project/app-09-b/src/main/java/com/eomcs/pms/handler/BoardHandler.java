package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {

  //중첩 클래스에서 바깥 클래스의 인스턴스를 사용하지 않을 때 스태틱 중첩 클래스 사용
  //(바깥 클래스의 인스턴스에 종속되지 않을 때)
  static class Node {
    Board board;    //데이터가 저장될 필드
    Node next;  //다음 노드를 가리키는 필드

    public Node(Board board) {
      this.board = board;
    }
  }

  //*선언 위치
  Node head;
  Node tail;
  int size = 0;

  public void add() {
    Board board = new Board();
    System.out.println("[새 게시글]");
    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());

    //생성자를 호출할 때 노드에 담을 Board 객체 주소를 넘김
    //새로 만든 board를 새로 만든 node에 저장
    Node node = new Node(board);

    if (head == null) {
      tail = head = node;
    } else {
      //기존의 tail이 가리키는 마지막 노드의 next 변수에 새 노드 주소 저장
      tail.next = node;
      //새로 만든 노드를 마지막 노드로 설정
      tail = node;
    }

    size++;
  }

  public void list() {  
    System.out.println("[게시글 목록]");

    if (head == null) {
      return;
    }

    //node에 head 값을 넣어 주면 기존의 노드와 연결
    Node node = head;

    do {
      System.out.printf("%d, %s, %s, %s, %d, %d\n",
          node.board.no,
          node.board.title,
          node.board.writer,
          node.board.registeredDate,
          node.board.viewCount,
          node.board.like);

      node = node.next;
    } while (node != null);
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    Node node = head;
    Node prev = null;

    while (node != null) {
      if (node.board == board) {
        //삭제하려는 node가 '하필' head라면
        if (node == head) {
          head = node.next;
        } else {
          prev.next = node.next;
        }

        //다음 노드와의 연결을 끊음
        node.next = null;

        if (node == tail) {
          tail = prev;
        }

        break;
      }

      prev = node;
      node = node.next;
    }

    size--;

    System.out.println("게시글을 삭제하였습니다.");
  }

  private Board findByNo(int no) {
    Node node = head;

    while (node != null) {
      if (node.board.no == no) {
        return node.board;
      }

      node = node.next;
    }

    return null;
  }


}
