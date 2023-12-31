<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<article class="all">
	<ul class="order">
		<li><a href="${cpath }?order=idx">최신순</a></li>
		<li><a href="${cpath }?order=view_count">조회순</a></li>			
	</ul>
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
	<ul class="page">
	<c:set var="isSearch" value="type=${type }&search=${search }"/>
		<c:if test="${p.prev }">		
			<li><a href="${cpath}?page=${p.begin - 1}&${isSearch }">이전</a></li>
		</c:if>
		<c:forEach var="i" begin="${p.begin }" end="${p.end }">
			<li><a href="${cpath }?page=${i }&${isSearch }">${i }</a></li>
		</c:forEach>
		<c:if test="${p.next }">		
			<li><a href="${cpath }?page=${p.end + 1}&${isSearch }">다음</a></li>
		</c:if>
	</ul>
	
	<p class="add">
		<a href="${cpath }/board/write">
			<button>추가</button>
		</a>
	</p>
	
	<div>
		<form method="POST">
			<select name="type">
				<option value="title">제목</option>
				<option value="writer">작성자</option>
				<option value="content">내용</option>				
			</select>
			
			<input name="search">
			
			<button>검색</button>
		</form>
	</div>
</article>
</body>
</html>