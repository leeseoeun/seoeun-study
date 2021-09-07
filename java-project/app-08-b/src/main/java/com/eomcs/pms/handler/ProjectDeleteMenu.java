package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class ProjectDeleteMenu extends Menu {

  ProjectHandler projectHandler;

  public ProjectDeleteMenu(ProjectHandler projectHandler) {
    super("삭제");
    this.projectHandler = projectHandler;
  }

  @Override
  public void execute() {
    projectHandler.delete();
  }


}
