package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  static final int LENGTH = 5;
  static Project[] projects = new Project[LENGTH];
  static int size = 0;

  public static void add() {
    Project project = new Project();

    System.out.println("[프로젝트 등록]");
    project.no = Prompt.promptInt("번호? ");
    project.title = Prompt.promptString("프로젝트명? ");
    project.content = Prompt.promptString("내용? ");
    project.startDate = Prompt.promptDate("시작일? ");
    project.endDate = Prompt.promptDate("종료일? ");
    project.owner = Prompt.promptString("만든이? ");
    project.members = Prompt.promptString("팀원? ");

    projects[size++] = project;
  }

  public static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          projects[i].no,
          projects[i].title,
          projects[i].startDate,
          projects[i].endDate,
          projects[i].owner);
    }
  }


}
