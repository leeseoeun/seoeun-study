package com.eomcs.pms;

import java.sql.Date;

public class Member {

  //스태틱 변수는 클래스가 로딩될 때 자동으로 딱 한번 생성되기 때문에
  //개별 데이터를 저장할 수 없으니까 static (x)
  //배열 (x)
  int no;
  String name;
  String email;
  String password;
  String photo;
  String tel;
  Date registeredDate;


}
