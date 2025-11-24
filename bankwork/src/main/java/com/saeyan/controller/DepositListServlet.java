package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.saeyan.dao.BankWorkDAO;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.DepositInfoVO;
import com.saeyan.dto.MemberVO;


/**
 * Servlet implementation class DepositListServlet
 */
@WebServlet("/depositList.do")
public class DepositListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DepositListServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	//1. DAO 인스턴스 가져오기 (싱글톤 패턴 사용)
    	BankWorkDAO bdao = BankWorkDAO.getInstance(); 
    	
		String account = request.getParameter("account");
		
	    System.out.println("==================== account" + account);
		
    	// 2. 데이터베이스에서 거래 내역 목록 조회
        List<DepositInfoVO> depositList = bdao.selectAllBankWorks(account);
        
        		
        // 3. 조회한 결과를 request 객체에 "depositList"라는 이름으로 저장
        // -> 이 데이터를 JSP 페이지로 넘겨줍니다.
        request.setAttribute("depositList", depositList);
        
        request.getRequestDispatcher("/deposit/depositList.jsp")
               .forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
