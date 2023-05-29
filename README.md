<h1>자바웹개발워크북 4장 스프링 </h1>
<br>
<p> CRUD + 페이징 처리 + 검색 필터</p>
<br>
<br>


<h1>📆 개발일정</h1>
<br>
2023.05 ~ 2023.05<br><br>
<br>


<h1>⚡ 핵심기능</h1> <br>
<li> 등록 <br> <br>
&nbsp;&nbsp; : TodoMaper에 void insert(TodoVO todoVO) -> xml에 insert 문 -> 테스트코드 (DB드가나) 
서비스 계층 설계 (TodoMapper와 TodoController) : TodoService에 void register(TodoDTO todoDTO) -> Impl에 TodoDTO를 TodoVO로 변환 + TodoMapper이용해서 insert -> TodoService테스트 TodoDTO build -> TodoController 에 GetMapping -> register.jsp에 form 태그 만들고 input name에 VO값 넣어주기 -> Controller에 POST방식 처리 (TodoDTO파라미터, redirect) 
<br><br></li><br> <br>

<img width="700" alt="Pasted Graphic 3" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/0f49dd86-b1c8-436f-9c9c-cf52002bf9a3">
<br> <br>

<li> 조회 <br> <br>
&nbsp;&nbsp; :  /todo/read?tno=xx
TodoMapper에 selectOne() 파라미터로 tno받고, TodoVO객체 반환 TodoVO selectOne(Long tno) -> xml에 select문 -> 테스트 코드 
서비스 계층 설계 : TodoService에 TodoDTO getOne(Long tno) -> Impl에 TodoVO를 TodoDTO로 변환 -> TodoController에 GET방식 read() 개발 model.addAttribute -> read.jsp에 dto이름으로 TodoDTO 출력 
 <br><br></li><br> <br>

<img width="700" alt="Pasted Graphic 4" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/62b59546-f3b4-4292-94e1-092a98a61fcc">
<br> <br>
 
<li> 삭제 <br> <br>
&nbsp;&nbsp; /todo/modify?tno=xx
TodoController (read)에 /modify넣기 -> 수정 페이지 만들기 modify.jsp(read.jsp 복사) form 태그 만들기 input 태그로 <c:out> 넣기 -> remove 버튼 처리 자바스크립트 remove formObj.action = “/todo/remove”, formObj.method = “post” -> TodoMapper에 void delete(Long tno) -> xml에 delete문 
서비스 계층 설계 : TodoService에 void(Long tno) -> Impl에 @Override 컨트롤러에 파라미터 없으니 받는거x ->  TodoController에 POST방식 remove()개발 
<br><br></li><br> <br>
  
<img width="700" alt="Pasted Graphic 5" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/10f907bc-a980-49a2-a9bf-cdde1f21bfae">
<br> <br>
<img width="700" alt="Pasted Graphic 6" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/6f29beee-bcdb-4250-a5af-87f31396095e">
<br> <br>
 

<li> 수정 <br> <br>
&nbsp;&nbsp; : TodoMapper에 void update(TodoVO todoVO) 만들기 -> xml에 update문 set넣기 
서비스계층 : TodoService에 void modify(TodoDTO todoDTO) -> Impl에 TodoDTO를 TodoVO로 변환 -> checkbox를 위한 CheckboxFormatterController생성 (text가 null이 아니면 text.equals(“on”) -> TodoController에 Post방식 modify -> modify.jsp에 Modify버튼 이벤트 처리 
<br><br></li><br> <br>

<img width="700" alt="Pasted Graphic 7" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/c6749c02-54cc-48a7-ada9-30bb711263ae">
<br> <br>
<img width="700" alt="Pasted Graphic 8" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/54b9c014-cace-4e3f-abab-0b4d460d4ddc">
<br> <br>
<img width="700" alt="Special title treatment" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/73f46ef9-d134-4898-ae81-535c0f8aaa31">
<br> <br>

  
<li> 페이징 <br> <br>
&nbsp;&nbsp; : 페이지처리를 위한 DTO PageRequestDTO생성 page,size의 기본값 @Builder.Default -> TodoMapper 인터페이스에 List<TodoVO> selectList(PageRequestDTO pageRequestDTO) 생성 -> xml 생성 -> TodoMapper테스트 -> TodoMapper의 count처리 -> 목록 데이터를 위한 DTO 서비스 계층(PageresponseDTO) 생성
서비스 계층 : TodoService에 PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) 생성 -> Impl에 PageRequestDTO를 PageResponseDTO로 바꾸는 작업 필요 -> TodoController list에 model.addAttribute로 넣기 -> JSP 
 <br><br></li><br> <br>

<img width="700" alt="Pasted Graphic 11" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/80cb6936-56b4-456a-9524-7904faf7b647">
<br> <br>
  

<li> 검색 & 필터 <br> <br>
&nbsp;&nbsp; : PageRequestDTO에 변수추가 (제목(t), 작성자(w),finished, from, to) -> TodoMapperTest에 테스트 return타입은 List<TodoVO> -> TodoMapper에 구문 생성 (1. types가 ’t’또는 ‘w’인 경우 2. null인경우 3. finsihed(완료여부) = 1 (trim)이용 4. from != null and to != null) -> 화면 구성 -> PageRequest DTO에 조회를 위한 링크 처리(bulider.append로 검색 조건 유지) -> 조회, 수정 화면에서 링크 처리 -> modify 버튼 처리 (수정 후 조회 페이지로 이동하게)
 <br><br></li><br> <br>

<img width="700" alt="image" src="https://github.com/Btcantony/WebStudy-SpringFramework-04/assets/94521647/2ea75635-4db7-44ea-83e5-d4da9b806354">

    
<br><p>본 내용은 자바 웹 개발 워크북을 공부하며, 개발하였습니다. </p>
