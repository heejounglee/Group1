package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.BankWokDAO;
import com.saeyan.dto.AccountInofoVO;

@WebServlet("/accountWrite.do")
public class AccountWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountWriteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("account/accountWrite.jsp")
			.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 request.setCharacterEncoding("utf-8");
		
		 String account = request.getParameter("account");
		 String name = request.getParameter("name");
		 String userid = request.getParameter("userid");
		 String phone = request.getParameter("phone");
		 
		 AccountInofoVO vo = new AccountInofoVO();
		 vo.setAccount(account);
		 vo.setName(name);
		 vo.setUserid(userid);
		 vo.setPhone(phone);
		 
		 BankWokDAO dao = BankWokDAO.getInstance();
		 
		 int result = dao.accountInsert(vo);
		 
		 HttpSession session = request.getSession();
		 if(result == 1) {
			 request.setAttribute("message", "계좌 등록이 완료되었습니다.");
			 session.setAttribute("userid", userid);
//			 session.setAttribute("userid", mvo.getUserid());
			 
		 }else {
			 request.setAttribute("message", "계좌 등록이 실패되었습니다.");
		 }
		 
		 //request.getRequestDispatcher("member/login.jsp")
		// 	.forward(request, response);
	}

}
