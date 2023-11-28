<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<article class="board">
		<form method="POST">
			<table class="boards">
				<tr>
					<th>제목</th>
					<td><input name="title" value="${row.title }"required></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input name="writer" value="${row.writer }" required></td>
				</tr>
				<tr>
					<td colspan="2"><textarea name="content" required>${row.content }</textarea></td>
				</tr>
			</table>
	
			<br>
	
			<button>작성</button>
		</form>
	</article>
</body>
</html>