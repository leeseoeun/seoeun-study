package com.eomcs.pms.handler;

import com.eomcs.pms.menu.Menu;

public class TaskDetailMenu extends Menu {

  TaskHandler taskHandler;

  public TaskDetailMenu(TaskHandler taskHandler) {
    super("상세보기");
    this.taskHandler = taskHandler;
  }

  @Override
  public void execute() {
    taskHandler.detail();
  }


}
