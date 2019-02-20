package com.controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailCheckServlet
 */
@WebServlet("/EmailCheck")
public class EmailCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random rnd = new Random();
		StringBuffer buf =new StringBuffer();
		String mesg = "<h1>Dessert_Mini_Project</h1><h3>이메일 인증입니다</h3>";
		
		for(int i=0;i<10;i++){
		    // rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.
		    if(rnd.nextBoolean()){
		        buf.append((char)((int)(rnd.nextInt(26))+97));
		    }else{
		        buf.append((rnd.nextInt(10)));
		    }
		}
		
		mesg += "<h3>회원가입에 필요한 인증번호 :</h3><h2>"+buf+"</h2><h3>입니다.</h3>";
		request.setAttribute("mesg", buf.toString());
		request.setAttribute("mailbody", mesg);
		request.setAttribute("mailtitle", "Dessert_Mini_Project 회원가입 인증메일 입니다.");
		request.setAttribute("userEmail", request.getParameter("userEmail"));
		
		RequestDispatcher dis = request.getRequestDispatcher("SendMailServlet");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
