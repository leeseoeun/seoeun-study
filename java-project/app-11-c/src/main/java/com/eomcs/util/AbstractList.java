package com.eomcs.util;

//추상 클래스에 제네릭을 적용하면 최종 타입은 서브 클래스를 정의할 때 전달
public abstract class AbstractList<E> implements List<E> {

  protected int size;

  @Override
  public int size() {
    return this.size;
  }


}
