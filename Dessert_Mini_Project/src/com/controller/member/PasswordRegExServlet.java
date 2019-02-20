package com.controller.member;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/PasswordRegEx")
public class PasswordRegExServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		int mesg = 0;
		// 비밀번호 유효성 검사식1 : 숫자, 특수문자가 포함되어야 한다.
        String regExp_symbol = "([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])";
        // 비밀번호 유효성 검사식2 : 영문자 대소문자가 적어도 하나씩은 포함되어야 한다.
        String regExp_alpha = "([a-z].*[A-Z])|([A-Z].*[a-z])";
        
        // 정규표현식 컴파일
        Pattern pattern_symbol = Pattern.compile(regExp_symbol);
        Pattern pattern_alpha = Pattern.compile(regExp_alpha);
        
        
        // 문자 매칭
        Matcher matcher_symbol = pattern_symbol.matcher(password);
        Matcher matcher_alpha = pattern_alpha.matcher(password);
        if(!matcher_symbol.find()) {
        	mesg = 1;
            // System.out.println("비밀번호에 숫자, 특수문자가 포함되어야 합니다.");
        }else if (!matcher_alpha.find()){
        	mesg = 2;
        	// System.out.println("비밀번호에 영문자 대소문자가 적어도 하나씩은 포함되어야 합니다.");
        }
        
        request.setAttribute("mesg", mesg);
        RequestDispatcher dis = request.getRequestDispatcher("mesg/message.jsp");
        dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
