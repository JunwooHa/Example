<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
	
<section class="board">

	<p>총 게시글 ${p.totalBoard }개</p>

	<table>
		<tr>
			<th>No</th>
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
			<td><a href="${cpath }/board/view?idx=${row.idx }">
				${row.title }
			</a></td>
			<td>${row.writer }</td>
			<td>${row.view_count }</td>
			<td>${row.write_date }</td>
			<td><a href="${cpath }/board/update/${row.idx }">
				클릭
			</a></td>
			<td><a href="${cpath }/board/delete/${row.idx }">
				클릭
			</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<ul class="menu page">
		<c:if test="${p.prev }">
		<li><a href="${cpath }/${p.begin - 1 }">이전</a></li>
		</c:if>
	
		<c:forEach var="i" begin="${p.begin }" end="${p.end }">
		<li><a href="${cpath }/${i }">${i }</a></li>		
		</c:forEach>
		
		<c:if test="${p.next }">
		<li><a href="${cpath }/${p.end + 1 }">다음</a></li>
		</c:if>
	</ul>
</section>

</body>
</html>