| 프로젝트        | 설명                                                                                                           | 비고                                                                     |
| --------------- | -------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| recipe_7_1_i    | 트랜잭션 관리가 없어서 사용자 계정에 잔액이 부족으로 구매 전체가 롤백된 코드                                                               |                                                                      |
| recipe_7_1_ii | 자동 커밋 옵션을 끄고 원시 트랜잭션 관리 전략을 사용 | |
| recipe_7_3_i | PlatformTransactionManager를 사용해 서점 JDBC 구현 및 ReactiveTransactionManager를 사용해 서점 R2DBC 구현 | Reactive 부분 에러 발생 |
| recipe_7_4_i | TransactionTemplate을 이용한 서점 JDBC 구현(PlatformTransactionManager 주입) 및 TransactionalOperator를 이용한 반응형 서점 구현 | Reactive 부분 에러 발생 | 
| recipe_7_4_ii | TransactionTemplate을 주입한 서점 JDBC 구현 및 TransactionalOperator를 주입한 반응형 서점 구현 | Reactive 부분 에러 발생 | 
| recipe_7_5_i | @Transactional 애너테이션을 적용한 JDBC 서점 구현 및 @Transactional 애너테이션을 적용한 반응형 서점 구현 | eactive 부분 에러 발생 | 
| recipe_7_6_i | REQUIRED 전파 동작 테스트 코드  | | 
| recipe_7_6_ii | REQUIRES_NEW 전파 동작 테스트 코드 | Propagation 애트리뷰트가 purchase 메서드에 적용해야하는데 checkout 에 적용되어 있어서 수정 | 
| recipe_7_6_iii | REQUIRES_NEW Propagation 애트리뷰트를 purchase와 checkout에 모두 적용한 예제 | 필요한 코드인지 잘 모르겠어서 뺐습니다. 애트리뷰트를 purchase 메서드에 적용하고 checkout에는 의미가 없어보이는데 7_6_ii는 checkout에 적용되어 있고 7_6_iii는 모두 적용되어 있습니다. | 
| recipe_7_7_i | READ_UNCOMMITTED 격리 수준 테스트 코드 | 정상 동작 안함 (https://www.postgresql.org/docs/current/sql-set-transaction.html) Postgres 에서 Read_uncommitted 는 read_committed 와 같이 동작함 Postgres 에서 dirty read를 지원하지 않는다고 합니다. 이 테스트를 위해서 postgres가 아닌 다른 db를 테스트할 수 있는 환경을 만들어야 할까요..? | 
| recipe_7_7_ii | READ_COMMITTED 격리 수준 테스트 코드 | 정상 동작 안함, 테스트 해 본 결과 commit 될 때 까지 select를 못하는게 아니라 update를 못하는 동작인데 책의 설명을 수정해야 될까요? |
| recipe_7_7_iii | READ_COMMITTED 격리 수준 테스트 코드 | 책에 설명이 없는 코드로 7_7_ii 처럼 READ_COMMITTED 테스트 코드인데 스레드 실행 순서만 바꼈는데 첫번째로 실행한 스레드에서 커밋을 안했기 때문에 의미 없는 코드 같아서 뺐습니다.|
| recipe_7_7_iv | REPEATABLE_READ 격리 수준 테스트 코드  | | 
| recipe_7_7_v | SERIALIZABLE 격리 수준 테스트 코드 | 책에 설명은 없지만 필요해보여서 올려두었습니다. |
| recipe_7_8_i | 롤백 트랜잭션 애트리뷰트 적용 코드 | |
| recipe_7_9_i | 시간초과, 읽기전용 트랜잭션 애트리뷰트 적용 코드 | |
| recipe_7_10_i | 로드 타임 위빙 적용 코드 | ./gradlew ch07:recipe_7_10_i:uberJar 를 실행해서 jar를 생성하고 spring-instrument-6.0.3.RELEASE.jar 받아서 실행해야 하는데 책에 설명이 없습니다. spring-instrument-7.0.3.RELEASE.jar파일을 resource 에 추가하고 경로를 resource 하위로 지정해주는 것이 좋을까요? |


