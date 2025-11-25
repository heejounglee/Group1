package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.BankWorkDAO;
import com.saeyan.dto.AccountInfoVO;
import com.saeyan.dto.MemberVO;

@WebServlet("/accountUpdate.do")
public class AccountUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountUpdateServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session = request.getSession();
        MemberVO mvo =  (MemberVO) session.getAttribute("loginUser");
        
        String userid = mvo.getUserid();
        
        if (session == null || userid == null) {
            response.sendRedirect("/member/login.jsp");
            return;
        }

        String account = request.getParameter("account");

        BankWorkDAO dao = BankWorkDAO.getInstance();
        AccountInfoVO vo = dao.selectOneByNum(account); // DAO 메소드 이름 수정

        request.setAttribute("accountOne", vo);
        request.getRequestDispatcher("/account/accountUpdate.jsp")
                .forward(request, response);
    }

    // 수정 처리(POST)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");

        AccountInfoVO vo = new AccountInfoVO();
        vo.setAccount(request.getParameter("account"));
        vo.setAlias(request.getParameter("alias"));
        vo.setPhone(request.getParameter("phone"));
        vo.setStatus(request.getParameter("accountStatus"));
        
        BankWorkDAO dao = BankWorkDAO.getInstance();
        dao.updateAccount(vo); // DAO 예외 처리 내부에서 하는 것이 안전

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h2>수정 완료되었습니다.</h2>");
        response.getWriter().println("<a href='accountList.do'>내계좌정보</a>");
    }
}