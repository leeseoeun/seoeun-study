package com.eomcs.util;

//인터페이스에 제네릭을 적용하면 최종 타입은 인터페이스를 구현하는 클래스에서 전달
public interface List<E> {

  void add(E item);

  Object[] toArray();

  boolean remove(E obj);

  int size();

  E get(int index);
  E remove(int index);

  E[] toArray(E[] arr);


}
