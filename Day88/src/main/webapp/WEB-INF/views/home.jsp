<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
	<h4>자원을 이름으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것을 의미</h4>
	
	<table>
		<tr>
			<th>GET</th>
			<td>지정 자원을 요청 후 얻기 위한 메서드</td>
		</tr>
		<tr>
			<th>POST</th>
			<td>전달한 자원을 서버에 등록 요청을 위한 메서드</td>
		</tr>
		<tr>
			<th>PUT</th>
			<td>전달한 자원으로 모든 데이터 변경 요청을 위한 메서드</td>
		</tr>
		<tr>
			<th>PATCH</th>
			<td>전달한 자원으로 일부 데이터 변경 요청을 위한 메서드</td>
		</tr>
		<tr>
			<th>DELETE</th>
			<td>전달한 자원을 서버에서 제거 요청을 위한 메서드</td>
		</tr>
	</table>
	
	
	<h4>REST 구성 요소</h4>
	
	<ol>
		<li>자원 : URL, 모든 자원은 고유한 ID를 가지고 있고 이를 통해서 데이터를 구분</li>
		<li>행위 : Method, HTTP 요청 메서드를 통해서 클라이언트가 요구하는 행위를 구별</li>
		<li>표현 : 서버가 클라이언트에게 응합하는 자원의 상태. JSON, XML 등의 형태로 응답</li>
	</ol>
	
	<p>ex) https://localhost:8080/Day85/book 으로 GET 요청시</p>
	
	<p>GET(행위) /book(자원)</p>
	<p>반환값 : JSON(표현)</p>

</body>
</html>