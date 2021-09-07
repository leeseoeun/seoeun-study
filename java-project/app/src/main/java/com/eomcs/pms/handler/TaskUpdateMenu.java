package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class TaskUpdateMenu extends Menu {

  TaskHandler taskHandler;

  public TaskUpdateMenu(TaskHandler taskHandler) {
    super("변경");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.update();
  }


}
