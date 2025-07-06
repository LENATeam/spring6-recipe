# Spring6-Recipes ItelliJ 설치 가이드

## 소스 받기

다음와 같이 예제 소스를 가져옵니다.

```
git clone https://github.com/LENATeam/spring6-recipe.git
```

## 기본 환경설정

- JDK19 설치
- Gradle 설치(https://gradle.org/)

## IntelliJ 환경설정

### JDK 설정

Project Structure(프로젝트 클릭 후 F4) 화면에 들어간 후 Project Settings > Proejct 메뉴에서 SDK를 JDK 19를 선택합니다.  
![img](.//images/intellij/jdk_setting.PNG)  

바로 아래의 Modules > Dependencies에서도 Module SDK를 JDK 19로 설정합니다.

### 프로젝트 열기

예제 프로젝트의 최상위에 위치한 gradle.properties에 다음과 같이 java 위치(org.gradle.java.home)를 추가해줍니다.

```
group=com.apress.spring6recipes
version=6.0.0-SNAPSHOT

org.gradle.java.home=C:\\Program Files\\Java\\jdk-19.0.2
org.gradle.caching=true
org.gradle.parallel=true
org.gradle.jvmargs=-Xmx2g -Dfile.encoding=UTF-8
org.gradle.warning.mode=all
```

IntelliJ 기동 후 예제 프로젝트를 엽니다.  

### Gradle Build

원하는 Chapter 목록 중 Tasks 하위의 build > build 버튼을 더블클릭합니다.  
![img](.//images/intellij/gradle_build.PNG)  

그러면 console 창을 통해 build가 정상적으로 성공함을 확인할 수 있습니다.  
![img](.//images/intellij/gradle_build_success.PNG)
