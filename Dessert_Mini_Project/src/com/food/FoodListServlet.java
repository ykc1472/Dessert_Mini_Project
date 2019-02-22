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
import com.service.FoodServlice;

@WebServlet("/FoodList")
public class FoodListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<FoodInfoDTO> list = null;
		FoodServlice service = new FoodServlice();
		String nextPage = null;
		int fcategory;
		if(request.getParameter("category") != null) {
			fcategory = Integer.parseInt(request.getParameter("category"));
			list = service.foodList(fcategory);
			request.setAttribute("flist", list);
			nextPage = "foodListForm.jsp";
		} else{
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
