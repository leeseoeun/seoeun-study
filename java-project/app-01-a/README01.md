## **01-a. 프로젝트 준비하기: Gradle 빌드 도구를 활용한 자바 프로젝트 구성**<br>
### **1. 훈련 목표**<br>
1. Gradle(그레이들) 빌드 도구를 사용해서 자바 프로젝트의 디렉토리를 생성하는 방법을 배움<br>
2. 자바 프로젝트의 디렉토리 구조와 용도 이해<br>
3. 그레이들로 프로젝트를 빌드하고 실행하는 방법을 배움<br>

<br>

### **2. 훈련 내용**<br>
1. 그레이들 빌드 도구로 자바 애플리케이션 프로젝트를 생성<br>
2. 자바 애플리케이션 프로젝트의 폴더 구조와 용도 확인<br>
3. 프로젝트를 빌드하고 실행<br>

<br>

### **3. 실습**<br>
#### **1단계: 프로젝트로 사용할 디렉토리 준비**<br>
사용자 홈 폴더에 자바 프로젝트로 사용할 폴더를 생성<br>
```console
[cmd]
$ mkdir java-project
$ cd java-project
```

<br>

#### **2단계: 디렉토리를 자바 애플리케이션 프로젝트로 전환**<br>
그레이들을 이용해서 자바 애플리케이션 프로젝트에 필요한 설정 파일과 폴더 준비<br>
```console
[cmd]
java-project$ gradle init

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Scala
  6: Swift
Enter selection (default: Java) [1..6] 3

Split functionality across multiple subprojects?:
  1: no - only one application project
  2: yes - application and library projects
Enter selection (default: no - only one application project) [1..2] 1

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 1

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit Jupiter) [1..4] 1

Project name (default: java-project): [엔터]
Source package (default: java.project): com.eomcs.pms
```

<br>

#### **3단계: 프로젝트의 디렉토리 구조 확인**<br>
그레이들로 생성한 디렉토리와 프로젝트 설정 파일 확인<br>
```console
[cmd]
java-project$ tree
```

<br>

#### **그레이들 빌드 도구가 생성한 프로젝트의 구조와 용도**<br>
![gradle](https://github.com/leeseoeun/java-project/raw/main/study-project/app-01-a/app-01-a.jpeg)
