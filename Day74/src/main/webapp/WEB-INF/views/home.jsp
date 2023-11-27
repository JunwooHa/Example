<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<section class="all">
	<h4>총 게시글 수 : ${p.totalBoard }</h4>
	
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
						${row.title } (${row.cnt })
					</a>
				</td>
				<td>${row.writer }</td>
				<td>${row.view_count }</td>
				<td>${row.write_date }</td>
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
		
	<ul class="page">
	<c:set var="isSearch" value="type=${ex.type }&search=${ex.search }&order=${ex.order }"/>
		<c:if test="${p.prev }">		
			<li><a href="${cpath}/${p.begin - 1}">이전</a></li>
		</c:if>
		<c:forEach var="i" begin="${p.begin }" end="${p.end }">
			<li><a href="${cpath }/${i }">${i }</a></li>
		</c:forEach>
		<c:if test="${p.next }">		
			<li><a href="${cpath }/${p.end + 1}">다음</a></li>
		</c:if>
	</ul>		
	
	<div>
		<form>
			<select name="type">
				<option value="title">제목</option>
				<option value="writer">작성자</option>
				<option value="content">내용</option>				
			</select>
			
			<input name="search">
			
			<button>검색</button>
		</form>
	</div>
</section>
</body>
</html>