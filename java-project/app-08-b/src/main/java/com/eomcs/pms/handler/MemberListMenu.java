package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class MemberListMenu extends Menu {

  MemberHandler memberHandler;

  public MemberListMenu(MemberHandler memberHandler) {
    super("목록");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.list();
  }


}
