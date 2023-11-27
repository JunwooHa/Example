<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<article>
	<table class="board">
		<tr>
			<th colspan="6">${row.idx }.${row.title } (${row.cnt })</th>
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
	
	<h4>댓글 갯수 : ${reCount }</h4>
	
<form class="reply" method="POST">
	<section>
		<input name="board_idx" type="hidden" value="${row.idx }" required>
		<input name="writer" type="hidden" value="katarina" required>
	
		<textarea name="contents" placeholder="바른 말을 사용합시다"></textarea>
		<button>작성</button>
	</section>
</form>
<c:forEach var="rp" items="${rps }">

<pre>
${rp.writer } <a href="${cpath }/board/Replydelete/${rp.idx}">(x)</a>
${rp.contents }
${rp.write_date }
</pre><hr>
	
</c:forEach>
	
</article>

</body>
</html>