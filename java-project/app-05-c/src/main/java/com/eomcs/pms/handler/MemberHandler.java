package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 5;
  Member[] members = new Member[MAX_LENGTH];
  int size = 0;

  public void add() {
    Member member = new Member();

    System.out.println("[회원 등록]");
    member.no = Prompt.promptInt("번호? ");
    member.name = Prompt.promptString("이름? ");
    member.email = Prompt.promptString("이메일? ");
    member.password = Prompt.promptString("암호? ");
    member.photo = Prompt.promptString("사진? ");
    member.tel = Prompt.promptString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    this.members[this.size++] = member;
  }

  public void list() {
    System.out.println("[회원 목록]");
    for (int i=0; i<this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          this.members[i].no,
          this.members[i].name,
          this.members[i].email,
          this.members[i].tel,
          this.members[i].registeredDate);
    }
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
