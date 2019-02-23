package com.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.FoodInfoDTO;
import com.dto.PagingFoodListDTO;
import com.service.FoodService;

@WebServlet("/NewFoodList")
public class FoodNewListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PagingFoodListDTO paging = new PagingFoodListDTO();
		if (request.getParameter("page") != null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
		}
		
		FoodService service = new FoodService();
		String nextPage = null;
		
		paging = service.foodList(paging);
		request.setAttribute("flist", paging);
		nextPage = "foodListForm.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
