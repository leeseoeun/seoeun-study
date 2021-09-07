package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class TaskListMenu extends Menu {

  TaskHandler taskHandler;

  public TaskListMenu(TaskHandler taskHandler) {
    super("목록");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.list();
  }


}
