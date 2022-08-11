<%@page import="java.util.*"%>
<%@page import="dao.*"%>
<%@page import="dto.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	MemberDao memberDao = new MemberDao();
	
	ArrayList<MemberDto> memberList = memberDao.findAllMember(conn, pstmt, rs);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	span {
		display: inline-block;
		width: 100px;
	}
</style>
<script src="jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>회원관리</h1>
    <div>
	    <span>ID</span>
	    <span>PASSWORD</span>
	    <span>NAME</span>
	    <span>POINT</span>
	    <span>수정</span>
	    <span>삭제</span>
	    <button class="loginBtn">로그인</button>
    </div>
    
    <%
    	for(int i = 0; i < memberList.size(); i++) {
    %>
		    <div>
			    <span><%=memberList.get(i).getId() %></span>
			    <span><%=memberList.get(i).getPassword() %></span>
			    <span><%=memberList.get(i).getName() %></span>
			    <span><%=memberList.get(i).getPoint() %></span>
			    <button class="revise">수정</button>
			    <button class="delete">삭제</button>
		    </div>
		    
    <%
    	}
    %>
    
   	<div>
   		<button id="start">스케줄러(20초마다 포인트 1증가)실행 시작</button>
   		<button id="end">스케줄러실행 종료</button>
   	</div>
<script>
	$('.loginBtn').on('click', function() {
		location.href = '/test0811/login';
	})

	$('.delete').on('click', function(e) {
		let id = $(e.target).siblings('span').eq(0).html()
		
		$.ajax({
		    type: "POST",
		    url: '/test0811/admin',
		    data: {
		      id : id
		    },
		    success: function (data) {
		    	$(e.target).parent().remove();
		    	alert('삭제되었습니다.');
		    },
		})
	})
	
	$('.revise').on('click', function(e) {
		let id = $(e.target).siblings('span').eq(0).html()
		let password = $(e.target).siblings('span').eq(1).html()
		let name = $(e.target).siblings('span').eq(2).html()
		let point = $(e.target).siblings('span').eq(3).html()
		
		location.href = `/test0811/memberRevise?id=\${id}&password=\${password}&name=\${name}&point=\${point}`;
	})
	
	$('#start').on('click', function () {
		$.ajax({
		    type: "get",
		    url: '/test0811/SchedulerStart',

		    success: function (data) {

		    },
		})
	})

	$('#end').on('click', function () {
		$.ajax({
		    type: "get",
		    url: '/test0811/SchedulerEnd',
	
		    success: function (data) {

		    },
		})
	})
</script>   

</body>
</html>