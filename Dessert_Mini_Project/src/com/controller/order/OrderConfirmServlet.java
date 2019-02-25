package com.controller.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.MemberDTO;
import com.dto.OrderDTO;
import com.service.OrderService;

import ch.qos.logback.core.net.SyslogOutputStream;
@WebServlet("/orderConfirm")
public class OrderConfirmServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String nextPage = null;
		String mesg = null;
		String[] amount = null;
		String[] fcode = null;
		String[] foption = null;
		
		if(request.getParameterValues("amount") == null || request.getParameterValues("fcode") == null || request.getParameterValues("foption") == null) {
			mesg = "잘못된 접근입니다.";
			nextPage = "main.jsp";
			request.setAttribute("mesg", mesg);
		}else {
			amount = request.getParameterValues("amount");
			fcode = request.getParameterValues("fcode");
			foption = request.getParameterValues("foption");
		}
		
		if(session.getAttribute("loginInfo") == null) {
			mesg = "로그인이 필요한 작업입니다.";
			nextPage = "loginForm.jsp";
			request.setAttribute("mesg", mesg);
		} else {
			String userid = ((MemberDTO)session.getAttribute("loginInfo")).getUserid();
			List<OrderDTO> orderList = new ArrayList<>();
			for(int i = 0 ; i < amount.length ; i ++) {
				orderList.add(new OrderDTO(fcode[i], Integer.parseInt(foption[i]), userid, Integer.parseInt(amount[i])));
			}
			OrderService service = new OrderService();
			orderList = service.orderConfirm(orderList);
			MemberDTO orderUserInfo = service.orderUserInfo(userid);

			request.setAttribute("orderUserInfo", orderUserInfo);
			request.setAttribute("orderList", orderList);
			nextPage = "orderConfirm.jsp";
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
