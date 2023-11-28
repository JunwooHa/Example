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
<link href="${cpath }/resources/css/style.css" rel="stylesheet">
</head>
<body>
<c:set var="login" value="${empty user ? 'login' : 'logout'}"/>
<c:set var="signUp" value="${empty user ? 'signUp' : user.nick}"/>
	<h1>${cpath } - Account </h1>
	
	<nav class="menu">	
		<ul>
			<li><a href="${cpath }">home</a></li>
			<li><a href="#">자유 게시판</a></li>
		</ul>
		
		<ul>
			<li class="debug"><a href="${cpath }/account/list">debug</a></li>
			<li><a href="#">${signUp }</a></li>
			<li><a href="${cpath }/account/${login }">${login }</a></li>
		</ul>
	</nav>
	
	<hr>
	
	<main>