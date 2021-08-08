package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {

  static final int MAX_LENGHT = 5;
  Board[] boards = new Board[MAX_LENGHT];
  int size = 0;

  public void add() {
    Board board = new Board();
    System.out.println("[새 게시글]");
    board.no = Prompt.promptInt("번호? ");
    board.title = Prompt.promptString("내용? ");
    board.writer = Prompt.promptString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    this.boards[this.size++] = board;
  }

  public void list() {
    System.out.println("[게시글 목록]");
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
