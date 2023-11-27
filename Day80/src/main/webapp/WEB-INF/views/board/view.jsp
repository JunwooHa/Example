<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<section class="board">
	<table>
		<tr>
			<th colspan="6">${row.idx }.${row.title }</th>
		</tr>
	
		<tr>
			<th>작성자</th>
			<td>${row.writer }</td>
			<th>조회수</th>
			<td>${row.view_count }</td>
			<th>작성일</th>
			<td>${row.write_date }</td>
		</tr>
		<tr>
			<td colspan="6"><pre>${row.content }</pre></td>
		</tr>
	</table>		
	
	<article class="reply">
		<c:forEach var="rp" items="${rps }">	
			<p>
			${rp.writer } (x)<br>
			${rp.contents }<br>
			${rp.write_date }<br>
			</p><hr>
		</c:forEach>	
	</article>
	
	
</section>
</body>
</html>