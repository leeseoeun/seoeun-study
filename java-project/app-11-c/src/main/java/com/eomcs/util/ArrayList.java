package com.eomcs.util;

import java.util.Arrays;

//일반 클래스에 제네릭을 적용하면 최종 타입은 해당 클래스의 인스턴스를 생성할 때 전달
public class ArrayList<E> extends AbstractList<E> {

  static final int MAX_LENGHT = 5;
  Object[] list = new Object[MAX_LENGHT];

  @Override
  public void add(E obj) {
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
  public boolean remove(E obj) {
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

  private int indexOf(E obj) {
    for (int i = 0; i < this.size; i++) {
      if (list[i] == obj) {
        return i;
      }
    }

    return -1;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    return (E) this.list[index];
  }

  @SuppressWarnings("unchecked")
  @Override
  public E remove(int index) {
    if (index < 0 || index > this.size) {
      return null;
    }

    E deleted = (E) this.list[index];

    for (int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i];
    }

    this.list[--size] = null;

    return deleted;
  }

  @SuppressWarnings("unchecked")
  @Override
  public E[] toArray(E[] arr) {
    if (arr.length >= this.size) {
      // 1. 파라미터로 받은 배열이 현재 목록에 있는 값을 담을 만큼 충분히 크다면
      // 현재 목록에 있는 값을 파라미터로 받은 배열에 복사함
      //      for (int i = 0; i < this.size; i++) {
      //        arr[i] = (E) this.list[i];
      //      }

      // 배열을 복사할 때 자바에서 제공하는 클래스를 사용하면
      // 반복 문을 작성할 필요 없이 보다 쉽게 배열을 복사할 수 있음
      //      => System.arraycopy(
      //          원래배열, 복사시작인덱스, 값을받을배열, 복사시작인덱스, 복사할개수);
      System.arraycopy(this.list, 0, arr, 0, this.size);

      return arr;   // 파라미터로 받은 배열을 그대로 리턴 함
    } else {
      // 2. 파라미터로 받은 배열이 현재 목록에 들어 있는 값을 담을 만큼 크지 않다면
      // 새 배열을 만들어 복사함
      // 그러나 다음과 같이 제네릭을 적용한 배열 인스턴스는 생성할 수 없음
      //      E[] temp = new E[this.size];  // 컴파일 오류!

      // 그래서 다른 클래스의 도움을 받아 배열을 생성해야 됨
      // 새 배열을 만들어 기존 배열의 값을 복사함
      // 방법 2-1. => Array.newInstance(배열항목의타입, 생성할배열의크기);
      // => arr.getClass(); => 배열의 타입 예) Project[]
      // => arr.getClass().getComponenetType(); => 배열의 각 항목의 타입 예) Project
      //      E[] temp = (E[]) Array.newInstance(arr.getClass().getComponentType(), this.size);
      //      System.arraycopy(this.list, 0, temp, 0, this.size);
      //      return temp;

      // 방법 2-2 => Arrays.copyOf(
      //     원래배열, 복사할개수, 새로만들배열의타입);
      E[] temp = (E[]) Arrays.copyOf(
          this.list,    // 원본 배열
          this.size,    // 복사할 개수. 현재 배열에 들어 있는 값들의 개수
          arr.getClass()    // 생성할 배열의 타입(파라미터의 배열과 같은 타입의 배열을 생성)
          );
      return temp;
    }
  }


}
