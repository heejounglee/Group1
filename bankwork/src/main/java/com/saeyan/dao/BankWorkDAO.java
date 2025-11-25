package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.AccountInfoVO;
import com.saeyan.dto.DepositInfoVO;

import util.DBManager;

public class BankWorkDAO {
	
	private static BankWorkDAO instance = new BankWorkDAO();
	
	//생성자
	private BankWorkDAO() {}
	
	public static BankWorkDAO getInstance() {
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

public List<DepositInfoVO> selectAllBankWorks(String account) {
ResultSet rs = null;

String sql = "select * from depositinfo where account = ?";
Connection con = null;
PreparedStatement pstmt = null;

List<DepositInfoVO> list = new ArrayList<DepositInfoVO>();

try {
    con = DBManager.getConnection(); // DB 연결
    pstmt = con.prepareStatement(sql); // 쿼리 준비
    pstmt.setString(1,account);
    
    rs = pstmt.executeQuery(); // 쿼리 실행
   
    while(rs.next()) {
        DepositInfoVO vo = new DepositInfoVO(); 
    	vo.setNum(rs.getInt("num"));
        vo.setAccount(rs.getString("account"));
        vo.setName(rs.getString("name"));
        vo.setDepositdate(rs.getTimestamp("depositdate")); 
        vo.setFlag(rs.getString("flag"));
        vo.setMoney(rs.getLong("money"));
        vo.setBalance(rs.getLong("balance"));
        vo.setMemo(rs.getString("memo"));
        
        list.add(vo);
    }
} catch (SQLException e) { // 예외 처리
    e.printStackTrace();
} finally {
    DBManager.close(con, pstmt, rs); // 자원 해제
}

return list;
}

//거래내역 저장
public void depositInsert(String account, String name, String flag, int money, long balance, String memo) {

    String sql = "INSERT INTO depositinfo (account, name, flag, money, balance, depositdate, memo) "
               + "VALUES (?, ?, ?, ?, ?, current_timestamp, ?)";

    int result = -1;
	Connection con = null;
	PreparedStatement pstmt = null;
    try {	
    //1. DB연결
	con = DBManager.getConnection();
	//2. sql전송
	pstmt = con.prepareStatement(sql);

        pstmt.setString(1, account);
        pstmt.setString(2, name);
        pstmt.setString(3, flag);
        pstmt.setInt(4, money);
        pstmt.setLong(5, balance);
        pstmt.setString(6, memo);
        pstmt.executeUpdate();

    }catch (Exception e) {
        e.printStackTrace();
    }
}


public void blanceUpdate(String account, String flag, int money) {

	int amount = flag.equals("입금") ? money : -money; 
	Connection con = null;
	PreparedStatement 
	pstmt = null; 
	String sql = "UPDATE accountinfo SET balance = balance + ? WHERE account = ?";
	
    try {
    	//1. DB연결
  		con = DBManager.getConnection();
      			
  		//2. sql전송
  		pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, amount);
        pstmt.setString(2, account);

        pstmt.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public long selectByAccount(String account) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "select balance from accountInfo where account = ?";
	long balance = 0;
	
	try {
		
		//1. DB연결
		con = DBManager.getConnection();
		
		//2. sql전송
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, account);
		
		//4. sql 실행
		rs = pstmt.executeQuery();
		
		//비추천
		if(rs.next()) {
			balance = rs.getLong(1);
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBManager.close(con, pstmt, rs);
	}
	
	return balance;
} //end selectByAccount

public int updateAccount(AccountInfoVO vo){
	String sql = "UPDATE accountinfo set alias = ?, phone=?, status=? WHERE account = ?";
    int result = 0;
    
    Connection con = null;
	PreparedStatement pstmt = null;

	
     try{
           con = DBManager.getConnection();
           pstmt = con.prepareStatement(sql); 

           pstmt.setString(1, vo.getAlias());
           pstmt.setString(2, vo.getPhone());
           pstmt.setString(3, vo.getStatus());
           pstmt.setString(4, vo.getAccount());

	        result = pstmt.executeUpdate();
            
     } catch(Exception e) {
         e.printStackTrace();
     } finally {
         DBManager.close(con, pstmt);
     }
	 return result;
}
public List<AccountInfoVO> getAccountList(String userId) {
    List<AccountInfoVO> list = new ArrayList<>();
    String sql = "SELECT account, alias, phone, status FROM accountinfo WHERE userid = ?";
    
    System.out.println("===== getAccountList 호출 =====");
    System.out.println("userId 파라미터: " + userId);

    
    System.out.println("getAccountList 호출 - userId = " + userId);

    try (Connection con = DBManager.getConnection();
         PreparedStatement pstmt = con.prepareStatement(sql)) {

        pstmt.setString(1, userId);
        
        System.out.println("SQL 준비 완료: " + sql);
        System.out.println("PreparedStatement 파라미터: " + userId);

        try (ResultSet rs = pstmt.executeQuery()) {
        	int rowCount = 0;
            while (rs.next()) {
                AccountInfoVO vo = new AccountInfoVO();
                vo.setAccount(rs.getString("account"));
                vo.setAlias(rs.getString("alias"));
                vo.setPhone(rs.getString("phone"));
                vo.setStatus(rs.getString("status"));
                list.add(vo);
            }
            
        }

    } catch (Exception e) {      // 일반 예외는 나중에
          e.printStackTrace();
    }

    System.out.println("getAccountList 종료 - 가져온 데이터 수: " + list.size());
    return list;
    }

}
