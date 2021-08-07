package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  static final int MAX_LENGTH = 5;
  static Member[] members = new Member[MAX_LENGTH];
  static int size = 0;

  public static void add() {    //Project와 Task의 메서드도 public으로
    Member member = new Member();

    System.out.println("[회원 등록]");
    member.no = Prompt.promptInt("번호? ");
    member.name = Prompt.promptString("이름? ");
    member.email = Prompt.promptString("이메일? ");
    member.password = Prompt.promptString("암호? ");
    member.photo = Prompt.promptString("사진? ");
    member.tel = Prompt.promptString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    members[size++] = member;
  }

  public static void list() {
    System.out.println("[회원 목록]");
    for (int i=0; i<size; i++) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          members[i].no,
          members[i].name,
          members[i].email,
          members[i].tel,
          members[i].registeredDate);
    }
  }

  static boolean exits(String name) {
    for (int i=0; i<size; i++) {
      if (name.equals(members[i].name)) {
        return true;
      }
    }
    return false;
  }


}
