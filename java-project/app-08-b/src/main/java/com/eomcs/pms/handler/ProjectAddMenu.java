package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class ProjectAddMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectAddMenu(ProjectHandler projectHandler) {
    super("등록");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.add();
  }


}
