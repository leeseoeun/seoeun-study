package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class ProjectUpdateMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectUpdateMenu(ProjectHandler projectHandler) {
    super("변경");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.update();
  }


}
