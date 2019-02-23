package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.PagingQnABoardDTO;
import com.service.QnABoardService;

@WebServlet("/QnABoardListForm")
public class QnABoardListFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnABoardService service = new QnABoardService();
		PagingQnABoardDTO paging = new PagingQnABoardDTO();
		if(request.getParameter("page") != null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
		}
		paging = service.selectAllQnABorder(paging);
		
		request.setAttribute("paging", paging);
		RequestDispatcher dis = request.getRequestDispatcher("qna_boardListForm.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
