package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class BoardUpdateMenu extends Menu {

  BoardHandler boardHandler;

  public BoardUpdateMenu(BoardHandler boardHandler) {
    super("변경");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.update();
  }


}
