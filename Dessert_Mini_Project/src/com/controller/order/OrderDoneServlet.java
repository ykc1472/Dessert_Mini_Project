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

@WebServlet("/orderDone")
public class OrderDoneServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String[] fcode = null;
		String[] foption = null;
		String[] amount = null;
		
		int post = 0;
		String address_f = null;
		String address_l = null;
		String nextPage = null;
		String mesg = null;
		int payMethod = 0;
		int payment = 0;
		
		
		if(request.getParameter("foption") == null || request.getParameter("fcode") == null || request.getParameter("amount") == null ){
			mesg = "잘못된 접근입니다.";
			nextPage = "main";
			request.setAttribute("mesg", mesg);
		} else if (session.getAttribute("loginInfo") == null) {
			mesg = "로그인이 필요한 작업입니다.";
			nextPage = "loginForm.jsp";
			request.setAttribute("mesg", mesg);
			
		} else {
			List<OrderDTO> orderList = new ArrayList<>();
			fcode = request.getParameterValues("fcode");
			foption = request.getParameterValues("foption");
			amount = request.getParameterValues("amount");
			
			post = Integer.parseInt(request.getParameter("post"));
			address_f = request.getParameter("addr1");
			address_l = request.getParameter("addr2");
			payment = Integer.parseInt(request.getParameter("payment"));
			payMethod = Integer.parseInt(request.getParameter("payMethod"));
			
			OrderService service = new OrderService();
			String userid = ((MemberDTO)session.getAttribute("loginInfo")).getUserid();
			for(int i = 0 ; i < fcode.length ; i++) {
				orderList.add(new OrderDTO(fcode[i], Integer.parseInt(foption[i]), userid, Integer.parseInt(amount[i]), post, address_f, address_l, payMethod, payment));
			}
			int success = service.orderDone(orderList);
			request.setAttribute("orderUserInfo", service.orderUserInfo(userid));
			request.setAttribute("orderCount", success);
			request.setAttribute("orderList", orderList);
			nextPage = "orderDone.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
