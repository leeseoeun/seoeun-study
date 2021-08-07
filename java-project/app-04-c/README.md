## **04-c. 클래스 사용법: 패키지로 클래스 분류**<br>
패키지<br>
1. 여러 개의 클래스를 관리하기 좋게 분류<br>
2. 실제 폴더를 가리킴<br>
3. 클래스 파일을 역할에 따라 패키지에 나누어 배치<br>

<br>

### **1. 훈련 목표**<br>
1. 패키지를 이용하여 역할에 따라 클래스를 분류하는 방법을 배움<br>
2. 패키지와 폴더의 관계 이해<br>
3. 멤버의 접근을 제어하는 default와 public의 사용법 이해<br>

<br>

### **2. 훈련 내용**<br>
1. Prompt 클래스를 다른 패키지로 분류함<br>
2. Handler 클래스를 다른 패키지로 분류함<br>
3. 사용자 정의 데이터 타입에 해당하는 클래스를 다른 패키지로 분류함<br>
4. 메서드의 접근 범위를 public으로 확장함<br>

<br>

### **3. 실습**<br>
1. 1단계: Prompt 클래스를 별도의 패키지로 분류<br>
```java
package com.eomcs.util;

public static String promptString(String title)
public static int promptInt(String title)
public static Date promptDate(String title)
public static void close()
```

<br>

2. 2단계: 사용자 정의 데이터 타입에 해당하는 클래스를 별도의 패키지로 분류<br>
```java
package com.eomcs.pms.domain;

import java.sql.Date;

public class Member {

  public int no;    //*Project와 Task의 변수도 public으로
  public String name;
  public String email;
  public String password;
  public String photo;
  public String tel;
  public Date registeredDate;


}
```

<br>

3. 3단계: Handler 클래스들을 별도의 패키지로 분류<br>
```java
package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {

  public static void add()    //Project와 Task의 메서드도 public으로
    
  public static void list()


}
```
