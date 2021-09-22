package com.eomcs.util;

public class Stack extends ArrayList {

  public void push(Object item) {
    //맨 끝에 추가하기 때문에 기존의 add() 메서드 이용(ArrayList)
    this.add(item);
  }

  public Object pop() {
    //맨 끝에 것을 삭제하기 때문에
    return this.remove(this.size() - 1);
  }


}
