package com.controller.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.OrderService;

@WebServlet("/orderDone")
public class OrderDoneServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String[] fcode = null;
		String[] foption = null;
		String[] amount = null;
		String payment = null;
		String post = null;
		String address_f = null;
		String address_l = null;
		String nextPage = null;
		String mesg = null;
		int payMethod = 0;
		
		
		if(request.getParameter("foption") == null || request.getParameter("fcode") == null || request.getParameter("amount") == null ){
			mesg = "잘못된 접근입니다.";
			nextPage = "main";
			
		} else if (session.getAttribute("loginInfo") == null) {
			mesg = "로그인이 필요한 작업입니다.";
			nextPage = "loginForm.jsp";
			
		} else {
			
			fcode = request.getParameterValues("fcode");
			foption = request.getParameterValues("foption");
			amount = request.getParameterValues("amount");
			payment = request.getParameter("payment");
			post = request.getParameter("post");
			address_f = request.getParameter("post");
			address_l = request.getParameter("post");
			post = request.getParameter("post");
			
			OrderService service = new OrderService();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
