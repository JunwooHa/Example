<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<article class="board">
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="row" items="${list }">		
			<tr>
				<td>${row.idx }</td>
				<td>
					<a href="${cpath }/board/view/${row.idx }">					
						${row.title }				
					</a>
				</td>
				<td>${row.writer }</td>
				<td>${row.write_date }</td>
				<td>${row.view_count }</td>
				<td>
					<a href="${cpath }/board/update/${row.idx }">
						클릭
					</a>
				</td>
				<td>
					<a href="${cpath }/board/delete/${row.idx }">
						클릭
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</article>
</body>
</html>