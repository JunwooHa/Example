<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<section class="login">
	<form method="POST">
		<p><input name="userid" placeholder="ID" required></p>
		<p><input name="userpw" type="password" placeholder="PW" required></p>

		<p>
			<button>로그인</button>
			<a href="${cpath }/account/find "><button type="button">ID/PW 찾기</button></a>		
		</p>		
	</form>
	
	
</section>

</body>
</html>