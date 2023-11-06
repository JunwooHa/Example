<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<section>
	<fieldset class="find">
		<legend>ID 찾기</legend>
		
		<form action="${cpath }/account/findID" method="POST">
			<p><input name="email" type="email" placeholder="이메일" required></p>
			
			<button>전송</button>
		</form>
	</fieldset>
	
	<fieldset class="find">
		<legend>PW 찾기</legend>
		
		<form action="${cpath }/account/findPW" method="POST">
			<p><input name="userid" placeholder="ID" required></p>
			<p><input name="email" type="email" placeholder="이메일" required></p>
			
			<button>전송</button>
		</form>
	</fieldset>
</section>
</body>
</html>