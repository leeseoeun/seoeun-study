package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

public class App {

  public static void main(String[] args) {

    BoardHandler boardHandler = new BoardHandler();
    MemberHandler memberHandler = new MemberHandler();
    ProjectHandler projectHandler = new ProjectHandler();
    TaskHandler taskHandler = new TaskHandler();

    while (true) {
      String input = Prompt.promptString("명령? ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (input.equals("/member/add")) {
        memberHandler.add();

      } else if (input.equals("/member/list")) {
        memberHandler.list();

      } else if (input.equals("/project/add")) {
        projectHandler.add(memberHandler);

      } else if (input.equals("/project/list")) {
        projectHandler.list();

      } else if (input.equals("/task/add")) {
        taskHandler.add(memberHandler);

      } else if (input.equals("/task/list")) {
        taskHandler.list();

      } else if (input.equals("/board/add")) {
        boardHandler.add();

      } else if (input.equals("/board/list")) {
        boardHandler.list();

      } else {
        System.out.println("실행할 수 없는 명령어입니다.");
      }

      System.out.println();
    }

    Prompt.close();

  }


}
