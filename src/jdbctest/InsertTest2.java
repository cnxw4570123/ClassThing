package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest2 {

	public static void main(String[] args) {
		// 상품등록 새상품에 대한 정보를 전송 
		System.out.println("상품이름 입력>>");
		String pdName = "새상품1";
		int pdPrice = 20000;
		int pdAmount = 20;
		String pdType = "테스트상품";
		
		String pdcode = "PASDF";
		
		
		Connection con = null;
		try {
			con = getConnection();
			System.out.println("DB연결 성공!!");
		} catch(Exception e) {
			System.out.println("DB연결 실패!!");
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO PRODUCT(PDCODE, PDNAME, PDPRICE, PDAMOUNT, PDTYPE)"
				+ "VALUES(?, ?, ?, ?, ?)";
		int insertResult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, pdcode);
			
			insertResult = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(insertResult > 0) {
			System.out.println("새 상품이 등록 되었습니다.");
		} else {
			System.out.println("새 상품 등록에 실패했습니다.");
		}
		System.out.println("insertResult : " + insertResult);
	}
	
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JGM_DBA", "1111");
		return con;
	}

}
