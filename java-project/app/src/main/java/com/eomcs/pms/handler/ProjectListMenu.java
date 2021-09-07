package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class ProjectListMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectListMenu(ProjectHandler projectHandler) {
    super("목록");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.list();
  }


}
