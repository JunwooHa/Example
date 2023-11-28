<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	<h3 class="debug1"><marQuee>디버그 페이지 입니다 - 배포시 꼭! 제거</marQuee></h3>
<article class="board">
	<table class="boards">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>패스워드</th>
					<th>닉네임</th>
					<th>이메일</th>
					<th>가입날짜</th>							
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${list }">
					<tr>
						<td>${row.idx }</td>
						<td>${row.userid }</td>
						<td>${fn:substring(row.userpw, 0, 6) }</td>
						<td>${row.nick }</td>
						<td>${row.email }</td>
						<td>${row.join_date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</article>
</body>
</html>