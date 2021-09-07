package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class TaskAddMenu extends Menu {

  TaskHandler taskHandler;

  public TaskAddMenu(TaskHandler taskHandler) {
    super("등록");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.add();
  }


}
