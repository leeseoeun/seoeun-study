package com.eomcs.pms;

import com.eomcs.pms.handler.BoardAddMenu;
import com.eomcs.pms.handler.BoardDeleteMenu;
import com.eomcs.pms.handler.BoardDetailMenu;
import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.BoardListMenu;
import com.eomcs.pms.handler.BoardUpdateMenu;
import com.eomcs.pms.handler.MemberAddMenu;
import com.eomcs.pms.handler.MemberDeleteMenu;
import com.eomcs.pms.handler.MemberDetailMenu;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.MemberListMenu;
import com.eomcs.pms.handler.MemberUpdateMenu;
import com.eomcs.pms.handler.ProjectAddMenu;
import com.eomcs.pms.handler.ProjectDeleteMenu;
import com.eomcs.pms.handler.ProjectDetailMenu;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.ProjectListMenu;
import com.eomcs.pms.handler.ProjectUpdateMenu;
import com.eomcs.pms.handler.TaskAddMenu;
import com.eomcs.pms.handler.TaskDeleteMenu;
import com.eomcs.pms.handler.TaskDetailMenu;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.pms.handler.TaskListMenu;
import com.eomcs.pms.handler.TaskUpdateMenu;
import com.eomcs.pms.menu.Menu;
import com.eomcs.pms.menu.MenuGroup;
import com.eomcs.util.Prompt;

public class App {

  static BoardHandler boardHandler = new BoardHandler();
  static MemberHandler memberHandler = new MemberHandler();

  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);

  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {
    Menu mainMenu = createMenu();
    mainMenu.execute();

    Prompt.close();
  }

  //트리 구조일 때 composite 패턴으로 만들기
  //수퍼 클래스 타입으로 만들기
  static Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);

    boardMenu.add(new BoardAddMenu(boardHandler));
    boardMenu.add(new BoardListMenu(boardHandler));
    boardMenu.add(new BoardDetailMenu(boardHandler));
    boardMenu.add(new BoardUpdateMenu(boardHandler));
    boardMenu.add(new BoardDeleteMenu(boardHandler));

    MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new MemberAddMenu(memberHandler));
    memberMenu.add(new MemberListMenu(memberHandler));
    memberMenu.add(new MemberDetailMenu(memberHandler));
    memberMenu.add(new MemberUpdateMenu(memberHandler));
    memberMenu.add(new MemberDeleteMenu(memberHandler));

    MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new ProjectAddMenu(projectHandler));
    projectMenu.add(new ProjectListMenu(projectHandler));
    projectMenu.add(new ProjectDetailMenu(projectHandler));
    projectMenu.add(new ProjectUpdateMenu(projectHandler));
    projectMenu.add(new ProjectDeleteMenu(projectHandler));

    MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new TaskAddMenu(taskHandler));
    taskMenu.add(new TaskListMenu(taskHandler));
    taskMenu.add(new TaskDetailMenu(taskHandler));
    taskMenu.add(new TaskUpdateMenu(taskHandler));
    taskMenu.add(new TaskDeleteMenu(taskHandler));

    return mainMenuGroup;
  }


}
