let btns = document.querySelectorAll('.btns > button');
let books = document.querySelectorAll('.books > tbody')[0];
const url = 'book';
var json;

// 1. GET 버튼
btns[0].onclick = () => { 
	fetch(url, { method: 'get' })
	.then(response => response.json())
	.then(data => {
		json = data;
		let tr;

		books.innerHTML = '';
		
		for (let i = 0; i < data.length; i++) {
			// 1. 자식 노드(li)를 생성
			tr = document.createElement('tr');

			// 2. 자식 노드의 요소에 데이터 추가
			tr.innerHTML = 
				'<td>' + data[i].idx + '</td>' + 
				'<td>' + data[i].title + '</td>' + 
				'<td>' + data[i].writer + '</td>' + 
				'<td>' + data[i].publisher + '</td>' + 
				'<td>' + data[i].p_date + '</td>' + 
				'<td>' + data[i].price + '</td>';

			// 3. 자식을 부모 노드에 추가
			books.appendChild(tr);
		}
	});
}

// 2. POST 버튼
btns[1].onclick = () => {
	let data = {
		title: 'ajax 테스트',
		writer: 'JStest',
		publisher: 'HTML',
		p_date: '2023-11-14',
		price: 12000
	};

	fetch(url, { 
		method: 'post',
		headers: {
			'Content-Type': 'application/json' 
		},
		body: JSON.stringify(data)
	})
	.then(response => response.json())
	.then(data => {
		if (data != 0) {
			btns[0].click();
		}
	});
}

// 3. PUT 버튼
btns[2].onclick = () => {
	let data = {
		idx: 1037,
		title: 'ajax 수정',
		writer: 'JStest',
		publisher: 'CSS',
		p_date: '2023-10-05',
		price: 12500
	};

	fetch(url, { 
		method: 'put',
		headers: {
			'Content-Type': 'application/json' 
		},
		body: JSON.stringify(data)
	})
	.then(response => response.json())
	.then(data => {
		if (data != 0) {
			btns[0].click();
		}
	});
}

// 4. PATCH 버튼
btns[3].onclick = () => {
	let data = {
		idx: 1027,
		price: 12500
	};

	fetch(url, { 
		method: 'PATCH',
		headers: {
			'Content-Type': 'application/json' 
		},
		body: JSON.stringify(data)
	})
	.then(response => response.json())
	.then(data => {
		if (data != 0) {
			btns[0].click();
		}
	});
}

// 5. DELETE 버튼
btns[4].onclick = () => {

	fetch(url + '/1018', { method: 'delete' })
	.then(response => response.json())
	.then(data => {
		if (data != 0) {
			btns[0].click();
		}
	});
}