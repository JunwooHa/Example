<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article>
	<table class="boards">
		<tr>
			<td>${row.idx }</td>
		</tr>	
		<tr>			
			<td>
				${row.writer } |			
				${row.view_count } |			
				${row.write_date }
			</td>
		</tr>
		<tr>
			<td>
				<p><img src="${cpath }/img/${row.idx }/${row.img }" width="250px"></p>
				<pre>${row.contents }</pre>
			</td>
		</tr>
	</table>
	
	<br>
	
	
	<button onclick="isDelete(${row.idx },'${cpath}')">삭제</button>
	
	
	<a href="${cpath }/board/update/${row.idx }">
		<button>수정</button>
	</a>
</article>
<script>
	function isDelete(idx, cpath) {
		let del = confirm('삭제 하시겠습니까?');
		
		if (del) {
			location.href = cpath + '/board/delete/' + idx;
		}
	}
</script>
</body>
</html>