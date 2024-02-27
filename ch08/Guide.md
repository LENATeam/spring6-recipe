# 8장 guide

해당 8장에서는 batch에 실습시 사용하는 DB을 spring embedded H2 DB 와 Apache Derby DB을 사용합니다. 

실습에 도움이 되는 Derby DB 구성에 대한 간단한 가이드를 작성합니다. 

1. Derby
    1. 다운로드
        1. 경로 : [https://db.apache.org/derby/derby_downloads](https://db.apache.org/derby/derby_downloads)
        2. 해당 list 중 **For Java 17 and Higher (releases which no longer support the Java SecurityManager)** 다운로드
    2. 압축 해제 : db-derby-10.16.1.1-bin.zip 
    3. 해당 경로로 CMD 으로 이동 
        
        ```markdown
        db-derby-10.16.1.1-bin> dir
        
            디렉터리: D:\util\spring\db-derby-10.16.1.1-bin
        
        Mode                 LastWriteTime         Length Name
        ----                 -------------         ------ ----
        d-----      2024-02-25   오후 9:12                bin
        d-----      2022-05-18   오후 1:44                demo
        d-----      2022-05-18   오후 1:44                docs
        d-----      2022-05-18   오후 1:44                javadoc
        d-----      2022-05-18   오후 1:44                lib
        d-----      2022-05-18   오후 1:44                test
        -a----      2022-05-17  오전 10:19           5026 index.html
        -a----      2022-05-18   오후 1:44          47124 KEYS
        -a----      2022-05-18   오후 1:44          11560 LICENSE
        -a----      2022-05-18   오후 1:44          12966 NOTICE
        -a----      2022-05-18   오후 1:44          15481 RELEASE-NOTES.html
        
        db-derby-10.16.1.1-bin\bin> dir
        
            디렉터리: D:\util\spring\db-derby-10.16.1.1-bin\bin
        
        Mode                 LastWriteTime         Length Name
        ----                 -------------         ------ ----
        d-----      2024-02-27  오후 11:07                batch
        -a----      2022-05-18   오후 1:42           5801 dblook
        -a----      2022-05-17  오전 10:19           1387 dblook.bat
        -a----      2024-02-27  오후 11:06              0 derby.log
        -a----      2022-05-17  오전 10:19           2499 derby_common.bat
        -a----      2022-05-18   오후 1:42           5937 ij
        -a----      2022-05-17  오전 10:19           1379 ij.bat
        -a----      2022-05-18   오후 1:42           5862 NetworkServerControl
        -a----      2022-05-17  오전 10:19           1413 NetworkServerControl.bat
        -a----      2022-05-17  오전 10:19           1305 setEmbeddedCP
        -a----      2022-05-17  오전 10:19           1503 setEmbeddedCP.bat
        -a----      2022-05-17  오전 10:19           1222 setNetworkClientCP
        -a----      2024-02-25   오후 8:20           1602 setNetworkClientCP.bat
        -a----      2022-05-17  오전 10:19           1366 setNetworkServerCP
        -a----      2024-02-25   오후 8:40           1650 setNetworkServerCP.bat
        -a----      2022-05-18   오후 1:42           5868 startNetworkServer
        -a----      2022-05-17  오전 10:19           1397 startNetworkServer.bat
        -a----      2022-05-18   오후 1:42           5871 stopNetworkServer
        -a----      2022-05-17  오전 10:19           1403 stopNetworkServer.bat
        -a----      2022-05-18   오후 1:42           5850 sysinfo
        -a----      2022-05-17  오전 10:19           1389 sysinfo.bat
        ```
        
    4. sysinfo.bat : 관련 정보 조회
    5. setNetworkServerCP.bat 을 편집 아래와 같은 내용을 수정합니다. 
        1. @rem set DERBY_INSTALL= 에 경로 입력 
        2. @set DERBY_INSTALL=D:\util\spring\db-derby-10.16.1.1-bin
        3. @rem 은 주석 처리 되기 떄문에 rem을 제거
    6. 수정 한 setNetworkServerCP.bat 을 실행 
        
        ```markdown
        db-derby-10.16.1.1-bin\bin>startNetworkServer.bat
        Tue Feb 27 23:06:56 GMT+09:00 2024 : Apache Derby 네트워크 서버 - 10.16.1.1 - (1901046)이(가) 시작되어 1527 포트 에서 접속을 승인할 준비가 되었습니다.
        ```
        
    7. 중지
        1. stopNetworkServer.bat 실행
    8. ij.bat 실행
        1. client 같은 것으로 기동 중이 derby에 접속이 가능합니다. 
        2. 새로운 cmd을 실행 한 뒤 기동 중인 1527 포트로 접속
            1. connect 'jdbc:derby://localhost:1527/batch;create=true;user=app;password=app';
            
            ```markdown
            db-derby-10.16.1.1-bin\bin> .\ij.bat
            ij 버전 10.16
            ij> connect 'jdbc:derby://localhost:1527/batch;create=true;user=app;password=app';
            ij> show tables;
            TABLE_SCHEM         |TABLE_NAME                    |REMARKS
            ------------------------------------------------------------------------
            SYS                 |SYSALIASES                    |
            ```
            
        3. 다른 명령어는 help; 을 실행하여 확인이 가능합니다. 
        4. 저장된 데이터 확인도 가능(select * form 테이블명 ; )
2. 실습시 CSV 파일을 필요로 함 
    1. 경로 
        1. UserJob.java에서 경로를 확인 
        2. **@Value("file:${user.home}/batches/registrations.csv")** 선언된 동일하게 파일명을 위치 
        3. window 기준 :  C:\Users\사용자명\batches\registrations.csv
        4. 또는 @Value의 경로를 변경해서 실습을 진행 
    2. 파일  아래와 같은 형식으로 작성 (메모장 및 확장명 csv로 저장)
        
        ```markdown
        first11,last11,company11,address11,city11,state11,zip11,county11,url11,phone11,fax11
        first12,last12,company12,address12,city12,state12,zip12,county12,url12,phone12,fax12
        first13,last13,company13,address13,city13,state13,zip13,county13,url13,phone13,fax13
        ```
        
3. schema 참고 
    1. [spring-batch-schema-list](https://github.com/spring-projects/spring-batch/blob/main/spring-batch-core/src/main/resources/org/springframework/batch/core)