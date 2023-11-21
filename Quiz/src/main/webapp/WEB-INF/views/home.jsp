<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<section class="board">
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>패스워드</th>
			<th>닉네임</th>
			<th>가입날짜</th>
		</tr>
		
		<c:forEach var="row" items="${list }">		
			<tr>
				<td>${row.idx }</td>
				<td>${row.userid}</td>
				<td>${fn:substring(row.userpw, 0, 6) }</td>
				<td>${row.nick }</td>
				<td>${row.j_date }</td>
			</tr>
		</c:forEach>
	</table>
</section>
</body>
</html>