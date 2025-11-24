package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.BankWorkDAO;
import com.saeyan.dto.DepositInfoVO;
import com.saeyan.dto.MemberVO;

@WebServlet("/depositUpdate.do")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 public DepositServlet() {
	    }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 String account = request.getParameter("account");
		 
		 HttpSession session = request.getSession();
		 MemberVO mvo =  (MemberVO) session.getAttribute("loginUser");
		 request.setAttribute("name", mvo.getName());
		 	
		 request.setAttribute("account", account);
		 
		 request.getRequestDispatcher("deposit/depositUpdate.jsp")
			.forward(request, response);
	 }
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String account = request.getParameter("account");
        String name = request.getParameter("name");  
        String flag = request.getParameter("flag");  
        int money = Integer.parseInt(request.getParameter("money"));

        BankWorkDAO dao = BankWorkDAO.getInstance();
       
        // 잔액 
        dao.blanceUpdate(account, flag, money);
        
        long balance = dao.selectByAccount(account);
        
        /*
        if (flag.equals("입금")) {
        	System.out.println("입금");
        	balance = balance + money;
        } else if (flag.equals("출금")) {
        	System.out.println("출금");
        	balance = balance - money;
        } */
        
        //거래내역
        dao.depositInsert(account,name, flag, money, balance);

        
        

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h2>거래가 완료되었습니다.</h2>");
        response.getWriter().println("<a href='accountList.do'>내계좌정보</a>");
    }
}
    