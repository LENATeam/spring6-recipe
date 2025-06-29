# 13장 guide

테스트 실행시 아래와 같은 경로에서 실행한다. 

1. JUnit은 자바의 단위 테스트 프레임워크으로 기대하는 결과와 실제 결과가 같은지 자동으로 검증을 목표로 실습합니다. (@Test 메서드를 찾아 실행)

    1. Run Java 실행시 에러가 발생 환경에 맞게 아래의 명령어를 실행 

        1. gradle : ./gradlew test

        2. maven : mvn test

2. 아래와 같이 환경 별 설정을 확인 

    1. 제공되는 소스 path : spring6-recipe\ch13\build.gradle


    ```
    project('recipe_13_1_i') {
        test {
            useJUnitPlatform()
            testLogging {
                events "passed", "skipped", "failed"
            }
        }

        dependencies {
            testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter'
        }
    }

    ```

    2. maven의 경우 path : pom.xml


    ```
    <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
    </dependency>
    ```


3. spring6-recipe 경로 (gradlew  또는 gradlew.bat을 있는 경로)로 이동

4. 아래와 같이 실행

    1. window : ./gradlew.bat  :ch13:recipe_13_1_i:test 

    2. mac/linux : ./gradlew  :ch13:recipe_13_1_i:test 

    3. 각 최상위 root에서 ch13 경로 recipe_13_1_i 을 test 실행   (`gradlew.bat  :ch13:recipe_13_1_i:test --info` 실행시 상세 보기) 

5. 실행 결과 

    ```
    .\gradlew.bat :ch13:recipe_13_1_i:test       

    BUILD SUCCESSFUL in 2s
    6 actionable tasks: 6 up-to-date
    ```

    또는 

    ```
     .\gradlew.bat :ch13:recipe_13_1_iii:test      

    > Task :ch13:recipe_13_1_iii:test

    Gradle suite > Gradle test > com.apress.spring6recipes.bank.SimpleInterestCalculatorTests > calculate PASSED

    Gradle suite > Gradle test > com.apress.spring6recipes.bank.SimpleInterestCalculatorTests > illegalCalculate PASSED

    BUILD SUCCESSFUL in 2s
    ```

