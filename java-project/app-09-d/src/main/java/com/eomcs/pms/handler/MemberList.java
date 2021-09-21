package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Member;

public class MemberList {

  static final int MAX_LENGTH = 5;
  Member[] members = new Member[MAX_LENGTH];
  int size = 0;

  public void add(Member member) {
    if (size == members.length) {
      Member[] arr = new Member[members.length + (members.length >> 1)];

      for (int i = 0; i < this.size; i++) {
        arr[i] = members[i];
      }

      members = arr;
    }

    this.members[size++] = member;
  }

  public Member[] toArray() {
    Member[] arr = new Member[size];

    for (int i = 0; i < this.size; i++) {
      arr[i] = members[i];
    }

    return arr;
  }

  public Member findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (members[i].no == no) {
        return members[i];
      }
    }

    return null;
  }

  public boolean remove(Member member) {
    int index = indexOf(member);

    if (index == -1) {
      return false;
    }

    for (int i = index + 1; i < this.size; i++) {
      members[i - 1] = members[i];
    }

    members[--size] = null;

    return true;
  }

  private int indexOf(Member member) {
    for (int i = 0; i < this.size; i++) {
      if (members[i] == member) {
        return i;
      }
    }

    return -1;
  }

  boolean exits(String name) {
    for (int i=0; i<this.size; i++) {
      if (name.equals(this.members[i].name)) {
        return true;
      }
    }
    return false;
  }


}
