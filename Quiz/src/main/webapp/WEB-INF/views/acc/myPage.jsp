<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<section class="board">
	<form action="${cpath }/acc/update" method="POST">
		<table>
			<tr>
				<th>번호</th>
				<td>${user.idx }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${user.userid }</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input name="userpw" type="password" required></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${user.nick }</td>
			</tr>
			<tr>
				<th>가입날짜</th>
				<td>${user.j_date }</td>
			</tr>
		</table>
		
		<p>
			<button>수정</button>
			
			<a href="${cpath }/acc/delete/${user.idx }">
				<button type="button">삭제</button>
			</a>
		</p>
	</form>
</section>
</body>
</html>