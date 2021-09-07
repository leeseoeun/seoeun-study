package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class BoardListMenu extends Menu {

  BoardHandler boardHandler;

  public BoardListMenu(BoardHandler boardHandler) {
    super("목록");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.list();
  }


}
