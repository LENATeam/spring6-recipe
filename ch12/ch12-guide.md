# 12장 guide

ActiveMQ을 사용

1. 다운로드 : [https://activemq.apache.org/components/classic/download/classic-05-15-12](https://activemq.apache.org/components/classic/download/classic-05-15-12)
2. apache-activemq-5.15.12-bin.zip 압축 해제
3. cmd 경로/bin/ 으로 이동
4. activemq.bat start 로 실행
    
    ```markdown
    실행 로그 중 
     INFO | Listening for connections at: tcp://User:61616?maximumConnections=1000&wireFormat.maxFrameSize=104857600
     INFO | Connector openwire started
     INFO | Listening for connections at: amqp://User:5672?maximumConnections=1000&wireFormat.maxFrameSize=104857600
     INFO | Connector amqp started
     INFO | Listening for connections at: stomp://User:61613?maximumConnections=1000&wireFormat.maxFrameSize=104857600
     INFO | Connector stomp started
     INFO | Listening for connections at: mqtt://User:1883?maximumConnections=1000&wireFormat.maxFrameSize=104857600
     INFO | Connector mqtt started
     INFO | Starting Jetty server
     INFO | Creating Jetty connector
     WARN | ServletContext@o.e.j.s.ServletContextHandler@6a2eea2a{/,null,STARTING} has uncovered http methods for path: /
     INFO | Listening for connections at ws://YoungK:61614?maximumConnections=1000&wireFormat.maxFrameSize=104857600
     INFO | Connector ws started
     INFO | Apache ActiveMQ 5.15.12 (localhost, ID:User-64052-1709113357051-0:1) started
     INFO | For help or more information please see: http://activemq.apache.org
     INFO | ActiveMQ WebConsole available at http://0.0.0.0:8161/
     INFO | ActiveMQ Jolokia REST API available at http://0.0.0.0:8161/api/jolokia/
    ```
    
5. 관리 UI 접속
    1. [http://localhost:8161](http://localhost:8161/)[http://localhost:8161/admin](http://localhost:8161/admin)
    id: admin pw: admin
6. 기타
    1. **Frame size of 1 GB larger than max allowed 100 MB** 
        1. activemq.bat 에서 if "%ACTIVEMQ_OPTS%" == "" set ACTIVEMQ_OPTS=-Xms1G -Xmx1G  항목 수정
        2. /conf/activemq.xml 에서  <transportConnector name="openwire" uri="tcp://0.0.0.0:61616?maximumConnections=1000&wireFormat.maxFrameSize=**104857600**"/> 항목 수정
7. CSV
    1. ${user.home}/inboundFiles/new 경로와 ${user.home}/customerstoremove/new 경로에 csv 파일 이동