package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/MemberIdSearchServlet")
public class MemberIdSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username").trim();
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("userEMail").trim();

		MemberDTO dto = new MemberDTO();

		dto.setUsername(username);
		dto.setPhone(phone);
		dto.setEmail(email);

		System.out.println(dto);
		/*
		 * String to = mailTo; //받는 메일 String content = "아이디:" + userid;
		 */

		MemberService service = new MemberService();

		HashMap<String, String> map = new HashMap<>();
		map = service.idSearch(dto);

		// String userid = service.idSearch(dto);
		String nextPage = null;
		if (map == null) {
			nextPage = "MemberIdSearchUIServlet";
			request.setAttribute("mesg", "이름 또는 핸드폰이 등록되지 않은 정보");

		} else {

			String userid = map.get("USERID");
			String userid2 = map.get("USERID2");

			nextPage = "SendMailIdSearchServlet";
			request.setAttribute("userid", userid);
			request.setAttribute("userid2", userid2);
			request.setAttribute("email", email);

			
		}

		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
