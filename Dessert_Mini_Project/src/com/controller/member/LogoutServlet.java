package com.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mesg = null;
		if(session.getAttribute("loginInfo") != null) {
			String nickName = ((MemberDTO)session.getAttribute("loginInfo")).getusernickname();
			session.removeAttribute("loginInfo");
			mesg = nickName +"님 정상적으로 로그아웃 되었습니다.";
		} else {
			mesg = "로그인 정보가 없습니다.";
		}
		session.setAttribute("mesg", mesg);
		
		response.sendRedirect("main");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
