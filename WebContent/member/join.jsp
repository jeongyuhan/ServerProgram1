<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			const f = $('#f');
			const id = $('#id');
			const name = $('#name');
			const back_btn = $('#back_btn');
			
			f.submit(function(event){
				if(id.val() == ''){
					alert('가입 정보를 모두 입력하세요.');
					id.focus();
					event.preventDefault();		
					return false;
				}
				else if(name.val() == ''){
					alert('가입 정보를 모두 입력하세요.');
					name.focus();
					event.preventDefault();
					return false;
				}
			})
			
			back_btn.click(function(){
				history.back();
			})
			
		})
	</script>
</head>
<body>
	<h1>회원 가입 폼</h1>
	<div class="join_box">
		<form action="/ServerProgram1/join.do" id="f" method="post">
			<label for="id">아이디</label>
			<input type="text" id="id" name="id"><br>
			<label for="name">이름</label>
			<input type="text" id="name" name="name"><br>
			<button>회원가입</button>
			<input type="button" id="back_btn" value="돌아가기">
		</form>
	</div>
	
</body>
</html>