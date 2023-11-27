<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<section>
	<h4>Board 테이블 - REST</h4>
	
	<table class="books">
        <thead>
            <tr>
                <th>No</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>조회수</th>
                <th>작성일</th>                
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
    <script>
        let btns = document.querySelectorAll('.btns > button');
        let boards = document.querySelectorAll('.books > tbody')[0];
        const url = 'quiz';
        var json;

        btns[0].onclick = () => {
            fetch(url, {method: 'get'})
            .then(response => response.json())
            .then(data => {
                json = data;
                let tr;

                boards.innerHTML = ''

                for (let i = 0; i < data.length; i++) {
                    tr = document.createElement('tr');

                    tr.innerHTML = 
                        '<td>' + data[i].idx + '</td>',
                        '<td>' + data[i].board_idx + '</td>',
                        '<td>' + data[i].writer + '</td>',
                        '<td>' + data[i].view_count + '</td>',
                        '<td>' + data[i].write_date + '</td>';

                    boards.appendChild(tr);                        
                }
            })
        }
    </script>	
</section>

</body>
</html>