package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.MemberDto;

public class MemberDao {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JSP_PROJECT", "1111");
	return con;	
	}

	public int insertMember(MemberDto member) {
		String sql = "INSERT INTO MEMBERS(MID, MPW, MNAME, MBIRTH, MADDR, MEMAIL, MSTATE) VALUES(?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?)";
		int insertResult = 0;
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
			pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMbirth());
			pstmt.setString(5, member.getMaddr());
			pstmt.setString(6, member.getMemail());
			pstmt.setString(7, member.getMstate());
			insertResult = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return insertResult;
	}

	public String selectMember(String logMemId, String logMemPw) {
		String sql = "SELECT MID FROM MEMBERS WHERE MID = ? AND MPW = ?";
		String loginId = null;
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,logMemId);
			pstmt.setString(2,logMemPw);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			if(rs.next()) {
				loginId = rs.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return loginId;
	}

	public MemberDto selectMemberDto(String inputId) {
		System.out.println("mdao selectMemberDto()");
		String sql = "SELECT * FROM MEMBERS WHERE MID = ?";
		MemberDto Member = null;
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inputId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Member = new MemberDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return Member;
	}

}
