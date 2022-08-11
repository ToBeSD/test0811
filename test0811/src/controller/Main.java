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

import org.json.simple.JSONObject;

import dao.DBConnection;

@WebServlet("/main")
public class Main extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.sendRedirect("/test0811/Main.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int price = Integer.parseInt(request.getParameter("price"));
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "update member set point = point - ? where id = ?";
		
		
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, price);
        	pstmt.setString(2, id);
	        pstmt.executeUpdate();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}