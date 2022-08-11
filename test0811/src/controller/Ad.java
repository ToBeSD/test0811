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

@WebServlet("/ad")
public class Ad extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		int point = Integer.parseInt(request.getParameter("adpoint"));
		String id = request.getParameter("id");

		
		String sql = "update member set point = point + ? where id = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
	        pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//이게 cors에러가 떠서 안가지는데 정상적인 코드라고 생각합니다 ,,,ㅠㅠ 1000점 더하기는 정상적으로 작동합니다..
		response.sendRedirect("https://www.koreaisacademy.com");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
