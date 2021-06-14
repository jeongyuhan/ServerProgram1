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
			const delete_btn = $('#delete_btn');
			delete_btn.click(function(){
				if(confirm('탈퇴하시겠습니까?')) {
					location.href = '/ServerProgram1/deleteMember.do';
				}
			})
			
		const update_btn = $('#update_btn');
		const name = $('#name');
		const point = $('#point');
		const f = $('#f');
		update_btn.click(function(){
			if(name.val() == '${loginDTO.name}' && point.val() == '${loginDTO.point}'){
				alert('변경할 정보가 없습니다.');
				return;
			}
			f.attr('action', '/ServerProgram1/updateMember.do');
			f.submit();
			
		})
		})
	</script>	
</head>
<body>
	
	<h1>회원 관리 시스템</h1>
	<a href="/ServerProgram1/logout.do">로그아웃</a>
	<hr>
	<div class="info_box">
		<form action="" id="f" method="post">	
			<table class="info">
				<tr>
					<td>아이디</td>
					<td>이름</td>
					<td>등급</td>
					<td>포인트</td>
				</tr>
				<tr>
					<td>${loginDTO.id}</td>
					<td><input type="text" id="name" name="name" value="${loginDTO.name}"></td>
					<td>${loginDTO.grade}</td>
					<td><input type="text" id="point" name="point" value="${loginDTO.point}"> </td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" id="update_btn" value="수정하기"></td>
					<td colspan="2"><input type="button" id="delete_btn" value="탈퇴하기"></td>
				</tr>
			</table>
		</form>	
	</div>
	
</body>
</html>