package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  /*
  ProjectHandler가 지속적으로 사용할 의존 객체는 인스턴스 필드로 받음
  이 인스턴스 변수에 의존 객체의 주소를 넣을 수 있도록 접근 모드를 공개로 설정
  public MemberHandler memberHandler;
   */
  MemberHandler memberHandler;
  //인스턴스를 사용하기 전에 값을 설정해야 하는 인스턴스 변수가 있다면 생성자의 파라미터로 선언
  public ProjectHandler(MemberHandler memberHandler) {
    //생성자에 파라미터가 있다면 인스턴스를 생성할 때 반드시 그 값을 넘겨야 함
    //인스턴스 변수의 값을 설정하는 것을 강제하는 효과
    this.memberHandler = memberHandler;
  }

  static final int MAX_LENGTH = 5;
  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;

  public void add() {
    Project project = new Project();

    System.out.println("[프로젝트 등록]");
    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");

    project.owner = promptOwner("만든이?(취소: 빈 문자열) ");
    if (project.owner == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return;
    }

    project.members = promptMembers();

    if (this.size == this.projects.length) {
      Project[] arr = new Project[this.projects.length + (this.projects.length >> 1)];
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.projects[i];
      }
      this.projects = arr;
    }

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

  public void detail() {
    System.out.println("[프로젝트 상세보기]");

    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    System.out.printf("프로젝트명: %s\n", project.title);
    System.out.printf("내용: %s\n", project.content);
    System.out.printf("시작일: %s\n", project.startDate);
    System.out.printf("종료일: %s\n", project.endDate);
    System.out.printf("만든이: %s\n", project.owner);
    System.out.printf("팀원: %s\n", project.members);
  }

  public void update() {
    System.out.println("[프로젝트 변경]");

    int no = Prompt.inputInt("번호? ");

    Project project = findByNo(no);

    if (project == null) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("프로젝트명(%s)? ", project.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", project.content));
    Date startDate = Prompt.inputDate(String.format("시작일(%s)? ", project.startDate));
    Date endDate = Prompt.inputDate(String.format("종료일(%s)? ", project.endDate));

    String owner = promptOwner(String.format("만든이(%s)? ", project.owner));
    if (owner == null) {
      System.out.println("프로젝트 등록을 취소합니다.");
      return;
    }

    String members = promptMembers(project.members);

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 변경을 취소하였습니다.");
      return;
    }

    project.title = title;
    project.content = content;
    project.startDate = startDate;
    project.endDate = endDate;
    project.owner = owner;
    project.members = members;

    System.out.println("프로젝트를 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");

    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.projects[i - 1] = this.projects[i];
    }

    this.projects[--this.size] = null;

    System.out.println("프로젝트를 삭제하였습니다.");
  }

  private Project findByNo(int no) {
    for (int i=0; i<this.size; i++) {
      if (no == this.projects[i].no) {
        return this.projects[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i=0; i<this.size; i++) {
      if (no == this.projects[i].no) {
        return i;
      }
    }
    return -1;
  }

  private String promptOwner(String label) {
    while (true) {
      String owner = Prompt.inputString(label);

      //MemberHandler 인스턴스는 인스턴스 필드에 미리 주입되어 있기 때문에 파라미터로 받을 필요가 없음
      //인스턴스 변수를 직접 사용하면 됨
      if (this.memberHandler.exits(owner)) {
        return owner;
      } else if (owner.length() == 0) {
        return null;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
  }

  private String promptMembers() {
    return promptMembers(null);
  }

  private String promptMembers(String oldMembers) {
    String members = "";
    while (true) {
      String member = Prompt.inputString(String.format(
          "팀원%s?(완료: 빈 문자열) ", oldMembers != null ? "(" + oldMembers + ")" : ""));
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
    return members;
  }


}
