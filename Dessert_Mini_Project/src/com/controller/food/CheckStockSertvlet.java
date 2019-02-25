package com.controller.food;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.FoodService;

@WebServlet("/checkStock")
public class CheckStockSertvlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fcode = null;
		int foption = 0;
		boolean flag = true;
		String mesg = null;
		if(request.getParameter("foption") == null) {
			flag = false;
			mesg = "잘못된 접근입니다.";
		}
		if( request.getParameter("fcode") == null) {
			flag = false;
			mesg = "잘못된 접근입니다.";
		}
		if(flag) {
			fcode = request.getParameter("fcode");
			foption = Integer.parseInt(request.getParameter("foption"));
			FoodService service = new FoodService();
			request.setAttribute("mesg", service.checkStock(fcode, foption));
			
		}else {
			request.setAttribute("mesg", mesg);
		}
		RequestDispatcher dis = request.getRequestDispatcher("mesg/message.jsp");
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
