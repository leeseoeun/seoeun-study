package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Task;

public class TaskList {

  static final int MAX_LENGTH = 5;
  Task[] tasks = new Task[MAX_LENGTH];
  int size = 0;

  public void add(Task task) {
    if (size == tasks.length) {
      Task[] arr = new Task[tasks.length + (tasks.length >> 1)];

      for (int i = 0; i < this.size; i++) {
        arr[i] = tasks[i];
      }

      tasks = arr;
    }

    this.tasks[size++] = task;
  }

  public Task[] toArray() {
    Task[] arr = new Task[size];

    for (int i = 0; i < this.size; i++) {
      arr[i] = tasks[i];
    }

    return arr;
  }

  public Task findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (tasks[i].no == no) {
        return tasks[i];
      }
    }

    return null;
  }

  public boolean remove(Task task) {
    int index = indexOf(task);

    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      tasks[i - 1] = tasks[i];
    }

    tasks[--size] = null;

    return true;
  }

  private int indexOf(Task task) {
    for (int i = 0; i < this.size; i++) {
      if (tasks[i] == task) {
        return i;
      }
    }

    return -1;
  }


}
