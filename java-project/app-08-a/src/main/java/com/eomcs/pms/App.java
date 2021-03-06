package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

public class App {

  //스태틱 변수 선언 위치: 클래스 영역
  static BoardHandler boardHandler = new BoardHandler();
  static MemberHandler memberHandler = new MemberHandler();

  static ProjectHandler projectHandler = new ProjectHandler(memberHandler);

  static TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {
    while (true) {
      int menuNo = doMainMenu();

      if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {
        doBoardMenu();

      } else if (menuNo == 2) {
        doMemberMenu();

      } else if (menuNo == 3) {
        doProjectMenu();

      } else if (menuNo == 4) {
        doTaskMenu();

      } else {
        //옳지 않은 번호를 입력한 경우에는 다시 메인을 출력
        continue;
      }
    }

    Prompt.close();
  }

  static void doBoardMenu() {
    while (true) {
      System.out.println("[메인/게시판]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("게시판> ");
      System.out.println();

      switch (menuNo) {
        case 1: boardHandler.add(); break;
        case 2: boardHandler.list(); break;
        case 3: boardHandler.detail(); break;
        case 4: boardHandler.update(); break;
        case 5: boardHandler.delete(); break;
        case 0: return;
        default: System.out.println("무효한 메뉴 번호입니다.");
      }
    }
  }

  static void doMemberMenu() {
    while (true) {
      System.out.println("[메인/회원]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("회원> ");
      System.out.println();

      switch (menuNo) {
        case 1: memberHandler.add(); break;
        case 2: memberHandler.list(); break;
        case 3: memberHandler.detail(); break;
        case 4: memberHandler.update(); break;
        case 5: memberHandler.delete(); break;
        case 0: return;
        default: System.out.println("무효한 메뉴 번호입니다.");
      }
    }
  }

  static void doProjectMenu() {
    while (true) {
      System.out.println("[메인/프로젝트]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("프로젝트> ");
      System.out.println();

      switch (menuNo) {
        case 1: projectHandler.add(); break;
        case 2: projectHandler.list(); break;
        case 3: projectHandler.detail(); break;
        case 4: projectHandler.update(); break;
        case 5: projectHandler.delete(); break;
        case 0: return;
        default: System.out.println("무효한 메뉴 번호입니다.");
      }
    }
  }

  static void doTaskMenu() {
    while (true) {
      System.out.println("[메인/작업]");
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 상세보기");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전메뉴");

      int menuNo = Prompt.inputInt("작업> ");
      System.out.println();

      switch (menuNo) {
        case 1: taskHandler.add(); break;
        case 2: taskHandler.list(); break;
        case 3: taskHandler.detail(); break;
        case 4: taskHandler.update(); break;
        case 5: taskHandler.delete(); break;
        case 0: return;
        default: System.out.println("무효한 메뉴 번호입니다.");
      }
    }
  }

  static int doMainMenu() {
    System.out.println("[메인]");
    System.out.println("1. 게시판");
    System.out.println("2. 회원");
    System.out.println("3. 프로젝트");
    System.out.println("4. 작업");
    System.out.println("0. 종료");

    return Prompt.inputInt("메인> ");
  }


}
