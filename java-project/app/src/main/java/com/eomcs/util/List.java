package com.eomcs.util;

public interface List {

  void add(Object item);

  Object[] toArray();

  boolean remove(Object item);

  int size();

  Object get(int index);
  Object remove(int indext);


}
