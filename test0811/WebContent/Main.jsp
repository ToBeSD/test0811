<%@page import="dao.*"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");

	
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	String sql = "select * from member where id = '"+ id +"'";
	
	String name = null;
	int point = 0;
	try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			name = rs.getString("name");
	        point = rs.getInt("point");
	
	    }
		
	} catch (SQLException e) {
		e.printStackTrace();
	}



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
</head>
<body>
	<div style="display: flex; justify-content: space-between;]">
		<div>
			<h1>����������</h1>
		</div>
		<div>
			<div>
				<%=id %>(<%=name %>)�� �ȳ��ϼ���. <button id="logout">�α׾ƿ�</button>
			</div>
			<div>
				����Ʈ : <span id="nowPoint"><%=point %></span>��
			</div>
		</div>		
	</div>
	<div>
		<h3>������ �������� �����ϼ���.</h3>
	</div>
	
	<div style="display: flex">
		<div>
			<img src="Java_350_408.png" class="study">
			<span>500000</span>�� ����Ʈ
		</div>
		
		<div>
			<img src="Cpp_350_408.png" class="study">
			<span>300000</span>�� ����Ʈ
		</div>
		
		<div>
			<img src="Intro_350_408.png" class="study">
			<span>100000</span>�� ����Ʈ
		</div>
	</div>	
	
	<div style="height: 200px;"></div>
	
	<div>
		<img src="korea_it.png" id="ad"> ����
	</div>
	
<script>
	const logoutBtn = document.querySelector('#logout')
	
	logoutBtn.addEventListener('click', function() {
		alert('�α׾ƿ� �Ǿ����ϴ�.')
		location.href = '/test0811/login'
	})
	
	
	$('.study').click(function(e) {		
		let price = $(e.target).siblings('span').html();
		let item = $(e.target).attr('src').replace('_350_408.png', '')
    	let nowPoint = $('#nowPoint').text();

		if(price > <%= point%>) {
			alert('����Ʈ�� �����մϴ�. ���� Ŭ���ϼ���.')
		}else {			
			$.ajax({
			    type: "POST",
			    url: '/test0811/main',
			    data: {
			    	id : '<%=id%>',
			    	price : price,
			    },
			    success: function (data) {
			    	alert(item + ' ���ſϷ�! ' + price + ' ����Ʈ ����')
			    	$('#nowPoint').text(nowPoint - price);

			    },
			})
		}
	}) 
	
	
	$('#ad').click(function() {		
		let nowPoint = $('#nowPoint').text();
			$.ajax({
			    type: "get",
			    url: '/test0811/ad',
			    data: {
			    	id : '<%=id%>',
			    	adpoint : 1000,
			    },
			    success: function (data) {
			    	alert('1000���� �����Ǿ����ϴ�')
			    },
			})
			
	})
	
</script>
</body>
</html>