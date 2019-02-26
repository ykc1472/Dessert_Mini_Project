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
		MemberDTO dto = null;
		String username = null;
		String phone = null;
		String email = null;
		if(request.getParameter("username") != null && request.getParameter("username") != null &&request.getParameter("username") != null) {
			dto = new MemberDTO();
			username = request.getParameter("username").trim();
		 	phone = request.getParameter("phone").trim();
			email = request.getParameter("userEMail").trim();
			
			dto.setUsername(username);
			dto.setPhone(phone);
			dto.setEmail(email);
		}
		

		MemberService service = new MemberService();

		HashMap<String, String> map = new HashMap<>();
		map = service.idSearch(dto);

		String nextPage = null;
		if (map == null) {
			nextPage = "MemberIdSearchUIServlet";
			request.setAttribute("mesg", "이름 또는 핸드폰이 등록되지 않은 정보");

		} else {
			String mailtitle = "Dessert_Mini_Project 회원가입 아이디 찾기 메일";
			String mailbody = null;

			mailbody = "<h1>Dessert_Mini_Project</h1><h3>아이디찾기 메일입니다.</h3>"
					+ "<h3>아이디는 :</h3><h1>" + map.get("USERID") + "</h1><h3>입니다.</h3>";
			nextPage = "SendMailServlet";
			request.setAttribute("mailtitle", mailtitle);
			request.setAttribute("mailbody", mailbody);
			request.setAttribute("userid2", map.get("USERID2"));
			request.setAttribute("userEmail", email);
			request.setAttribute("nextPage", "idSearchResult.jsp");

			
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
