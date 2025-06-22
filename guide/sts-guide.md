# Spring6-Recipes STS 설치 가이드

## 소스 받기

![img](.//images/spring-recipe-github.PNG)  
https://github.com/LENATeam/spring6-recipe  
위 spring6-recipe github 사이트로 이동하고 [https://github.com/LENATeam/spring6-recipe.git] 이 주소를 활용해 소스를 받는다.

```
git clone https://github.com/LENATeam/spring6-recipe.git
```
## STS 받기

![img](.//images/sts/sts-ide-download.png)  
[https://spring.io/tools/] 에서 STS를 다운로드 받는다.

## 기본 환경설정

- JDK19 설치
- Gradle 설치(https://gradle.org/)

## STS 환경설정

### JDK 설정

Window > Preference 메뉴를 선택한다. 
그리고, Java > Installed JREs 항목에서 SDK를 JDK 19를 선택한다.  
![img](.//images/sts/sts-ide-java-settings-1.png)  

또한, Java > Compiler 항목에서 SDK를 JDK 19로 설정한다.
![img](.//images/sts/sts-ide-java-settings-2.png)  

### Gradle 설정

gradle.properties에 아래와 같이 java 위치(org.gradle.java.home)를 추가해 준다.

```
group=com.apress.spring6recipes
version=6.0.0-SNAPSHOT

org.gradle.java.home=C:\\Program Files\\Java\\jdk-19.0.2
org.gradle.caching=true
org.gradle.parallel=true
org.gradle.jvmargs=-Xmx2g -Dfile.encoding=UTF-8
org.gradle.warning.mode=all
```

STS 기동 후 https://github.com/LENATeam/spring-6-recipes.git로부터 받은 프로젝트를 import 한다.
![img](.//images/sts/sts-gradle-project-import.png)

Gradle Task 뷰에서 프로젝트 build을 수행하면 다음과 같이 빌드 수행이 성공한다.
![img](.//images/sts/sts-gradle-build.png)
![img](.//images/sts/sts-gradle-build-success.png)

각 예제의 Main 클래스에서 다음과 같이 예제를 실행할 수 있다.
![img](.//images/sts/sts-example-execution.png)
![img](.//images/sts/sts-example-execution-success.png)
