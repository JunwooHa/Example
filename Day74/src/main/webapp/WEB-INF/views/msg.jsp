<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
	<script>
		let row = ${row };
		let msg = '${message}';
		
		if (row != 0) {
			alert(msg + ' 성공');
			location.href = '${cpath}';
		}
		else {
			alert(msg);
			history.back();
		}
	</script>
	
</body>
</html>