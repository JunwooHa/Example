<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<section class="board">
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${list }">
				<tr>
					<td>${row.idx }</td>
					<td><a href="${cpath }/board/view/${row.idx }">
							${row.title } </a></td>
					<td>${row.writer }</td>
					<td>${row.view_count }</td>
					<td>${row.write_date }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<ul class="page">
		<c:if test="${p.prev }">		
			<li><a href="${cpath }/${p.begin - 1}">이전</a></li>
		</c:if>
		<c:forEach var="i" begin="${p.begin }" end="${p.end }">		
			<li><a href="${cpath }/${i }">${i }</a></li>
		</c:forEach>
		<c:if test="${p.next }">		
			<li><a href="${cpath }/${p.end + 1}">다음</a></li>
		</c:if>
	</ul>
	
	<br>
	
	<a class="test" href="${cpath }/txTest">
		<button>tx 테스트</button>
	</a>
</section>
</body>
</html>