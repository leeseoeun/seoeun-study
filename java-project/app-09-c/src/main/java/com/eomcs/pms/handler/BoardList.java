package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Board;

public class BoardList {

  static final int MAX_LENGHT = 5;
  Board[] boards = new Board[MAX_LENGHT];
  int size = 0;

  public void add(Board board) {
    this.boards[size++] = board;
  }

  public Board[] toArray() {
    Board[] arr = new Board[size];

    for (int i = 0; i < this.size; i++) {
      arr[i] = boards[i];
    }

    return arr;
  }

  public Board findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (boards[i].no == no) {
        return boards[i];
      }
    }

    return null;
  }

  public boolean remove(Board board) {
    int index = indexOf(board);

    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      boards[i - 1] = boards[i];
    }

    //기억!
    boards[--size] = null;

    return true;
  }

  private int indexOf(Board board) {
    for (int i = 0; i < this.size; i++) {
      if (boards[i] == board) {
        return i;
      }
    }

    return -1;
  }


}
