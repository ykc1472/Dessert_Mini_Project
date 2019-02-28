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

@WebServlet("/cartAdd")
public class CartAddServlet extends HttpServlet {
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
			String url =  request.getHeader("referer");
			url = url.substring(url.indexOf(request.getContextPath())+request.getContextPath().length()+1, url.length());
			session.setAttribute("backPage", url);
			mesg = "로그인이 필요한 작업입니다.";
			nextPage = "loginForm.jsp";
			request.setAttribute("mesg", mesg);
		} else {
			String userid = ((MemberDTO)session.getAttribute("loginInfo")).getUserid();
			List<OrderDTO> cartList = new ArrayList<>();
			for(int i = 0 ; i < amount.length ; i ++) {
				cartList.add(new OrderDTO(fcode[i], Integer.parseInt(foption[i]), userid, Integer.parseInt(amount[i])));

			}
			System.out.println(cartList);
			CartService service = new CartService();
			List<OrderDTO> list = service.addCart(cartList);
			if(list.size() == 0) {
				request.setAttribute("success", cartList.size());
				nextPage = "cartAddForm.jsp";
			} else {
				nextPage = request.getHeader("referer");
				nextPage = nextPage.substring(nextPage.indexOf(request.getContextPath())+request.getContextPath().length()+1, nextPage.length());
				mesg = list.size()+"개의  등록된 같은 제품이 있습니다.";
				session.setAttribute("mesg", mesg);
			}
				
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
