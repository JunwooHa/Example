package info;

/*
1. PUT의 경우)
- 특정 책번호(1025)의 price만 바꾸려고 PUT을 쓰면
- 나머지 데이터가 null이 채워지거나 에러 발생 
- 즉, 모든 데이터 변경시 PUT을 사용하는 것이 바람직

update book
	set
		title = ?,
		writer = ?,
		publisher = ?,
		p_date = ?,
		price = ?
	where idx = ?


2. Patch의 경우)
- 지정 부분만 변경하기 때문에 다른 속성은 영향을 받지 않음
- 즉, 부분적으로 변경시 Patch를 사용하는 것이 바람직

update book
	set
		price = ?
	where idx = ?

*/