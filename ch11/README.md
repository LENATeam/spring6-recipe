| 프로젝트        | 설명                                                                                                           | 비고                                                                     |
| --------------- | -------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| recipe_11_1_i_BackOffice <br> recipe_11_1_i_FrontDesk | 스프링 JMS 템플릿 없이 메시지 송수신 예제  | bin/artemis.sh 실행 필요  |
| recipe_11_1_ii_BackOffice <br> recipe_11_1_ii_FrontDesk | 스프링 JMS 템플릿으로 메시지 송수신 예제 | bin/artemis.sh 실행 필요 |
| recipe_11_1_iii_BackOffice <br> recipe_11_1_iii_FrontDesk | 디폴트 대상에서 메시지 송수신 예제 | i, ii는 mail 객체가 record 여서 toString이 지원되는데 iii, iv에서는 mail 이 class 여서 출력구문일 바꿔줘야 의미가 있을 것 같아서 수정했습니다. <br> 기존코드 : System.out.printf("Recevied: %s%n", mail); <br> 수정코드 : System.out.printf("Recevied: Mail[mailId=%s, country=%s, weight=%.2f]%n", mail.getMailId(), mail.getCountry(), mail.getWeight()); <br> 아니면 이 코드의 Mail을 record 롤 바꿀까요? |
| recipe_11_1_iv_BackOffice <br> recipe_11_1_iv_FrontDesk | JmsGatewaySupport 클래스 상속받아 JMS 템플릿으로 메시지 송수신 예제 | i, ii는 mail 객체가 record 여서 toString이 지원되는데 iii, iv에서는 mail 이 class 여서 출력구문일 바꿔줘야 의미가 있을 것 같아서 수정했습니다. <br> 기존코드 : System.out.printf("Recevied: %s%n", mail); <br> 수정코드 : System.out.printf("Recevied: Mail[mailId=%s, country=%s, weight=%.2f]%n", mail.getMailId(), mail.getCountry(), mail.getWeight()); |
| recipe_11_2_i_BackOffice <br> recipe_11_2_i_FrontDesk | SimpleMessageConverter 이용 메시지 변환 예제 | |
| recipe_11_2_ii_BackOffice <br> recipe_11_2_ii_FrontDesk | 사용자 정의 메시지 컨버터 이용 메시지 변환 예제 | |
| recipe_11_3_BackOffice <br> recipe_11_3_FrontDesk | JMS 트랜잭션 관리 예제 | |
| recipe_11_4_i_BackOffice <br> recipe_11_4_i_FrontDesk | 메시지 리스너로 JMS 메시지 수신 예제 | |
| recipe_11_4_ii_BackOffice <br> recipe_11_4_ii_FrontDesk | @JmsListener 적용 예제 | BackOfficeConfiguration.java 에 불필요한 import문 제거 <br> 제거구문 : import org.springframework.jms.connection.CachingConnectionFactory; |
| recipe_11_4_iii_BackOffice <br> recipe_11_4_iii_FrontDesk | 메시지 리스너 팩토리에 메시지 컨버터 지정 예제 | |
| recipe_11_4_iv_BackOffice <br> recipe_11_4_iv_FrontDesk | 메시지 리스너에 JMS 트랜잭션 적용 예제 | FrontDesk에 예전 버전 소스로 남아있는 것 같아서 전체적으로 수정했습니다. |
| recipe_11_5_BackOffice <br> recipe_11_5_FrontDesk | JMS 커넥션 캐싱 및 풀링 예제 | BackOfficeConfiguration.java indentation 수정 |
| recipe_11_6_i_BackOffice <br> recipe_11_6_i_FrontDesk | RabbitMQ 메시지 송수신 예제 | bin/rabbitmq.sh 실행해서 RabbitMQ 기동 후 실행 <br> bin/docker-compose-rabbitmq.yml 수정 : "services:" 빠져있어서 추가함 |
| recipe_11_6_ii_BackOffice <br> recipe_11_6_ii_FrontDesk | RabbitTemplate으로 RabbitMQ 메시지 송수신 예제 | |
