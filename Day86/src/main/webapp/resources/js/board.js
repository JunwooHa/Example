function list(reqPage) {
    fetch(url + `?reqPage=${reqPage}`, {method: 'get'})
    .then(response => response.json())
    .then(data => {
        json = data;
        let tr;

        boards.innerHTML = ''

        for (let i = 0; i < data.length; i++) {
            tr = document.createElement('tr');

            tr.innerHTML = 
                '<td>' + data[i].idx + '</td>' +
                `<td data-idx="${data[i].idx}">` + data[i].title + '</td>' +
                '<td>' + data[i].writer + '</td>' +
                '<td>' + data[i].view_count + '</td>' +
                '<td>' + data[i].write_date + '</td>';

            boards.appendChild(tr);                        
        }
    })
}  

let btns = document.querySelectorAll('.btns > button');
let boards = document.querySelectorAll('.books > tbody')[0];
const url = 'board';
var json;

		// 0. 페이지 접근 시 바로 출력
		list(1);

        // 1. GET
        btns[0].onclick = () => list(2);    
        
        // 2.POST
        btns[1].onclick = () => {
            let data = {
                title : 'test',
                writer: 'katarina',
                content: '이걸 넣으라고?',
                view_count: 50,
                write_date:'2023-11-15'
            }
            
            fetch(url, {
                method : 'post',
                headers: {
                    'Content-type' : 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(response => response.json())
            .then(data => {
                if (data == 1) {
                    btns[0].click();
                }                    
            })
        }

        // 3. PUT
        btns[2].onclick = () => {
            let data = {
                idx: 2600,
                title : 'test2',
                writer: 'katarina',
                content: '이걸 넣으라고요?',
                view_count: 20,
                write_date:'2023-11-15'
            }
            
            fetch(url, {
                method : 'put',
                headers: {
                    'Content-type' : 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(response => response.json())
            .then(data => {
                if (data != 0) {
                    btns[0].click();
                }                    
            })
        }

        // 4. PATCH
        btns[3].onclick = () => {
            let data = {
                idx: 2600,
                content: 'PATCH'
            }
            
            fetch(url, {
                method : 'PATCH',
                headers: {
                    'Content-type' : 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(response => response.json())
            .then(data => {
                if (data != 0) {
                    btns[0].click();
                }                    
            })
        }

         // 5. DELETE
         btns[4].onclick = () => {
        	let board = {
        		idx: 2611
        	} 
            fetch(url, {
            	method : 'delete',
            	headers: {
                    'Content-type' : 'application/json'
                },
                body: JSON.stringify(board)
            })
            .then(response => response.json())
            .then(data => {
            	jsoin = data;
            	
                if (data != 0) {
                    btns[0].click();
                }                    
            })
        }
         
         // 참고
         let table = document.querySelectorAll('.books')[0];
         let pre = document.querySelectorAll('.view > pre')[0];

         table.onclick = () => {        	 
        	 let tar = event.target;

        	 if (tar.tagName == 'TD') {
        		 let idx = tar.getAttribute('data-idx');
                 idx = Number(idx);
        		 
        		 if (idx != 0) {
                    fetch(url + '/' + idx, {method: 'get'})
                    .then(response => response.json())
                    .then(data => {
                        pre.innerHTML = '게시글 내용 : ' + data.content;
                    });
                 }
        	 }        	 
         }
         
         // 페이징
         let page = document.querySelectorAll('.page')[0];        
         
         page.onclick = (event) => { 
        	 let tar = event.target;
        	 
        	 if (tar.tagName == 'LI') {        		 
        		 alert(tar.tagName + ' : ' + tar.innerHTML);
        	 }
         }