package com.controller.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.FoodInfoDTO;
import com.service.FoodService;
@WebServlet("/foodForm")
public class FoodFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fcode = request.getParameter("fcode");
		String nextPage = null;
		FoodService service = new FoodService();
		if(fcode != null) {
			List<FoodInfoDTO> foodinfoList = service.foodInfo(fcode);
			if (foodinfoList != null) {
				request.setAttribute("foodinfoList", foodinfoList);
				nextPage = "foodForm.jsp";
			} else {
				request.setAttribute("mesg", fcode + "에 해당하는 상품정보가 없습니다.");
				nextPage = "main";
			}
		} else {
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
