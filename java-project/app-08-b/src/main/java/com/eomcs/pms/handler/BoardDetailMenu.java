package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class BoardDetailMenu extends Menu {

  BoardHandler boardHandler;

  public BoardDetailMenu(BoardHandler boardHandler) {
    super("상세보기");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.detail();
  }


}
