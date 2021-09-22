package com.eomcs.pms.handler;

public abstract class AbstractList implements List {

  protected int size;

  @Override
  //인터페이스, 추상 클래스의 메서드: public abstract

  //size() 메서드는 구현한 거기 때문에(Override) -> (default), 접근 범위를 줄일 수 없음 => public으로
  public int size() {
    return this.size;
  }


}
