package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  static final int MAX_LENGTH = 5;
  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;

  //특정 인스턴스의 값을 다루고 싶다면 파라미터로 그 인스턴스의 주소를 받아야 함
  public void add(MemberHandler memberHandler) {
    Project project = new Project();

    System.out.println("[프로젝트 등록]");
    project.no = Prompt.promptInt("번호? ");
    project.title = Prompt.promptString("프로젝트명? ");
    project.content = Prompt.promptString("내용? ");
    project.startDate = Prompt.promptDate("시작일? ");
    project.endDate = Prompt.promptDate("종료일? ");

    while (true) {
      String owner = Prompt.promptString("만든이?(취소: 빈 문자열) ");
      if (memberHandler.exits(owner)) {
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
      if (memberHandler.exits(member)) {
        if (members.length() > 0) {
          members += ",";
        }
        members += member;
        continue;
      } else if (member.length() == 0) {
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
    project.members = members;

    this.projects[this.size++] = project;
  }

  public void list() {
    System.out.println("[프로젝트 목록]");
    for (int i=0; i<this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          this.projects[i].no,
          this.projects[i].title,
          this.projects[i].startDate,
          this.projects[i].endDate,
          this.projects[i].owner,
          this.projects[i].members);
    }
  }


}
