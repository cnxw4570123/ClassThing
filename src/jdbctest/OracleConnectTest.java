package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleConnectTest {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			con = getConnection();
			System.out.println("DB연결 성공!!");
		} catch(Exception e) {
			System.out.println("DB연결 실패!!");
			e.printStackTrace();
		}
		// 쿼리문 작성
		String sql = "SELECT * FROM PRODUCT";
		// Statement를 상속 받아 업그레이드 -> PreparedStatement
		try {
			//작성된 쿼리문을 전송하기 위한 용도
			PreparedStatement pstmt = con.prepareStatement(sql);
			//쿼리문을 전송하고 ResultSet에 반환
			ResultSet rs = pstmt.executeQuery();
			//executeQuery -> SELECT문 사용할 때, select문이 아니여도 실행은 가능하지만, ResultSet타입의 객체로 리턴 
			//executeUpdate -> SELECT문 이외에 결과 -> 숫자 값 반환(int)
			while(rs.next()) {
				//getString, getInt 등 타입 맞춰주어야 함.
				//getDate도 가능하지만 활용 목적에 따라 다르지만 String으로 받아오는 것이 활용이 더 편함.
				System.out.print(rs.getString(1));
				System.out.print(" " + rs.getString(2));
				System.out.println(" " + rs.getInt("PDPRICE"));
			}
			//안해도 자동으로 닫히지만 필요시 다시 접속하는 것이 정석
			rs.close();
			pstmt.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JGM_DBA", "1111");
		return con;
	}

}
