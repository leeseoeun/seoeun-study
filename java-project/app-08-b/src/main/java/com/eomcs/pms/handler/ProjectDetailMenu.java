package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class ProjectDetailMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectDetailMenu(ProjectHandler projectHandler) {
    super("상세보기");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.detail();
  }


}
