package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.saeyan.dto.AccountInofoVO;

import util.DBManager;

public class BankWokDAO {
	
	private static BankWokDAO instance = new BankWokDAO();
	
	private BankWokDAO() {}
	
	public static BankWokDAO getInstance() {
		return instance;
	}
	
public int accountInsert(AccountInofoVO vo) {
		
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into accountinfo(account, name, balance)"
				+ " values(?, ?, ?, ? )";
		
		try {
			
			//1. DB연결
			con = DBManager.getConnection();
			
			//2. sql전송
			pstmt = con.prepareStatement(sql);
			
			//3. sql 맵핑
			pstmt.setString(1, vo.getAccount());
			pstmt.setString(2, vo.getName());
			pstmt.setLong(3, vo.getBalance());
			
			//4. sql 실행
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
		return result;
		
	} //end accountInsert
	
}
