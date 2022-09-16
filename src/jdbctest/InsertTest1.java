package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertTest1 {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			con = getConnection();
			System.out.println("DB연결 성공!!");
		} catch(Exception e) {
			System.out.println("DB연결 실패!!");
			e.printStackTrace();
		}
		
//		String sql = "INSERT INTO PRODUCT(PDCODE, PDNAME, PDPRICE, PDAMOUNT, PDTYPE)"
//				   + "VALUES('PTESS', '입력테스트', 2000, 100, 'TEST')";
		String sql = "DELETE FROM PRODUCT WHERE PDCODE = 'PTESS'";
		int insertResult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			insertResult = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(insertResult > 0) {
			System.out.println("새 상품이 등록 되었습니다.");
		} else {
			System.out.println("새 상품 등록에 실패했습니다.");
		}
		// JAVA에서 COMMIT에 대한 설정 해주지 않으면 자동으로 COMMIT
		System.out.println("insertResult : " + insertResult);
	}
	
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JGM_DBA", "1111");
		return con;
	}

}
