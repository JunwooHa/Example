<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Log Test</h1>	
	<hr>
	
	<h4>로그 사용 이유</h4>
	
	<ul>
		<li>코드의 결함을 가장 잘 찾는 방식은 디버깅이다</li>
		<li>하지만, 배포 후엔 디버깅을 하기가 힘들다</li>
		<li>기존의 System.out보다 성능이 좋고</li>
		<li>다양한 레벨이 있어 중요도에 따라서 별도로 로그를 관리 가능</li>
		<li>다양한 형태로 (콘솔 및 파일 등) 모니터링이 가능하다</li>
	</ul>
	
	<h4>로그 레벨</h4>
	
	<table border="1" cellspacing="0" cellpadding="10">
		<tr>
			<th>Fatal</th>
			<td>매우 심각. 프로그램이 종료될 수준의 에러</td>
		</tr>
		<tr>
			<th>Error</th>
			<td>심각. 의도치 않은 상황이 발생. 항상 종료되는 에러는 아님</td>
		</tr>
		<tr>
			<th>Warn</th>
			<td>경고. 에러가 될 잠재성이 있는 경우</td>
		</tr>
		<tr>
			<th>Info</th>
			<td>정보. 간단한 요구사항 확인시</td>
		</tr>
		<tr>
			<th>Debug</th>
			<td>디버깅. info보도 더 자세한 요구사항 확인시</td>
		</tr>
		<tr>
			<th>Trace</th>
			<td>추적. debug보다 더 자세한 요구사항 확인시</td>
		</tr>
	</table>
	
	<br>
	
	<a href="ex01">Logging Framework</a>
</body>
</html>