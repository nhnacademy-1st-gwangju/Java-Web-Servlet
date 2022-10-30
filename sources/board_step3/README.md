# 게시판 만들기
Step.3: Spring Framework를 이용하여 bean으로 구현

## 요구사항
- `spring-context` 라이브러리만 사용
  - spring-context 라이브러리만 의존 라이브러리에 추가해도
  - 의존성 전이를 통해 spring-core, spring-beans 등의 라이브러리도 사용 가능해짐
  - 그 이상의 Spring framework 관련 라이브러리는 명시적으로 `pom.xml`에 추가해서 사용하지 말라는 뜻
- Java Config (`@Configuration`) 으로 bean 등록
  - stereo type bean은 `@Component` 만 사용 가능
- `ServletContainerInitializer` interface 를 구현한 클래스의 `onStartup()` 메서드에서
- `ApplicationContext.getBean()`를 통해 Spring bean 을 찾아서
- `ServletContext.setAttribute()` 를 통해 ServletContext에 등록할 수 있음
  - Servlet이나 Controller에서 사용 가능

## 주의할 점
- Spring bean으로 등록하려면 클래스에 멤버 변수가 없어야 한다
  - 왜냐하면 Spring bean은 Singleton 객체이기 때문에 상태 공유 X
  - 그럼 UserRepository나 PostRepository는?
    - 메모리 기반 Repository의 경우
      - synchronized collection (`Collections.synchronizedList()` 등) 나
      - concurrent collection (`ConcurrentHashMap` 등) 사용
  - 파일 기반 Repository의 경우
    - ObjectMapper는 thread safe
    - file operation은 file에 대한 synchronized 처리 필요
      - 단, 이번 과제에서는 이 부분을 고려하지 않아도 무방함
