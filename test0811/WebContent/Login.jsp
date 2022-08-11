<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
</head>
<body style="margin : 0 auto;">
	<form action="/test0811/login" method="post">
		<h1>로그인</h1>
		<span>id : </span>
		<input type="text" name="id">
		<span>password : </span>
		<input type="password" name="password">
		<button>
			로그인
		</button>
	</form>
	<button id="register">
		회원가입
	</button>
		
<script>
	const registerBtn = document.querySelector('#register')
	
	registerBtn.addEventListener('click', function() {
		location.href = '/test0811/register';
	})
</script>
</body>
</html>