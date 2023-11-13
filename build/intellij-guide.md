# Spring6-Recipes ItelliJ 설치 가이드

## 소스 받기

![img](.//images/spring-recipe-github.PNG)  
https://github.com/Apress/spring-6-recipes  
위 spring-6-recipe github 사이트로 이동하고 [https://github.com/Apress/spring-6-recipes.git] 이 주소를 활용해 소스를 받는다.

```
git clone https://github.com/Apress/spring-6-recipes.git
```

## 기본 환경설정

- JDK19 설치
- Gradle 설치(https://gradle.org/)

## IntelliJ 환경설정

### JDK 설정

Project Structure(프로젝트 클릭 후 F4) 화면에 들어간 뒤 Project Settings=>Proejct 메뉴에서 SDK를 JDK 19를 선택한다.  
![img](.//images///jdk_setting.PNG)  
바로 아래의 Modules => Dependencies에서도 Module SDK를 JDK 19로 설정한다.

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

IntelliJ 기동 후 https://github.com/LENATeam/spring-6-recipes.git로부터 받은 프로젝트를 연다.  
Gradle Run을 하게 되면 아래와 같은 오류를 볼 수 있다.

```
A problem occurred configuring project ':C:\davidyu\git\spring-6-recipes\ch01\recipe_1_10_i'.
> The project name '\davidyu\git\spring-6-recipes\ch01\recipe_1_10_i' must not contain any of the following characters: [/, \, :, <, >, ", ?, *, |]. Set the 'rootProject.name' or adjust the 'include' statement (see https://docs.gradle.org/7.6/dsl/org.gradle.api.initialization.Settings.html#org.gradle.api.initialization.Settings:include(java.lang.String[]) for more details).

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.

```

위 원인은 window 환경에서만 발생하며, 이를 수정하기 위해서는 settings.gradle을 수정한다.

settings.gradle(기존)

```
def getProjectName(String dir) {
    return (dir - (rootDir.toString() + "/")).replaceAll("/", ":")
}
```

settings.gradle(변경 후)

```
def getProjectName(String dir) {
     def projName = (dir - (rootDir.toString() + "/")).replaceAll('/', ':')
     if ( projName.equals(dir) ) {
        projName = (dir - (rootDir.toString() + "\\")).replaceAll('\\\\', ':')
     }
    return projName
}
```

#### gradle build

원하는 Chapter 목록 중 Tasks 하위의 build->build 버튼을 더블 클릭 한다.  
![img](.//images//gradle_build.PNG)  
그럼 console 창을 통해 build가 정상적으로 성공함을 알 수 있다.  
![img](.//images//gradle_build_success.PNG)
