package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.sendRedirect("/test0811/Login.jsp");
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String sql = "select * from member where id = '"+ id +"' and password = "+ password + " ";
		
		String realId = null;
		String realPassword = null;
		String name = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {

	            realId = rs.getString("id");
	            name = rs.getString("name");
	            realPassword = rs.getString("password");

	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		
		if(id.equals(realId) && password.equals(realPassword) && realId.equals("admin") ) {
			
			 response.sendRedirect("/test0811/admin");
			 
		} else if(id.equals(realId) && password.equals(realPassword) ) {
			RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
			request.setAttribute("id", realId);
			request.setAttribute("name", name);
			rd.forward(request, response);

		}else {
			 response.sendRedirect("/test0811/login");
		}
		
		
	}
	
}