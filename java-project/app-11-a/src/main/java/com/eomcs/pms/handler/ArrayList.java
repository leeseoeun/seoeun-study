package com.eomcs.pms.handler;

public class ArrayList extends AbstractList {

  static final int MAX_LENGHT = 5;
  Object[] list = new Object[MAX_LENGHT];

  @Override
  public void add(Object obj) {
    if (size == list.length) {
      Object[] arr = new Object[list.length + (list.length >> 1)];

      for (int i = 0; i < this.size; i++) {
        arr[i] = list[i];
      }

      list = arr;
    }

    this.list[size++] = obj;
  }

  @Override
  public Object[] toArray() {
    Object[] arr = new Object[size];

    for (int i = 0; i < this.size; i++) {
      arr[i] = list[i];
    }

    return arr;
  }

  @Override
  public boolean remove(Object obj) {
    int index = indexOf(obj);

    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      list[i - 1] = list[i];
    }

    list[--size] = null;

    return true;
  }

  private int indexOf(Object obj) {
    for (int i = 0; i < this.size; i++) {
      if (list[i] == obj) {
        return i;
      }
    }

    return -1;
  }

  @Override
  public Object get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    return this.list[index];
  }

  @Override
  public Object remove(int index) {
    if (index < 0 || index > this.size) {
      return null;
    }

    Object deleted = this.list[index];

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }

    this.list[--size] = null;

    return deleted;
  }


}
