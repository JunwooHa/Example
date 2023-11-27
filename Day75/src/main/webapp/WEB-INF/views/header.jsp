<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${cpath }</title>
<style>
a {
	color: inherit;
	text-decoration: none;
}
.menu {
	display: flex;
	list-style: none;
	padding: 0;
}
.menu li {
	margin: 0 10px;
}
.boards {
	border-collapse: collapse;
}
.boards th, .boards td {
	border: 1px solid black;
	padding: 5px 10px;
}
</style>
</head>
<body>
	<h1>Test 실습</h1>
	
	<ul class="menu">
		<li><a href="${cpath }">home</a></li>
		<li><a href="${cpath }/book/list">book</a></li>
		<li><a href="${cpath }/book/add">add</a></li>
	</ul>
	
	<hr>