<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${cpath }</title>
<link rel="stylesheet" href="${cpath }/resources/css/style.css">
</head>
<body>
	<h1>${cpath } - Transaction</h1>
	
	<nav class="menu">	
		<ul>
			<li><a href="${cpath }">home</a></li>
			<li><a href="${cpath }/board/write">write</a></li>
		</ul>
		
		<ul>
			<c:if test="${not empty user }">
				<li><a href="${cpath }/account/myPage">${user.nick }</a></li>
				<li><a href="${cpath }/account/logout">logout</a></li>
			</c:if>
			<c:if test="${empty user }">			
				<li><a href="${cpath }/account/signUp">signUp</a></li>
				<li><a href="${cpath }/account/login">login</a></li>
			</c:if>
		</ul>
		
	</nav>
	
	<hr>