package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/loginAction")
public class LoginActionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid = request.getParameter("userid").toLowerCase();
		String userpw = request.getParameter("userpw");
		
		MemberDTO dto = new MemberDTO(userid, userpw);
		
		MemberService service = new MemberService();
		MemberDTO loginInfo = service.loginAction(dto);
		
		HttpSession session = request.getSession();
		String nextPage = "loginForm.jsp";
		
		
		if (loginInfo != null && loginInfo.getGrade() < 10) {
			session.setAttribute("mesg", loginInfo.getUserid()+"는 접근이 제한된 계정입니다.");
			
		} else if (loginInfo == null) {
			session.setAttribute("mesg", "아이디와 비밀번호를 확인해 주세요.");
			
		} else {
			session.setAttribute("loginInfo", loginInfo);
			
			if(session.getAttribute("backPage") != null) {
				nextPage = (String)session.getAttribute("backPage");
				session.removeAttribute("backPage");
			}
			else {
				nextPage = "main";
			}
		}
		
		response.sendRedirect(nextPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
