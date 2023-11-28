<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<article class="all">
	<table class="board">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.idx }</td>
				<td>
					<a href="${cpath }/board/view?idx=${row.idx }">				
						${row.title }
					</a>
				</td>
				<td>${row.writer }</td>
				<td>${row.view_count }</td>
				<td>${row.write_date }</td>
				<td>
					<a href="${cpath }/board/update?idx=${row.idx }">				
						클릭			
					</a>
				</td>
				<td>
					<a href="${cpath }/board/delete?idx=${row.idx }">				
						클릭			
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>	
		<p class="add">
			<a href="${cpath }/board/write">
				<button>추가</button>
			</a>
		</p>
</article>
</body>
</html>