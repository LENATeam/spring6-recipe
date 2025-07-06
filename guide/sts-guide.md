# Spring6-Recipes STS 설치 가이드

## 소스 받기

다음와 같이 예제 소스를 가져옵니다.

```
git clone https://github.com/LENATeam/spring6-recipe.git
```

## 기본 환경설정

- JDK19 설치
- Gradle 설치(https://gradle.org/)

## STS 환경설정

### JDK 설정

Window > Preference 메뉴에 들어간 후 Java > Installed JREs 항목에서 SDK를 JDK 19를 선택합니다.  
![img](.//images/sts/sts-ide-java-settings-1.png)  

다음으로 Java > Compiler 항목에서 SDK를 JDK 19로 설정합니다.
![img](.//images/sts/sts-ide-java-settings-2.png)  

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

STS 기동 후 예제 프로젝트를 다음과 같이 import 합니다.  
![img](.//images/sts/sts-gradle-project-import.png)

### Gradle Build

Gradle Task 뷰에서 build > build 버튼을 더블클릭합니다.  
![img](.//images/sts/sts-gradle-build.png)

그러면 다음과 같이 빌드 수행이 성공하는 것을 확인할 수 있습니다.
![img](.//images/sts/sts-gradle-build-success.png)
