## **01-a. 프로젝트 준비하기: Gradle 빌드 도구를 활용한 자바 프로젝트 구성**<br>
### **3. 실습**<br>
#### **4단계: 자바 애플리케이션 실행**<br>
그레이들을 이용해서 자바 애플리케이션 실행<br>
```console
[cmd]
java-project$ gradle run

> Task :app:run
Hello World!
```
**0. gradle run**<br>
app/src/main/java/ 폴더에 있는 모든 자바 소스 파일 컴파일<br>

<br><br>

**1. compileJava**<br>
src/main/java 폴더에 있는 소스 파일 컴파일<br>
build/classes/java/main 폴더에 .class 파일을 둠<br>
```console
[cmd]
java-project$ cd app
app$ gradle compileJava
```

**2. compileTestJava**<br>
src/test/java 폴더에 있는 소스 파일 컴파일<br>
build/classes/java/test 폴더에 .class 파일을 둠<br>
```console
[cmd]
app$ cd app gradle compileTestJava
```

**3. processResources**<br>
src/main/resources 폴더에 있는 파일을 build/resources/main 폴더에 복사<br>
```console
[cmd]
app$ gradle processResources
```

**4. processTestResources**<br>
src/test/resources 폴더에 있는 파일을 build/resources/test 폴더에 복사<br>
```console
[cmd]
app$ gradle processTestResources
```

**5. clean**<br>
build 폴더 삭제<br>
```console
[cmd]
app$ gradle clean
```

**6. classes**<br>
compileJava + processResources 수행<br>
```console
[cmd]
app$ gradle classes
```

**7. testClasses**<br>
classes + compileTestJava + processTestResources 수행<br>
```console
[cmd]
app$ gradle clean
app$ gradle testClasses
```

**8. check**<br>
단위 테스트 수행<br>
```console
[cmd]
app$ gradle check
```

**9. javadoc**<br>
소스 파일에서 javadoc 주석을 추출해 HTML로 된 API 문서 생성<br>
```console
[cmd]
app$ gradle javadoc
```

<br>

#### **5단계: 프로젝트 빌드**<br>
그레이들을 이용해서 일반 사용자에게 배포할 파일을 만듦<br>
```console
[cmd]
app$ gradle build
```
