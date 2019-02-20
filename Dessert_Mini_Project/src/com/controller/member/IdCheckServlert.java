package com.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MemberService;

@WebServlet("/IdCheck")
public class IdCheckServlert extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid = request.getParameter("userid").toLowerCase();
		RequestDispatcher dis = request.getRequestDispatcher("mesg/message.jsp");

		
		MemberService service = new MemberService();
		int success = service.userIDCheck(userid);
		if(success == 0) {
			request.setAttribute("mesg", "사용 가능한 ID 입니다.");
		}else {
			request.setAttribute("mesg", "이미 사용중인 ID 입니다.");
		}
		
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
