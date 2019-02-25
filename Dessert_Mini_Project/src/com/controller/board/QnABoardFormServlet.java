package com.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.QnABoardDTO;
import com.service.QnABoardService;

@WebServlet("/QnABoardForm")
public class QnABoardFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("pick") != null) {
			int pick = Integer.parseInt(request.getParameter("pick"));
			
			QnABoardService service = new QnABoardService();
			QnABoardDTO dto = service.seleclt(pick);
			
			request.setAttribute("QnABoard", dto);
		}

		RequestDispatcher dis = request.getRequestDispatcher("qna_boardForm.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
