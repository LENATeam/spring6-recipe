| 예제            | 설명                                                                     | 비고 |
| --------------- | ------------------------------------------------------------------------ |------|
| recipe_1_1_i    | 자바 구성 클래스로 POJO 인스턴스를 구성하는 예제 #1 | |
| recipe_1_1_ii   | 자바 구성 클래스로 POJO 인스턴스를 구성하는 예제 #2 | |
| recipe_1_2      | 스프링 IoC 컨테이너에서 생성자를 호출해 POJO 인스턴스를 생성하는 예제 | |
| recipe_1_3_i    | 자바 구성 클래스에 선언된 POJO를 참조하는 예제 | |
| recipe_1_3_ii   | @Autowired로 POJO 필드에 자동와이어링하는 예제 | |
| recipe_1_3_iii  | @Autowired로 POJO 필드(배열)에 자동와이어링하는 예제 | |
| recipe_1_3_iv   | @Autowired으로 생성자에 선택적 자동와이어링하는 예제 | |
| recipe_1_3_v    | @Primary로 자동와이어링 모호성 해결하는 예제 | |
| recipe_1_3_vi   | @Qualifier로 자동와이어링 모호성 해결하는 예제 | |
| recipe_1_3_vii  | 여러 자바 구성 클래스에 정의된 POJO 레퍼런스 문제 해결하는 예제 | |
| recipe_1_4_i    | @Resource로 POJO 자동와이어링하는 예제 | |
| recipe_1_4_ii   | @inject로 POJO 자동와이어링하는 예제 | |
| recipe_1_5_i    | @Scope설정이 없을 경우 싱글톤으로 생성된 인스턴스 예제 | |
| recipe_1_5_ii   | @Scope설정을 통한 싱글톤 인스턴스를 프로토타입으로 변경한 예제 | |
| recipe_1_6_i    | 프로퍼티를 사용해 POJO 초깃값 설정하는 예제 | |
| recipe_1_6_ii   | POJO에서 외부 리소스(message.properties)를 사용하는 예제 | |
| recipe_1_7      | 국제화를 지원하는 애플리케이션 예제 | |
| recipe_1_8_i    | @Bean에 initMethod와 destroyMethod 애트리뷰트를 사용해 POJO의 초기화와 종료 작업을 정의한 예제 | |
| recipe_1_8_ii   | @PostConstruct와 @PreDestroy를 사용해 POJO의 초기화와 종료 작업을 정의한 예제 | | 
| recipe_1_8_iii  | @Lazy로 POJO의 초기화를 지연한 예제 | |   
| recipe_1_8_iv   | @DependsOn으로 POJO의 초기화 우선순위를 정의한 예제 | |
| recipe_1_8_v    | POJO의 초기화 및 종료 작업이 정의되지 않은 쇼핑몰 애플리케이션 | |
| recipe_1_9_i    | postProcessBeforeInitialization(), postProcessAfterInitialization() 메서드로 빈 후처리기 생성 예제 | |
| recipe_1_9_ii   | 특정 빈 인스턴스에서만 동작하는 빈 후처리기 생성 예제 | |
| recipe_1_10_i   | 정적 팩토리 메서드를 호출해 POJO 생성 예제 | |
| recipe_1_10_ii  | 인스턴스 팩토리 메서드를 호출해 POJO 생성 예제 | |
| recipe_1_10_iii | 스프링 팩토리 빈을 사용해 POJO 생성 예제 | |
| recipe_1_11     | @Profile로 자바 구성 클래스를 프로파일별로 작성하는 예제 | |
| recipe_1_12     | POJO에 스프링 IoC 컨테이너 리소스를 알려주는 예제 | |
| recipe_1_13_i   | 애너테이션으로 관점 지향 프로그래밍 예제 (@before) | |
| recipe_1_13_ii  | 애너테이션으로 관점 지향 프로그래밍 예제 (@After) | |
| recipe_1_13_iii | 애너테이션으로 관점 지향 프로그래밍 예제 (@AfterReturning) | |
| recipe_1_13_iv  | 애너테이션으로 관점 지향 프로그래밍 예제 (@AfterThrowing) | |
| recipe_1_13_v   | 애너테이션으로 관점 지향 프로그래밍 예제 (@Around) | |
| recipe_1_14     | 조인포인트 정보에 접근하는 예제 | |
| recipe_1_15_i   | @Order로 애스펙트 우선순위 지정하는 예제 (getOrder()) | |
| recipe_1_15_ii  | @Order로 애스펙트 우선순위 지정하는 예제 (@Order) | |
| recipe_1_16_i   | @Pointcut 애너테이션을 사용해 여러 어드바이스에서 재사용하는 예제 | |
| recipe_1_16_ii  | @Pointcut 애너테이션을 사용해 여러 어드바이스에서 재사용하는 예제(별도 공통 영역에 모아 관리하는 방안) | |
| recipe_1_17_i   | AspectJ 포인트컷 표현식 작성하는 예제(커스텀 애너테이션 사용, 메서드 적용) | |
| recipe_1_17_ii  | AspectJ 포인트컷 표현식 작성하는 예제(커스텀 애너테이션 사용, 클래스 적용) | |
| recipe_1_17_iii | AspectJ 포인트컷 표현식을 조합하는 예제 | |
| recipe_1_17_iv  | AspectJ 포인트컷 매개변수 선언하는 예제 | |
| recipe_1_18     | POJO에 AOP 인트로덕션(Introduction) 적용하는 예제 | |
| recipe_1_19     | AOP로 POJO에 상태 정보 인트로듀스하는 예제 | |
| recipe_1_20_i   | AspectJ 애스펙트를 로드타임에 위빙하는 예제 | |
| recipe_1_20_ii  | AspectJ 애스펙트를 로드타임에 위빙하는 예제(AspectJ 위버 사용) | |
| recipe_1_20_iii | AspectJ 애스펙트를 로드타임에 위빙하는 예제(스프링 로드 타임 위버 사용) | |
| recipe_1_21     | 스프링에서 애스펙트 구성하는 예제 | |
| recipe_1_22     | AOP로 POJO를 도메인 객체로 주입하는 예제 | |
| recipe_1_23_i   | TaskExecutor를 활용한 동시성 구현 예제 | |
| recipe_1_23_ii  | TaskExecutor를 활용한 동시성 구현 예제 | |
| recipe_1_24_i   | ApplicationEvent를 활용한 이벤트 사용 예제 | |
| recipe_1_24_ii  | ApplicationEvent를 활용하지 않는 이벤트 사용 예제 | |
| recipe_1_25_i   | 함수형으로 등록된 빈 수정하기 #1 | |
| recipe_1_25_ii  | 함수형으로 등록된 빈 수정하기 #2 | |
| recipe_1_25_iii | A함수형으로 등록된 빈 수정하기 #3 | |
