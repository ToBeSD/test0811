<%@page import="dao.DBConnection"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	int point = Integer.parseInt(request.getParameter("point"));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1>회원관리-수정관리자</h1>
	<form action="/test0811/memberRevise" method="post">
		<div>
			id <input type="text" name="id" value="<%=id %>" readonly>
		</div>
		<div>
			password <input type="text" name="password" value="<%=password %> ">
		</div>
		<div>
			name <input type="text" name="name" value="<%=name %> ">
		</div>
		<div>
			point <input type="text" name="point" value="<%=point %>">
		</div>
		<div>
			<button id=submit>제출</button>
		</div>
	</form>
	
<script>
	const submitBtn = document.querySelector('#submit')
	
	submitBtn.addEventListener('click', function() {
		alert('수정되었습니다.')
	})
</script>
</body>
</html>