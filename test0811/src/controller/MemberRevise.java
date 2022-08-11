package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnection;

@WebServlet("/memberRevise")
public class MemberRevise extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		RequestDispatcher rd = request.getRequestDispatcher("/Admin-revise.jsp");
		request.setAttribute("id", id);
		request.setAttribute("password", password);
		request.setAttribute("name", name);
		request.setAttribute("point", point);
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		int point = Integer.parseInt(request.getParameter("point"));
		
		Connection conn = DBConnection.getConnection();
		
		String sql = "update member set point = ?, password = ?, name = ? where id = ?";
		
		
        try {
        	PreparedStatement pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, point);
        	pstmt.setString(2, password);
        	pstmt.setString(3, name);
        	pstmt.setString(4, id);
	        pstmt.executeUpdate();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        response.sendRedirect("/test0811/admin");

		
	}

}
