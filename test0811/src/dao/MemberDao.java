package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.MemberDto;

public class MemberDao {
	
	
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
	          
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}
}
