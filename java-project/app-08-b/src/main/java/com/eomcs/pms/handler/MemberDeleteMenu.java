package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class MemberDeleteMenu extends Menu {

  MemberHandler memberHandler;

  public MemberDeleteMenu(MemberHandler memberHandler) {
    super("삭제");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.delete();
  }


}
