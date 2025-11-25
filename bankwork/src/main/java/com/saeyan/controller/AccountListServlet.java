package com.saeyan.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.BankWorkDAO;
import com.saeyan.dto.AccountInfoVO;
import com.saeyan.dto.MemberVO;

@WebServlet("/accountList.do")
public class AccountListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AccountListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        MemberVO mvo =  (MemberVO) session.getAttribute("loginUser");
        
        if (session == null || mvo == null || mvo.getUserid() == null) {
        	request.getRequestDispatcher("member/login.jsp").forward(request, response);
            return;
        }

        String userid = mvo.getUserid();

        // 3. DB에서 계좌 목록 조회
        BankWorkDAO dao = BankWorkDAO.getInstance();
        List<AccountInfoVO> list = dao.getAccountList(userid);

        // 4. 조회 결과 request에 저장
        request.setAttribute("accountList", list);

        // 5. JSP로 forward
        request.getRequestDispatcher("/account/accountList.jsp").forward(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        System.out.println("accountList.do → doPost() 실행");

        // POST 요청도 동일하게 처리할 경우
        doGet(request, response);
    }
}
