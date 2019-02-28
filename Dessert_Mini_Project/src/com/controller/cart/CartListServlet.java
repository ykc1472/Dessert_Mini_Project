package com.controller.cart;

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
import com.service.CartService;

@WebServlet("/cartList")
public class CartListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mesg = null;
		String nextPage = null;
		
		if(session.getAttribute("loginInfo") == null) {
			String url =  request.getHeader("referer");
			url = url.substring(url.indexOf(request.getContextPath())+request.getContextPath().length()+1, url.length());
			session.setAttribute("backPage", url);
			mesg = "로그인이 필요한 작업입니다.";
			nextPage = "loginForm.jsp";
			request.setAttribute("mesg", mesg);
			
		} else {
			String userid = ((MemberDTO)session.getAttribute("loginInfo")).getUserid();
			List<OrderDTO> cartList = null;
			CartService service = new CartService();
			cartList = service.selectCartList(userid);
			request.setAttribute("cartList", cartList);
			nextPage = "cartListForm.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
