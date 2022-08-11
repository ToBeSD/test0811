package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;
import quartz.QuartzTest;

@WebServlet("/admin")
public class Admin extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.sendRedirect("/test0811/Admin.jsp");
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String id = request.getParameter("id");
		
		String sql = "delete member where id = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
	        pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
