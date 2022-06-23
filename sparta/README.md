# sparta 웹 개발의 봄
  
## 기본  
  
week1-------------------------------------------------------------------------  
1. 웹의 기본적인 구조를 이해하고, 5주 동안 만들 프로젝트를 살펴본다.  
2. 스프링 부트의 기본 구조를 이해한다.  
3. Java 기초를 학습한다.  
  
week1_homework   
1. 새로운 스프링 프로젝트를 만든다. (New Project ...)  
2. Person 클래스를 만든다.  
3. 3개 이상의 멤버 변수를 만든다. (name, age, address, job ...)   
4. 멤버 변수는 모두 private 이다.  
5. Getter, Setter를 만든다.  
6. PersonConroller를 만들고, http://localhost:8080/myinfo 에 나의 정보가 뜨도록 한다.  
7. Person.java, PersonController.java 를 제출한다.  
  
week2-------------------------------------------------------------------------  
1. RDBMS의 기초 지식을 습득한다.  
2. Spring Data JPA의 사용법을 습득한다.  
3. REST API를 만드는 방법을 익힌다.  

week2_homework  
1주차 숙제로 작성한 Person 클래스를 CRUD할 수 있는 [PersonController.java](http://personcontroller.java) 파일을 만들고, 다음 API를 완성하세요.  
1. [https://localhost:8080/api/persons](https://localhost:8080/api/persons) POST : 친구 생성  
2. [https://localhost:8080/api/persons](https://localhost:8080/api/persons) GET : 친구 목록 조회  
3. [https://localhost:8080/api/persons](https://localhost:8080/api/persons)/{id} PUT : 친구 정보 변경  
4. [https://localhost:8080/api/persons](https://localhost:8080/api/persons)/{id} DELETE : 친구 정보 삭제  
  
week3-------------------------------------------------------------------------  
1. 페이지를 만들기 위한 HTML,CSS, Javascript를 익힌다.  
2. 스프링을 이용해 API를 만들고 기능 확인하는 법을 손에 익힌다.  
3. 타임라인 서비스를 완성한다.  
  
week3_homework  
타임라인 서비스가 불러오는 메모 목록의 시간을, 조회 시간으로부터 24시간 이내로 바꿔보세요.  
힌트1) spring jpa localtime between 라고 구글링해보세요.  
힌트2) 지금은 LocalDateTime.now(), 하루 전은 LocalDateTime.now().minusDays(1) 입니다.  

week4-------------------------------------------------------------------------  
1. Controller - Service - Repository 에 대해 자신감을 가진다!  
2. 자바를 이용해  API를 이용하는 방법을 익힌다.  
3. 스프링 스케줄러를 이용하여, 서버에게 원하는 작업을 원하는 시간에 시키는 방법을 익힌다.  
  
week4_homework  
최저가를 변경하는 API를 완성해보세요.  
힌트)  
basic.js > setMyprice 완성  
ProductRestController.java > @PutMapping, ProductMypriceRequestDto 활용하기  

week5-------------------------------------------------------------------------  
1. AWS RDS 와 로컬 서비스를 연결해본다.
2. OG 태그를 이용하여 카톡방에 공유할 준비를 한다.
3. AWS EC2 를 세팅하고, 나만의 셀렉샵을 배포한다.
4. 나만의 셀렉샵에 도메인을 붙이고 친구들에게 카톡으로 자랑한다.
  
## 심화
  
week1-------------------------------------------------------------------------  
  
1. 스프링의 핵심개념인 DI 와 스프링 IoC 컨테이너의 핵심개념을 이해한다.  
2. 스프링의 Controller, Service, Repository 의 필요성을 이해한다.  
    
week2-------------------------------------------------------------------------  
  
1. 웹의 인증 및 인가의 개념을 이해한다.  
2. 스프링 시큐리티를 이용해 폼 로그인 기능을 구현한다.  
3. 스프링 시큐리티 OAuth2 를 이용해 소셜 로그인 기능을 구현한다.  
  
week3-------------------------------------------------------------------------  
  
1. 테스트의 필요성  
2. 스프링 테스트 프레임워크 이해 및 사용 학습  
  
week4-------------------------------------------------------------------------  
  
스프링에서 DB 를 다룰 때 사용되는 JPA 에 대해 이해하고, 실제 프로젝트에 적용  
1. Spring Data JPA 이해  
2. 영속성 컨텐스트 이해  
3. 페이징 및 정렬 이해  
4. JPA 의 연관 관계 이해  
  
week5-------------------------------------------------------------------------  
  
1. AOP 개념 이해 및 사용방법 파악  
  - '나만의 셀렉샵'의 Top5 회원 찾기  
  - 중복 폴더명 저장 시 에러 처리  
2. DB 트랙잭션 이해  
3. 스프링 예외 처리방법 이해  
  
