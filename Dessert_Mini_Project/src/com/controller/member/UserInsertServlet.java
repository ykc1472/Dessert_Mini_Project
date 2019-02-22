package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/UserAdd")
public class UserInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid").toLowerCase();
		String password = request.getParameter("userpw");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String userEMail = request.getParameter("userEMail");
		String userPhoneNum = request.getParameter("userPhoneNum");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDTO dto = new MemberDTO(userid, password, userName, nickName, userEMail, userPhoneNum, post, addr1, addr2);
		MemberService service = new MemberService();
		int success = service.userAdd(dto);
		
		if(success == 1) {
			request.setAttribute("mesg", "회원가입에 성공하셨습니다.");
		} else {
			request.setAttribute("mesg", "회원가입에 실패하셨습니다. 다시 시도해 주세요.");
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("loginForm.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
