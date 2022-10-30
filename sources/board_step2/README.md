# 게시판 만들기
Step.2: JSON 파일을 이용하여 Repository 구현 + Pagination

## JSON 파일을 이용하여 Repository 구현
- UserRepository
- PostRepository
- Ex) JSON 파일

`users.json`

```json
[
  {
    "id" : "admin",
    "password" : "12345",
    "name" : "Administrator",
    "profileFileName" : null
  }
]
```

- JSON 라이브러리: jackson 라이브러리 사용

## 게시물 Pagination 처리
- Pagination (Paging)
  - 전체 목록을 페이지 단위로 끊어서 보여주는 것
  - page: 현재 페이지 번호 (1부터 시작)
  - size: 한 페이지에 보여줄 게시물 갯수 (10개)
- 예시
  - 총 게시물 수: 13개 (1, 2, 3, ..., 13)
  - 총 페이지 수: 2페이지
    - 1페이지: (1, 2, 3, ..., 10)
    - 2페이지: (11, 12, 13)
- PostRepository에 Pagination을 위한 메소드 추가

```java
public interface PostRepository {
    // ...

    int getTotalCount();
    Page<Post> getPagedPosts(int page, int size);
}
```

```java
public interface Page<T> {
    int getPageNumber();            // 현재 페이지 번호
    int getPageSize();              // 한 페이지에 보여줄 게시물 갯수
    int getTotalPageCount();        // 총 페이지 수

    long getTotalCount();           // 총 게시물 수
    List<T> getList();              // 게시물 목록
}
```
- `spring-data` 같은 Pagination을 지원하는 다른 라이브러리 사용 금지
