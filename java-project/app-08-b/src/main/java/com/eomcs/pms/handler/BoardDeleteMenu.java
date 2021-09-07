package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class BoardDeleteMenu extends Menu {

  BoardHandler boardHandler;

  public BoardDeleteMenu(BoardHandler boardHandler) {
    super("삭제");
    this.boardHandler = boardHandler;
  }

  @Override
  public void execute() {
    boardHandler.delete();
  }


}
