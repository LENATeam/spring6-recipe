| 예제            | 설명                                                                     | 비고 |
| --------------- | ------------------------------------------------------------------------ |------|
| recipe_7_1_i    | 트랜잭션 관리가 없어서 사용자 계정에 잔액이 부족으로 구매 전체가 롤백된 예제 | |
| recipe_7_1_ii   | 자동 커밋 옵션을 끄고 원시 트랜잭션 관리 전략을 사용 | |
| recipe_7_3_i    | PlatformTransactionManager를 사용해 서점 JDBC 구현<BR/>ReactiveTransactionManager를 사용해 서점 R2DBC 구현 | Reactive 부분 에러 발생 |
| recipe_7_4_i    | TransactionTemplate을 이용한 서점 JDBC 구현(PlatformTransactionManager 주입)<BR/>TransactionalOperator를 이용한 반응형 서점 구현 | Reactive 부분 에러 발생 | 
| recipe_7_4_ii   | TransactionTemplate을 주입한 서점 JDBC 구현<BR/>TransactionalOperator를 주입한 반응형 서점 구현 | Reactive 부분 에러 발생 |
| recipe_7_5_i    | @Transactional 애너테이션을 적용한 JDBC 서점 구현<BR/>@Transactional 애너테이션을 적용한 반응형 서점 구현 | Reactive 부분 에러 발생 |
| recipe_7_6_i    | REQUIRED 전파 동작 테스트 예제 | | 
| recipe_7_6_ii   | REQUIRES_NEW 전파 동작 테스트 예제 | | 
| recipe_7_7_i    | READ_UNCOMMITTED 격리 수준 테스트 예제 | DBMS에 따라 작동방식 다름<BR/>(postgres의 경우 read_committed 와 동일하게 동작함) | 
| recipe_7_7_ii   | READ_COMMITTED 격리 수준 테스트 예제 | DBMS에 따라 작동방식 다름<BR/>(postgres의 경우 기다리지 않고 이전 커밋 값을 읽음) |
| recipe_7_7_iv   | REPEATABLE_READ 격리 수준 테스트 예제  | | 
| recipe_7_7_v    | SERIALIZABLE 격리 수준 테스트 예제 | |
| recipe_7_8_i    | 롤백 트랜잭션 애트리뷰트 적용 예제 | |
| recipe_7_9_i    | 시간초과, 읽기전용 트랜잭션 애트리뷰트 적용 예제 | |
| recipe_7_10_i   | 로드 타임 위빙 적용 코드 | spring-instrument-6.0.3.RELEASE.jar 를 이용해 실행 필요 |
