package com.controller.food;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.PagingFoodListDTO;
import com.service.FoodService;

@WebServlet("/SearchingFoodList")
public class SearchingFoodListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ftitle = request.getParameter("search");
		PagingFoodListDTO paging = new PagingFoodListDTO();
		String nextPage = null;
		if(request.getParameter("page") != null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
		}
		FoodService service = new FoodService();
		if(ftitle != null) {
			paging.setFtitle(ftitle);
			paging = service.searchingList(paging);
			nextPage = "foodListForm.jsp";
			request.setAttribute("flist", paging);
		}else {
			request.setAttribute("mesg", "잘못된 접근입니다.");
			nextPage = "main";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
