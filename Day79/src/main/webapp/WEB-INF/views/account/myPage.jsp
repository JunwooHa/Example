<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<form method="POST">
	<article class="board">
		<table class="boards">
			<tr>
				<th>회원번호</th>
				<td>${user.idx }</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${user.userid }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="userpw" type="password" required></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td>${user.nick }</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" type="email" value="${user.email }" required></td>
			</tr>
			<tr>
				<th>가입날짜</th>
				<td>${user.join_date }</td>
			</tr>
		</table>
		
		<p>
			<button>회원수정</button>
			<button onclick="isDelete(${user.idx}, '${cpath }')">회원탈퇴</button>
		</p>
	</article>
</form>
<script>
	function isDelete(idx, cpath) {
		let del = confirm(idx + '번을 삭제 하시겠습니까?');
		
		if (del) {
			location.href = cpath + '/account/delete/' + idx;
		}
	}
</script>
</body>
</html>