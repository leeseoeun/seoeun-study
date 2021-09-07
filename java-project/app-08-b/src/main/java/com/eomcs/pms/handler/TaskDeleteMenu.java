package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class TaskDeleteMenu extends Menu {

  TaskHandler taskHandler;

  public TaskDeleteMenu(TaskHandler taskHandler) {
    super("삭제");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.delete();
  }


}
