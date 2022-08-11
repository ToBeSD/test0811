package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDto;

public class DaoTest {
	
	public ArrayList<MemberDto> findAllMember(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
		String sql = "select * from member";
				
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
	            String id = rs.getString("id");
	            String password = rs.getString("password");
	            String name = rs.getString("name");
	            int point = rs.getInt("point");
	            MemberDto member = new MemberDto(id, password, name, point);
	            
	            memberList.add(member);
	            
	            System.out.println("id = "+id+" \t password = "+password+" \t name = "+name+" \t point = "+point+"  ");
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
	
	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		DaoTest test = new DaoTest();
		
		test.findAllMember(conn, pstmt, rs);
		
		System.out.println("테스트 완료");
	}

}
