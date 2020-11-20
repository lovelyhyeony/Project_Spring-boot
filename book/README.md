# spring-boot-thymeleaf view

- HTML, CSS, JS가 적용된 static web HTML파일에 Controller로부터 전달되어 온 데이터를 기본 모양을 흐트러트리지 않는 범위에서 자유롭게 표현하는 view
- JSP와 비교했을 때 JSP는 서버를 거쳐서 Rendering이 되지 않으면 어떻게 화면이 구성되는지 알기가 어렵다.
- 표준 web browser에서 open을 했을 때는 마치 static HTML처럼 보여지고  
서버에서 데이터가 전달되면 실제 데이터를 포함하여 rendering한 후 보여지기 때문에,  
개발자와 디자이너가 협업하기에 매우 좋은 view이다