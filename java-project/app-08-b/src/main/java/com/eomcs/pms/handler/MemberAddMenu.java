package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class MemberAddMenu extends Menu {

  MemberHandler memberHandler;

  public MemberAddMenu(MemberHandler memberHandler) {
    super("등록");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.add();
  }


}
