## **01-b. 프로젝트 준비하기: Eclipse IDE로 임포트**<br>
### **1. 훈련 목표**<br>
1. 그레이들을 이용해서 이클립스 IDE 프로젝트로 전환하는 방법을 배움<br>
2. 이클립스 워크 스페이스로 프로젝트를 가지고 오는 것을 배움<br>
3. 이클립스에서 프로젝트를 빌드하고 실행하는 방법을 배움<br>

<br>

### **2. 훈련 내용**<br>
1. 그레이들을 이용해서 이클립스 IDE 프로젝트를 위한 설정 파일 생성<br>
2. 이클립스 IDE로 프로젝트를 가지고 옴<br>
3. 이클립스 IDE에서 애플리케이션 실행<br>

<br>

### **3. 실습**<br>
#### **1단계: 그레이들 빌드 스크립트에 이클립스 플러그인 추가**<br>
그레이들에서 이클립스 관련 명령을 다룰 수 있도록 플러그인 추가<br>
```groovy
[build.gradle]
plugins {
    id 'java'
    id 'application'
    id 'eclipse'    //추가
}
```

<br>

프로젝트 이름(app)을 바꾸고 싶다면 이클립스 설정 추가<br>
```groovy
[build.gradle]
eclipse {
    project {
        name = "java-project"
    }
}
```

<br>

#### **2단계: 이클립스 IDE 설정 파일 생성**<br>
그레이들 빌드 도구를 이용해서 이클립스 IDE에서 사용할 설정 파일 생성<br>
```console
[cmd]
app$ gradle eclipse
```

<br>

#### **이클립스 프로젝트의 조건**<br>
1. .project<br>
2. .classpath<br>
3. settings/<br>

```console
[cmd]
app$ gradle eclipseProject
app$ gradle eclipseClasspath
app$ gradle eclipseJdt  //settings/
//설치

app$ gradle cleanEclipseProject
app$ gradle cleanEclipseClasspath
app$ gradle cleanEclipseJdt
//삭제
```

<br>

#### **3단계: 이클립스 IDE로 프로젝트 불러오기**<br>
1. 이클립스 IDE 메뉴 > File > Import...<br>
2. 임포트 대화 창 > General 노드 > Existing Projects into Workspace > Next<br>
3. Browse... > java-project > Finish<br>

<br>

#### **4단계: 이클립스 IDE에서 프로젝트 실행**<br>
