<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<ul>
  <li>번호 : ${acc.idx }</li>
  <li>ID : ${acc.userid }</li>
  <li>PW : ${fn:substring(acc.userpw, 0,10) }</li>
  <li>닉네임 : ${acc.nick }</li>
  <li>이메일 : ${acc.email }</li>
  <li>가입일 : ${acc.join_date }</li>  
</ul>


</body>
</html>