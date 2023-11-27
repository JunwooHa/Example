<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${cpath }</title>
<link rel="stylesheet" href="${cpath }/resources/css/style.css">
</head>
<body>
	<h1>Quiz</h1>
	
	<ul class="menu">
		<li><a href="${cpath }">home</a></li>
		
		<c:if test="${empty user }">
			<li><a href="${cpath }/acc/signUp">signUp</a></li>
			<li><a href="${cpath }/acc/login">login</a></li>
		</c:if>
		
		<c:if test="${not empty user }">
			<li><a href="${cpath }/acc/myPage">${user.nick }</a></li>
			<li><a href="${cpath }/acc/logout">logout</a></li>
		</c:if>
	</ul>
	
	<hr>