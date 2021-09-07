package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class BoardAddMenu extends Menu {

  BoardHandler boardHandler;

  public BoardAddMenu(BoardHandler boardHandler) {
    super("등록");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.add();
  }


}
