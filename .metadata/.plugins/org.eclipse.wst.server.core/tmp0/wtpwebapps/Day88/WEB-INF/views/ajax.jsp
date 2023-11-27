<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<section>
	<h4><marquee>fetch를 활용한 RESTFul API 요청</marquee></h4>
	
	<ul>
		<li>fetch는 다양한 HTTP 요청 메서드를 사용 가능하며</li>
		<li>기본적으로 비동기 통신으로 사용된다</li>
	</ul>

	<table class="books">
		<thead>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>출판일</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<!-- 여기 데이터가 채워짐 -->
		</tbody>
	</table>
	
	<p class="btns">
		<button>GET</button>
		<button>POST</button>
		<button>PUT</button>
		<button>PATCH</button>
		<button>DELETE</button>
	</p>

</section>

<script src="${cpath }/resources/js/ajax.js"></script>

</body>
</html>