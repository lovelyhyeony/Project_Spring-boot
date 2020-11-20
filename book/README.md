# spring-boot-thymeleaf view

- HTML, CSS, JS가 적용된 static web HTML파일에 Controller로부터 전달되어 온 데이터를 기본 모양을 흐트러트리지 않는 범위에서 자유롭게 표현하는 view
- JSP와 비교했을 때 JSP는 서버를 거쳐서 Rendering이 되지 않으면 어떻게 화면이 구성되는지 알기가 어렵다.
- 표준 web browser에서 open을 했을 때는 마치 static HTML처럼 보여지고  
서버에서 데이터가 전달되면 실제 데이터를 포함하여 rendering한 후 보여지기 때문에,  
개발자와 디자이너가 협업하기에 매우 좋은 view이다.

# data-jpa 프로젝트

- spring-jpa 프로젝트에서 spring.datasource.initialize-mode를 always로 설정한 후,  
src/main/resources 폴더에 data.sql 파일을 생성한 후 insert SQL을 저장해 두면
프로젝트가 재 시작될 때 data.sql 파일의 SQL문을 읽어서 데이터를 자동으로 추가한다.  
샘플데이터가 필요할 때 사용하면 좋다.  
또한, src/main/resources 폴더에 schema.sql 파일을 생성한 후 DDL SQL을 저장해 두면
프로젝트가 재시작될 때 DDL SQL문을 실행 할 수 있다.