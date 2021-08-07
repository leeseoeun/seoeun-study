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

    while (true) {
      String owner = Prompt.promptString("만든이?(취소: 빈 문자열) ");
      if (MemberHandler.exits(owner)) {
        project.owner = owner;
        break;
      }
      else if (owner.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    String members = "";
    while (true) {
      String member = Prompt.promptString("팀원?(완료: 빈 문자열) ");
      if (MemberHandler.exits(member)) {
        if (members.length() > 0) {
          members += ",";
        }
        members += member;

        //        if (members.length() == 0) {
        //          members += member;
        //        } else if (members.length() > 0) {
        //          members += "," + member;
        //        }

        continue;
      } else if (member.length() == 0) {
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
    project.members = members;

    projects[size++] = project;
  }

  public static void list() {
    System.out.println("[프로젝트 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          projects[i].no,
          projects[i].title,
          projects[i].startDate,
          projects[i].endDate,
          projects[i].owner,
          projects[i].members);
    }
  }


}
