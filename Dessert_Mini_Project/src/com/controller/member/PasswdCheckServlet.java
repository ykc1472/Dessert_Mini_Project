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

@WebServlet("/PasswdCheckServlet")
public class PasswdCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String buf = (String)session.getAttribute("buf").toString();
		String userid = (String)session.getAttribute("userid").toString();
		String pwcheck = request.getParameter("pwcheck").trim();
		
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		
		MemberService service = new MemberService();
		String userpw = service.passwdSearch2(dto);
		
		session.setAttribute("userpw", userpw);
		
		String nextPage = null;
		if (!(pwcheck.equals(buf))) {
			nextPage = "passwdCheck.jsp";
			request.setAttribute("mesg", "인증번호가 일치하지 않습니다. 다시 입력해주세요. ");
		} else {
			nextPage="passwdCheck2.jsp";
			session.removeAttribute("buf");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
