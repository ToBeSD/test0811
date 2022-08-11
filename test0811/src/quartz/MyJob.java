package quartz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.DBConnection;

public class MyJob implements Job {
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Date now = new Date();
		
		System.out.println("Job이 실행됨 : "+now+" / 5명에게 포인트 부여(1점)");
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update member set point = point + 1 ";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
	        pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
