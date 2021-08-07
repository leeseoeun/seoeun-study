### **02-a. 값 다루기: 리터럴과 콘솔 출력**<br>
1. 리터럴: 정수, 부동 소수점, 문자, 문자열, 논리 값을 표현한 것<br>
2. 콘솔, 터미널, 표준 출력 장치<br>

#### **1. 훈련 목표**<br>
다양한 유형의 값을 콘솔로 출력하는 방법을 배움<br>

#### **2. 훈련 내용**<br>
1. 한명의 회원 정보를 콘솔로 출력<br>
2. 한개의 프로젝트 정보를 콘솔로 출력<br>
3. 한개의 작업 정보를 콘솔로 출력<br>

#### **3. 실습**<br>
1. 한명의 회원 정보 출력<br>
1-1. java-project를 이용하는 회원 정보 출력<br>
```console
[회원]
번호: 101
이름: 춘식이
이메일: chun@test.com
암호: 1111
사진: chun.png
전화:010-1111-2222
가입 일: 2021-01-01
```
```java
package com.eomcs.pms;
public class App {
  public static void main(String[] args) {
    System.out.println("[회원]");
    System.out.println("번호: 101");
    System.out.println("이름: 춘식이");
    System.out.println("이메일: chun@test.com");
    System.out.println("암호: 1111");
    System.out.println("사진: chun.jpg");
    System.out.println("전화: 010-1111-2222");
    System.out.println("가입 일: 2021-01-01");
  }
}
```
<br>
2. 한개의 프로젝트 정보 출력<br>
2-1. 회원이 진행할 프로젝트 정보 출력<br>
```console
[프로젝트]
번호: 1201
프로젝트 명: 미니 프로젝트 관리 시스템 개발
내용: 소규모 팀을 위한 프로젝트 관리 시스템을 개발한다
시작 일: 2021-01-01
종료 일: 2021-12-31
만든 이: 춘식이
팀원: 춘식이, 라이언, 어피치
```
```java
package com.eomcs.pms;
public class App2 {
  public static void main(String[] args) {
    System.out.println("[프로젝트]");
    System.out.println("번호: 1201");
    System.out.println("프로젝트 명: 미니 프로젝트 관리 시스템 개발");
    System.out.println("내용: 소규모 팀을 위한 프로젝트 관리 시스템을 개발한다");
    System.out.println("시작 일: 2021-01-31");
    System.out.println("종료 일: 2021-12-31");
    System.out.println("만든 이: 춘식이");
    System.out.println("팀원: 춘식이, 라이언, 어피치");
  }
}
```
<br>
3. 한개의 작업 정보 출력<br>
3-1. 프로젝트에서 수행할 작업 정보 출력<br>
```console
[작업]
프로젝트: 미니 프로젝트 관리 시스템 개발
번호: 1
내용: 요구 사항 수집
완료 일: 2021-01-31
상태: 진행 중
담당자: 춘식이
```
```java
package com.eomcs.pms;
public class App3 {
  public static void main(String[] args) {
    System.out.println("[작업]");
    System.out.println("프로젝트: 미니 프로젝트 관리 시스템 개발");
    System.out.println("번호: 1");
    System.out.println("내용: 요구 사항 수집");
    System.out.println("완료 일: 2021-01-31");
    System.out.println("상태: 진행 중");
    System.out.println("담당자: 춘식이");
  }
}
```
