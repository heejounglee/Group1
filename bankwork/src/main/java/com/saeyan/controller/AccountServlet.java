package com.saeyan.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.BankWorkDAO;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.AccountInfoVO;
import com.saeyan.dto.MemberVO;

@WebServlet(urlPatterns = {"/accountWrite.do", "/accountView.do","/test.do"})
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String servletPath = request.getServletPath(); // 요청된 실제 서블릿 경로를 가져오기
		
		// 요청된 URL 패턴에 따라 분기 처리
        if ("/accountWrite.do".equals(servletPath)) {
        	System.out.println("계좌등록 페이지 요청");
        	request.getRequestDispatcher("account/accountWrite.jsp")
			.forward(request, response);
            
        } else if ("/accountView.do".equals(servletPath)) {
        	System.out.println("등록된 계좌 보기");
        	
        	doPost(request, response);
        } else {
        	doPost(request,response);
        }
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String servletPath = request.getServletPath(); // 요청된 실제 서블릿 경로를 가져오기
		
		 request.setCharacterEncoding("utf-8");
		 
		 HttpSession session = request.getSession();
		 MemberVO mvo =  (MemberVO) session.getAttribute("loginUser");
		 
		 BankWorkDAO dao = BankWorkDAO.getInstance();
		 MemberDAO mdao = MemberDAO.getInstance();
		 
		 if ("/accountWrite.do".equals(servletPath)) {
			 int result = -1;
			 String account = request.getParameter("acct1")+"-"+request.getParameter("acct2")+"-"+request.getParameter("acct3");
			 String name = request.getParameter("name");
			 String alias = request.getParameter("alias");
			 String phone = request.getParameter("phone");
			 long balance = Long.parseLong(request.getParameter("balance"));
			 String status = request.getParameter("status");
			 String userid = mvo.getUserid();
			 
			 AccountInfoVO vo = new AccountInfoVO();
			 vo.setAccount(account);
			 vo.setName(name);
			 vo.setAlias(alias);
			 vo.setPhone(phone);
			 vo.setBalance(balance);
			 vo.setStatus(status);
			 vo.setUserid(userid);
			 
			 try {
				 
				 mvo = mdao.getMember(userid);
				 
				 result = dao.accountInsert(vo);
				 
			 } catch (Exception e) {
				 
				 e.printStackTrace();
				 
			 } finally {
				 
	             if (result > 0) {
	            	 request.setAttribute("message", "계좌 등록이 완료되었습니다.");
	         		 response.sendRedirect("accountView.do?account=" + URLEncoder.encode(account, "UTF-8"));
	             } else {
	            	 request.setAttribute("pwd", mvo.getPwd());
	            	 request.setAttribute("errorMessage", "계좌 등록이 실패되었습니다. - 은행계좌를 확인해주세요.");
			         request.getRequestDispatcher("/account/accountCheckFail.jsp").forward(request, response);
	            	 
	             }
	             
	         }
			
			 
		 } else if ("/accountView.do".equals(servletPath)) {
			 
			 String account = request.getParameter("account");
				
			 AccountInfoVO vo = dao.selectOneByNum(account);
			
			 request.setAttribute("account", vo);
			 request.getRequestDispatcher("/account/accountView.jsp").forward(request, response);
		 } 
		 
	}

}
