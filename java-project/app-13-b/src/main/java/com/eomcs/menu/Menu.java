package com.eomcs.menu;

public abstract class Menu {

  String title;

  //'메뉴' 이름 없이 인스턴스를 생성할 수 없도록 기본 생성자를 정의하지 않음
  //인스턴스를 만들 때 메뉴 이름을 입력하도록 강제하기 위해서 String을 파라미터로 받는 생성자 정의
  public Menu(String title) {
    this.title = title;
  }

  public abstract void execute();


}
