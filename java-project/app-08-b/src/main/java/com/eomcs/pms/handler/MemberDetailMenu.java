package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class MemberDetailMenu extends Menu {

  MemberHandler memberHandler;

  public MemberDetailMenu(MemberHandler memberHandler) {
    super("상세보기");
    this.memberHandler = memberHandler;
  }

  @Override
  public void execute() {
    memberHandler.detail();
  }


}
