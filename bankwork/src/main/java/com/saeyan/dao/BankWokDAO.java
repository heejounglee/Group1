package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saeyan.dto.AccountInfoVO;

import util.DBManager;

public class BankWokDAO {
	
	private static BankWokDAO instance = new BankWokDAO();
	
	private BankWokDAO() {}
	
	public static BankWokDAO getInstance() {
		return instance;
	}
	
public int accountInsert(AccountInfoVO vo) {
		
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into accountinfo(account, name, alias, phone, balance, userid, status)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			//1. DB연결
			con = DBManager.getConnection();
			
			//2. sql전송
			pstmt = con.prepareStatement(sql);
			
			//3. sql 맵핑
			pstmt.setString(1, vo.getAccount());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAlias());
			pstmt.setString(4, vo.getPhone());
			pstmt.setLong(5, vo.getBalance());
			pstmt.setString(6, vo.getUserid());
			pstmt.setString(7, vo.getStatus());
			
			//4. sql 실행
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
		return result;
		
	} //end accountInsert

public AccountInfoVO selectOneByNum(String account) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from accountinfo  where account = ?";
	
	AccountInfoVO vo = new AccountInfoVO();
	
	try {
		
		con = DBManager.getConnection();
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, account);
		
		rs = pstmt.executeQuery();

		if(rs.next()) { //가져올 데이타 있니?
			vo.setNum(rs.getInt("num"));
			vo.setAccount(rs.getString("account"));
			vo.setName(rs.getString("name"));
			vo.setAlias(rs.getString("alias"));
			vo.setPhone(rs.getString("phone"));
			vo.setBalance(rs.getInt("balance"));
			vo.setUserid(rs.getString("userid"));
			vo.setStatus(rs.getString("status"));
			
		}	
		
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(con, pstmt, rs);
	}
	
	return vo;
	
}

}
