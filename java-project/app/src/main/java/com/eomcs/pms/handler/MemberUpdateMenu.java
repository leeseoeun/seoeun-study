package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class MemberUpdateMenu extends Menu {

  MemberHandler memberHandler;

  public MemberUpdateMenu(MemberHandler memberHandler) {
    super("변경");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.update();
  }


}
