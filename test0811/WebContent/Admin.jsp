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
    <h1>ȸ������</h1>
    <div>
	    <span>ID</span>
	    <span>PASSWORD</span>
	    <span>NAME</span>
	    <span>POINT</span>
	    <span>����</span>
	    <span>����</span>
	    <button class="loginBtn">�α���</button>
    </div>
    
    <%
    	for(int i = 0; i < memberList.size(); i++) {
    %>
		    <div>
			    <span><%=memberList.get(i).getId() %></span>
			    <span><%=memberList.get(i).getPassword() %></span>
			    <span><%=memberList.get(i).getName() %></span>
			    <span><%=memberList.get(i).getPoint() %></span>
			    <button class="revise">����</button>
			    <button class="delete">����</button>
		    </div>
		    
    <%
    	}
    %>
    
   	<div>
   		<button id="start">�����ٷ�(20�ʸ��� ����Ʈ 1����)���� ����</button>
   		<button id="end">�����ٷ����� ����</button>
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
		    	alert('�����Ǿ����ϴ�.');
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