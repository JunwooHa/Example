<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	<script>
		var row = ${row };
		var msg = '${message }';
		var cpath = '${cpath }/';
		var loc = '${location }';
		
		if (row != 0) {
			alert(msg);
			location.href = cpath + loc;
		}
	</script>
</body>
</html>