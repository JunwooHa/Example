<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

	<h4>${ver }</h4>

	<ol>
		<li>MyBatis는 DB 접근을 지원하는 영속성 프레임워크</li>
		<li>조회, 추가, 변경, 삭제들을 다루는 클래스 및 설정의 집합을 의미</li>
	</ol>
	
	<table class="board">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>출판일</th>
			<th>가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.idx }</td>
				<td>${row.title }</td>
				<td>${row.writer }</td>
				<td>${row.publisher }</td>
				<td>${row.p_date }</td>
				<td>${row.price }</td>
				<td>
					<a href="${cpath }/book/update?idx=${row.idx }">
						클릭
					</a>
				</td>
				<td>
					<a href="${cpath }/book/delete?idx=${row.idx }">
						클릭
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>