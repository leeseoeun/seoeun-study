package com.eomcs.pms.menu;

import com.eomcs.pms.handler.Stack;
import com.eomcs.util.Prompt;

public class MenuGroup extends Menu {

  //모든 메뉴가 공유할 객체이기 때문에 스태틱으로 선언
  static Stack breadCrumb = new Stack();

  Menu[] childs = new Menu[100];
  int size;

  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";

  public MenuGroup(String title) {
    super(title);
  }

  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }

  public void add(Menu child) {
    if (this.size == this.childs.length) {
      return;
    }

    this.childs[this.size++] = child;
  }

  public Menu remove(Menu child) {
    int index = indexOf(child);

    if (index == -1) {
      return null;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.childs[i - 1] = this.childs[i];
    }

    this.childs[--this.size] = null;

    return child;
  }

  public int indexOf(Menu child) {
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i] == child) {
        return i;
      }
    }
    return -1;
  }

  //배열에 있는 메뉴 객체 찾기
  public Menu getMenu(String title) {
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i].title.equals(title)) {
        return this.childs[i];
      }
    }
    return null;
  }

  @Override
  public void execute() {
    //현재 실행 중인 메뉴를 스택에 보관
    breadCrumb.push(this);

    while (true) {
      System.out.printf("\n[%s]\n", getBreadCrumb());
      for (int i = 0; i < this.size; i++) {
        System.out.printf("%d. %s\n", i + 1, this.childs[i].title);
      }
      if (!disablePrevMenu) {
        System.out.printf("0. %s\n", this.prevMenuTitle);
      }

      int menuNo = Prompt.inputInt("선택> ");
      if (menuNo == 0 && !disablePrevMenu) {
        //현재 메뉴에서 나갈 때 스택에서 제거
        breadCrumb.pop();
        return;
      }

      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue;
      }

      this.childs[menuNo - 1].execute();
    }
  }

  private String getBreadCrumb() {
    String path = "";

    for (int i = 0; i < this.breadCrumb.size(); i++) {
      if (path.length() > 0) {
        path += " / ";
      }

      Menu menu = (Menu) breadCrumb.get(i);
      path += menu.title;
    }

    return path;
  }


}
