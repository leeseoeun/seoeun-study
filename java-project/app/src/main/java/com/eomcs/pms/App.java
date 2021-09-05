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
    projectHandler.memberHandler = memberHandler;
    //ProjectHandler의 메서드가 사용할 의존 객체는
    //메서드를 호출할 때마다 파라미터로 전달하는 것이 아니라
    //인스턴스 변수에 미리 주입

    TaskHandler taskHandler = new TaskHandler();
    taskHandler.memberHandler = memberHandler;

    while (true) {
      String input = Prompt.inputString("명령? ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (input.equals("/member/add")) {
        memberHandler.add();

      } else if (input.equals("/member/list")) {
        memberHandler.list();

      } else if (input.equals("/member/detail")) {
        memberHandler.detail();

      } else if (input.equals("/member/update")) {
        memberHandler.update();

      } else if (input.equals("/member/delete)")) {
        memberHandler.delete();

      } else if (input.equals("/project/add")) {
        projectHandler.add();

      } else if (input.equals("/project/list")) {
        projectHandler.list();

      } else if (input.equals("/project/detail")) {
        projectHandler.detail();

      } else if (input.equals("/project/update")) {
        projectHandler.update();

      } else if (input.equals("/project/delete")) {
        projectHandler.delete();

      } else if (input.equals("/task/add")) {
        taskHandler.add();

      } else if (input.equals("/task/list")) {
        taskHandler.list();

      } else if (input.equals("/task/update")) {
        taskHandler.update();

      } else if (input.equals("/task/delete")) {
        taskHandler.delete();

      } else if (input.equals("/board/add")) {
        boardHandler.add();

      } else if (input.equals("/board/list")) {
        boardHandler.list();

      } else if (input.equals("/board/detail")) {
        boardHandler.detail();

      } else if (input.equals("/board/update")) {
        boardHandler.update();

      } else if (input.equals("/board/delete")) {
        boardHandler.delete();

      } else {
        System.out.println("실행할 수 없는 명령어입니다.");
      }

      System.out.println();
    }

    Prompt.close();

  }


}
