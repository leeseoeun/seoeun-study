package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  List projectList;

  MemberHandler memberHandler;

  public ProjectHandler(List projectList, MemberHandler memberHandler) {
    this.projectList = projectList;
    this.memberHandler = memberHandler;
  }

  public void add() {
    Project project = new Project();

    System.out.println("[프로젝트 등록]");
    project.setNo(Prompt.inputInt("번호? "));
    project.setTitle(Prompt.inputString("프로젝트명? "));
    project.setContent(Prompt.inputString("내용? "));
    project.setStartDate(Prompt.inputDate("시작일? "));
    project.setEndDate(Prompt.inputDate("종료일? "));

    project.setOwner(memberHandler.promptOwner("만든이?(취소: 빈 문자열) "));
    if (project.getOwner() == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return;
    }

    project.setMembers(memberHandler.promptMembers());

    projectList.add(project);
  }

  public void list() {
    System.out.println("[프로젝트 목록]");

    Object[] list = projectList.toArray();

    for (Object obj : list) {
      Project project = (Project) obj;
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          project.getNo(),
          project.getTitle(),
          project.getStartDate(),
          project.getEndDate(),
          project.getOwner(),
          project.getMembers());
    }
  }

  public void detail() {
    System.out.println("[프로젝트 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.getTitle());
    System.out.printf("내용: %s\n", project.getContent());
    System.out.printf("시작일: %s\n", project.getStartDate());
    System.out.printf("종료일: %s\n", project.getEndDate());
    System.out.printf("만든이: %s\n", project.getOwner());
    System.out.printf("팀원: %s\n", project.getMembers());
  }

  public void update() {
    System.out.println("[프로젝트 변경]");

    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.getContent()));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.getStartDate()));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.getEndDate()));

    String owner = memberHandler.promptOwner(String.format("만든이(%s)? ", project.getOwner()));
    if (owner == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return;
    }

    String members = memberHandler.promptMembers(project.getMembers());

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.setTitle(title);
    project.setContent(content);
    project.setStartDate(startDate);
    project.setEndDate(endDate);
    project.setOwner(owner);
    project.setMembers(members);

    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");

    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    projectList.remove(project);

    System.out.println("프로젝트를 삭제하였습니다.");
  }

  public Project findByNo(int no) {
    Object[] arr = projectList.toArray();

    for (Object obj : arr) {
      Project project = (Project) obj;

      if (project.getNo() == no) {
        return project;
      }
    }

    return null;
  }


}
