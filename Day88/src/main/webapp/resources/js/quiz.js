// 페이지 접근시 and GET 호출시 사용할 함수
function list(reqPage) { 
	
	fetch(url + `?reqPage=${reqPage}`, { method: 'GET' })
	.then(response => response.json())
	.then(data => {
		dt = data;
		
		let list = data.list;
		let p = data.p;
	
		let result = document.querySelectorAll('.books > tbody')[0];
		result.innerHTML = '';
		
		// 게시글
		for (let i = 0; i < p.perCount; i++) {
			let tr = document.createElement('tr');
			
			tr.innerHTML = 
				'<td>' + list[i].idx + '</td>' + 
				`<td data-idx="${list[i].idx}">` + list[i].title + '</td>' + 
				'<td>' + list[i].writer + '</td>' + 
				'<td>' + list[i].view_count + '</td>' + 
				'<td>' + list[i].write_date + '</td>'; 
				
			result.appendChild(tr);
		}
		
		// 페이지 번호
		let page = document.querySelectorAll('.page')[0];
		page.innerHTML = '';
		
		if (p.prev) 
			page.appendChild(getLi('이전', p.begin - 1));
		
		for (let i = p.begin; i <= p.end; i++) 
			page.appendChild(getLi(i, i));
		
		if (p.next)
			page.appendChild(getLi('다음', p.end + 1));
	});
}

function getLi(data, page) {
	let li = document.createElement('li');
	li.innerHTML = data;
	li.setAttribute('data-i', page);
	
	return li;
}


let btns = document.querySelectorAll('.btns > button');
let url = 'board';
var dt;

// 0. 페이지 접근시 바로 출력
list(1);

// 1. GET 버튼
btns[0].onclick = () => list(1);

// 2. POST 버튼
btns[1].onclick = () => { 
	let board = {
		title: "REST 테스트",
		contents: "내용 추가",
		writer: "아이티뱅크"
	};
	
	fetch(url, { 
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(board)
	})
	.then(response => response.json())
	.then(data => {
		dt = data;
		
		if (data == 1) {
			btns[0].click();
		}
	});
}

// 3. PUT 버튼
btns[2].onclick = () => { 
	let board = {
		idx: 2629,
		title: "REST 수정 테스트",
		contents: "내용 수정",
		writer: "유저1"
	};
	
	fetch(url, { 
		method: 'PUT',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(board)
	})
	.then(response => response.json())
	.then(data => {
		dt = data;
		
		if (data == 1) {
			btns[0].click();
		}
	});
}

// 4. PATCH 버튼
btns[3].onclick = () => { 
	let board = {
		idx: 2630,
		title: "REST PATCH 테스트",
	};
	
	fetch(url, { 
		method: 'PATCH',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(board)
	})
	.then(response => response.json())
	.then(data => {
		dt = data;
		
		if (data == 1) {
			btns[0].click();
		}
	});
}

// 5. DELETE 버튼
btns[4].onclick = () => { 
	let board = {
		idx: 2650
	};
	
	fetch(url, { 
		method: 'DELETE',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(board)
	})
	.then(response => response.json())
	.then(data => {
		dt = data;
		
		if (data == 1) {
			btns[0].click();
		}
	});
}

// 게시글 클릭시 글 내용 가져오기
let table = document.querySelectorAll('.books')[0];
let pre = document.querySelectorAll('.view > pre')[0];

table.onclick = (event) => { 
	let tar = event.target;
	
	if (tar.tagName == 'TD') {
		let idx = tar.getAttribute('data-idx');
		idx = Number(idx);
		
		if (idx != 0) {
			fetch(url + '/' + idx, { method: 'GET' })
			.then(response => response.json())
			.then(data => {
				pre.innerHTML = '게시글 내용 : ' + data.contents;
			});
		}
	}
}

// 페이징
let page = document.querySelectorAll('.page')[0];
var test;

page.onclick = (event) => { 
	let tar = event.target;
	// test = tar;
	
	if (tar.tagName == 'LI') {
		// alert(tar.tagName + ' : ' + tar.getAttribute('data-i'));
		
		list(tar.getAttribute('data-i'));
	}
}


	
	