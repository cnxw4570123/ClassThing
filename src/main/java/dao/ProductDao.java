package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.ProductDto;

public class ProductDao {
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	private Connection con = null;
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "JSP_PROJECT", "1111");
		return con;
	}
	
	
	public int insertProduct(ProductDto pr) {
		System.out.println("pdao insertProduct() 호출");
		String checksql = "SELECT PRNAME FROM PRODUCTS WHERE PRNAME = ?";
		String sql = "INSERT INTO PRODUCTS(PRCODE, PRBRAND, PRNAME, PRPRICE, PRIMG) VALUES(?, ?, ?, ? ,?)";
		int insertRs = 0;

		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(checksql);
			pstmt.setString(1, pr.getPrname());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("중복 O");
			} else {
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, pr.getPrcode());
				pstmt.setString(2, pr.getPrbrand());
				pstmt.setString(3, pr.getPrname());
				pstmt.setInt(4, pr.getPrprice());
				pstmt.setString(5, pr.getPrimg());
				
				insertRs = pstmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return insertRs;
	}
	
	public int selectMaxNum() {
		int count = 0;
		String sql = "SELECT MAX(PRCODE) FROM PRODUCTS";
		
		try {
			Connection con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String prcode = rs.getString(1);
				if(prcode == null) {
					prcode = "P0000";
				}
				count = Integer.parseInt(prcode.split("P")[1]);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
