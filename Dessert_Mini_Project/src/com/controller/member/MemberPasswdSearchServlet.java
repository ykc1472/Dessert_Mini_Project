package com.controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.service.MemberService;

@WebServlet("/MemberPasswdSearchServlet")
public class MemberPasswdSearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username").trim();
		String userid = request.getParameter("userid").trim();
		String email = request.getParameter("userEMail").trim();
		
		String mesg = "<h1>Dessert_Mini_Project</h1><h3>이메일 인증입니다</h3>";
		
		Random rnd = new Random();
		StringBuffer buf = new StringBuffer();
		for(int i=0;i<10;i++){
		     //rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.
		    if(rnd.nextBoolean()){
		        buf.append((char)((int)(rnd.nextInt(26))+97));
		    }else{
		        buf.append((rnd.nextInt(10)));
		    }
		}

		MemberDTO dto = new MemberDTO();
		dto.setUsername(username);
		dto.setUserid(userid);
		dto.setEmail(email);
		
		MemberService service = new MemberService();
		String userpw = service.passwdSearch(dto);
		String nextPage = null;
		if (userpw == null) {
			nextPage = "MemberPasswdSearchUIServlet";
			request.setAttribute("mesg", "등록되지 않은 정보입니다.");
		} else {
			nextPage="SendMailServlet";
			
			HttpSession session = request.getSession();
			
			mesg += "<h3>회원가입에 필요한 인증번호 :</h3><h2>"+buf+"</h2><h3>입니다.</h3>";
			request.setAttribute("mesg", "메일을 보내드렸습니다. 확인해주세요.");
			request.setAttribute("mailtitle", "Dessert_Mini_Project 비밀번호 찾기 본인 인증메일 입니다."); //제목
			request.setAttribute("userEmail",email); // 받는 메일
			request.setAttribute("mailbody", mesg);
			request.setAttribute("nextPage", "passwdCheck.jsp");
			session.setAttribute("buf", buf.toString());
			session.setAttribute("userid", userid);
			
		}
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
