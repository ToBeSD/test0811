<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
</head>
<body>
	<form action="/test0811/register" method="post">
		<h1>회원가입</h1>
		<span>id : </span>
		<input type="text" name="id">
		<span>password : </span>
		<input type="password" name="password">
		<span>name : </span>
		<input type="text" name="name">
		<button id="complete">
			작성완료
		</button>
	</form>	
	
<script>
	const conpleteBtn = document.querySelector('#complete')
	
	conpleteBtn.addEventListener('click', function() {
		alert('가입되었습니다. 로그인 해주세요.');
	})
</script>
</body>
</html>