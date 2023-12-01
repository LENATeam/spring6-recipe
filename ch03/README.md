| 프로젝트        | 설명                                                                                                           | 비고                                                                     |
| --------------- | -------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------ |
| recipe_3_1_i    | MarshallingView로 XML 발행 예제                                                               | 실행방법<br>  ./gradlew ch03:recipe_3_1_i:build<br>./gradlew ch03:recipe_3_1_i:docker<br>./gradlew ch03:recipe_3_1_i:dockerRun<br>curl http://127.0.0.1/court/members                        |
| recipe_3_1_ii | 	@ResponseBody를 이용해 XML 발행 예제 | 실행방법<br>  ./gradlew ch03:recipe_3_1_ii:build<br>./gradlew ch03:recipe_3_1_ii:docker<br>./gradlew ch03:recipe_3_1_ii:dockerRun<br>curl http://127.0.0.1/court/members |
| recipe_3_1_ii | @RestController를 이용해 XML 발행 예제 | 실행방법<br>  ./gradlew ch03:recipe_3_1_iii:build<br>./gradlew ch03:recipe_3_1_iii:docker<br>./gradlew ch03:recipe_3_1_iii:dockerRun<br>curl http://127.0.0.1/court/members |
| recipe_3_1_iv | @PathVariable 이용 예제 | 실행방법<br>  ./gradlew ch03:recipe_3_1_iv:build<br>./gradlew ch03:recipe_3_1_iv:docker<br>./gradlew ch03:recipe_3_1_iv:dockerRun<br>curl http://127.0.0.1/court/members/2 |