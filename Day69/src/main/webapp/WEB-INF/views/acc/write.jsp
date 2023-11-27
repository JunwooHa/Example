<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
	
	<h4>계정 생성~~</h4>
	
	<form method="POST">
		<p><input name="userid" placeholder="ID" required value="${acc.userid }"></p>
		<p><input name="userpw" type="password" placeholder="PW" required></p>
		<p><input name="nick" placeholder="닉네임" required value="${acc.nick }"></p>
		<p><input name="email" type="email" placeholder="이메일" required value="${acc.email }"></p>
		
		<button>전송</button>
	</form>
	
</body>
</html>