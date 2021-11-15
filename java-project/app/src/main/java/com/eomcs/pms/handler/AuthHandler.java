package com.eomcs.pms.handler;

import java.util.List;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class AuthHandler {

  List<Member> memberList;

  public AuthHandler(List<Member> memberList) {
    this.memberList = memberList;
  }

  public void login() {
    System.out.println("[로그인]");

    String email = Prompt.inputString("이메일? ");
    String password = Prompt.inputString("비밀번호? ");

    Member member = findByEmailAndPassword(email, password);

    if (member == null) {
      System.out.println("이메일과 비밀번호가 일치하는 회원을 찾을 수 없습니다");
    } else {
      System.out.printf("%s 님 환영합니다!\n", member.getName());
    }
  }

  private Member findByEmailAndPassword(String email, String password) {
    for (Member member : memberList) {
      if (member.getEmail().equalsIgnoreCase(email) && member.getPassword().equals(password)) {
        return member;
      }
    }

    return null;
  }


}
