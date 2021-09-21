package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;

public class ProjectList {

  static final int MAX_LENGTH = 5;
  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;

  public void add(Project project) {
    this.projects[size++] = project;
  }

  public Project[] toArray() {
    Project[] arr = new Project[size];

    for (int i = 0; i < this.size; i++) {
      arr[i] = projects[i];
    }

    return arr;
  }

  public Project findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (projects[i].no == no) {
        return projects[i];
      }
    }

    return null;
  }

  public boolean remove(Project project) {
    int index = indexOf(project);

    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      projects[i - 1] = projects[i];
    }

    projects[--size] = null;

    return true;
  }

  private int indexOf(Project project) {
    for (int i = 0; i < this.size; i++) {
      if (projects[i] == project) {
        return i;
      }
    }

    return -1;
  }


}
