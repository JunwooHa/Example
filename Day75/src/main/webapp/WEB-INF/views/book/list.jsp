<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article class="board">
	<table class="boards">
		<tr>
			<th>번호</th>
			<th>책 제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>출판일</th>
			<th>가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		
		<c:forEach var="row" items="${list }">
			<tr>
				<td>${row.idx }</td>
				<td>
					<a href="${cpath }/book/view?idx=${row.idx }">
						${row.title }					
					</a>				
				</td>
				<td>${row.writer }</td>
				<td>${row.publisher }</td>
				<td>${row.p_date }</td>
				<td>${row.price }</td>
				<td>
					<a href="${cpath }/book/update/${row.idx }">
						클릭
					</a>
				</td>
				<td onclick="onDelete(${row.idx }, '${cpath }')">클릭</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	
	<form method="POST">
		<select name="type">
			<option value="title">제목</option>
			<option value="writer">저자</option>
			<option value="publisher">출판사</option>			
		</select>
		
		<input name="search" value="${param.search }">
		
		<button>검색</button>
	</form>
	
</article>
<script>
	function onDelete(idx, cpath) {
		let del = confirm("삭제 하시겠습니까?");			
		
		if (del) {			
			location.href = cpath + '/book/delete/' + idx;
		}
	}
</script>
</body>
</html>